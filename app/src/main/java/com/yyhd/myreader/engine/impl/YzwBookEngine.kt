package com.yyhd.myreader.engine.impl

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ObjectUtils
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.db.table.Chapter
import com.yyhd.myreader.engine.BaseBookEngine
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.safety.Whitelist
import java.lang.Exception

/**
 * Created by hanli
 * date 2021-03-14.
 * ps:
 */
class YzwBookEngine : BaseBookEngine() {


    val baseYzwUrl = "http://www.huoyzw.com"


    override fun searchBook(searchStr: String): List<Book> {
        var booklist = ArrayList<Book>()
        try{
            var document = getDocument("http://www.huoyzw.com/modules/article/search.php?searchkey=${searchStr}")
            val noverlistElements = document.getElementsByClass("novelslist2")
            if(ObjectUtils.isNotEmpty(noverlistElements)){
                val noverChildrens = noverlistElements[0].children()
                val searchList = noverChildrens[1].children()
                if(searchList != null && searchList.size > 1){
                    for(i in 1 until searchList.size){
                        val booknameElement = searchList[i].child(1)
                        val authorElement = searchList[i].child(3)
                        val bookname = booknameElement.child(0).text()
                        val bookDetailUrl = baseYzwUrl + booknameElement.child(0).attr("href")
                        val authorName = authorElement.text()
                        val book = Book()
                        book.bookName = bookname
                        book.bookDetailUrl = bookDetailUrl
                        book.author = authorName
                        booklist.add(book)
                    }
                }
            }
        } catch (e : Exception){
            e.printStackTrace()
        }
        return booklist
    }

    override fun getBookDetail(book: Book) {
        try {
            // 填充基本信息
            var document = getDocument(book.bookDetailUrl)
            val coverElement = document.getElementById("fmimg")
            val introElement = document.getElementById("intro")
            val coverUrl = baseYzwUrl + coverElement.child(0).attr("src")
            var introduction = introElement.html()
            introduction = Jsoup.clean(introduction , "" , Whitelist.none() , Document.OutputSettings().prettyPrint(false))
            book.coverUrl = coverUrl
            book.introduction = introduction

            // 获取章节列表
            val listElement = document.getElementById("list")
            val chapters = listElement.child(0).children()
            var isMainChapter = false
            var chapterList = ArrayList<Chapter>()
            for(chapter in chapters){
                val chapterText = chapter.text()
                if(ObjectUtils.isNotEmpty(chapterText) && chapterText.contains("正文")){
                    isMainChapter = true
                }

                if(!isMainChapter){
                    continue
                }
                val chapterChildren = chapter.children()
                if(chapterChildren != null && chapterChildren.size > 0){
                    val chapterTitle = chapterChildren[0].text()
                    val chapterDetailUrl = baseYzwUrl + chapterChildren[0].attr("href")
                    val chapterObj = Chapter(chapterTitle)
                    chapterObj.url = chapterDetailUrl
                    chapterList.add(chapterObj)
                    LogUtils.i("getBookDetail  chapterTitle: $chapterTitle  chapterDetailUrl: $chapterDetailUrl")
                }
            }
            book.chapters = chapterList
        } catch (e : Exception){
            e.printStackTrace()
        }
    }

    override fun getChapterContent(chapter: Chapter) {
        try {
            var document = getDocument(chapter.url)
            val contentElement = document.getElementById("content")
            var textContent = contentElement.html()
            textContent = Jsoup.clean(textContent , "" , Whitelist.none() , Document.OutputSettings().prettyPrint(false))
            chapter.content = getContentFromHtml(textContent)
        } catch (e : Exception){
            e.printStackTrace()
        }
    }


    override fun getEngineName(): String {
        return "35小说网"
    }

}