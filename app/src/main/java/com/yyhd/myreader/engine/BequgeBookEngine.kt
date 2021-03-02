package com.yyhd.myreader.engine

import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.db.table.Chapter

/**
 * Created by hanli
 * date 2020-05-28.
 * ps:
 */
class BequgeBookEngine : BaseBookEngine() {
    override fun getChapterContent(chapter: Chapter) {
    }

    override fun getBookDetail(book: Book) {

    }

    override fun searchBook(searchStr: String): List<Book> {
        var bookList = ArrayList<Book>()
        return bookList
    }
}