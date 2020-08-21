package com.yyhd.myreader.engine

import com.yyhd.myreader.db.Book

/**
 * Created by hanli
 * date 2020-05-28.
 * ps:
 */
class BequgeBookEngine : BaseBookEngine() {
    override fun getBookDetail(book: Book) {

    }

    override fun searchBook(searchStr: String): List<Book> {
        var bookList = ArrayList<Book>()
        return bookList
    }
}