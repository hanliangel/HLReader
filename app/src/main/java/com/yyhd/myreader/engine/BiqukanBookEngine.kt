package com.yyhd.myreader.engine

import com.blankj.utilcode.util.LogUtils
import com.yyhd.myreader.db.Book
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
        return bookList
    }

    override fun getBookDetail(book: Book) {
        var document = getDocument(book.bookDetailUrl)
        LogUtils.i("getBookDetail  document: $document")
    }
}