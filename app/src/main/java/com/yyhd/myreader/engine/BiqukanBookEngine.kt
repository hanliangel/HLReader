package com.yyhd.myreader.engine

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ObjectUtils
import com.yyhd.myreader.db.Book
import com.yyhd.myreader.db.Chapter
import org.jsoup.nodes.Document
import java.net.URLEncoder

/**
 * Created by hanli
 * date 2020-05-28.
 * ps:
 */
class BiqukanBookEngine : BaseBookEngine() {

    override fun searchBook(searchStr: String): List<Book> {
        var bookList = ArrayList<Book>()
        try {
            var document = getDocument("https://so.biqusoso.com/s.php?ie=gbk&siteid=biqukan.com&s=2758772450457967865&q=${URLEncoder.encode(searchStr , "GBK")}")
            LogUtils.i("searchBook  document:$document")
            val searchListElement = document.getElementsByClass("search-list")
            val ulElement = searchListElement[0].children()[1]
            val bookElements = ulElement.children()
            LogUtils.i("formElement  ulElement:$ulElement")
            for(i in 1 until bookElements.size){
                val bookElement = bookElements[i]
                val spanElements = bookElement.children()
                val bookDetailUrl = spanElements[1].child(0).attr("href")
                val bookName = spanElements[1].child(0).text()
                val authorName = spanElements[2].text()
                val book = Book(bookName)
                book.author = authorName
                book.bookDetailUrl = bookDetailUrl
                LogUtils.i("book : $book")
                bookList.add(book)
            }
        } catch (e : Exception){
            e.printStackTrace()
        }
        return bookList
    }

    override fun getBookDetail(book: Book) {
        try {
            var document = getDocument(book.bookDetailUrl)
            val elementListmain = document.getElementsByClass("listmain")
            val chapters = elementListmain[0].children()[0].children()
            var isMainChapter = false
            var chapterList = ArrayList<Chapter>()
            for(chapter in chapters){
                val chapterText = chapter.text()
                if(ObjectUtils.isNotEmpty(chapterText) && chapterText.contains("正文卷")){
                    isMainChapter = true
                }

                if(!isMainChapter){
                    continue
                }
                val chapterChildren = chapter.children()
                if(chapterChildren != null && chapterChildren.size > 0){
                    val chapterTitle = chapterChildren[0].text()
                    val chapterDetailUrl = chapterChildren[0].attr("href")
                    val chapterObj = Chapter(chapterTitle)
                    chapterObj.url = chapterDetailUrl
                    chapterList.add(chapterObj)
                    LogUtils.i("getBookDetail  chapterTitle: $chapterTitle  chapterDetailUrl: $chapterDetailUrl")
                }
            }
//            LogUtils.i("getBookDetail  document: $document")
            book.Chapters = chapterList
        } catch (e : Exception){
            e.printStackTrace()
        }
    }
}