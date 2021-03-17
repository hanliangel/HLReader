package com.yyhd.myreader.bookshelf

import android.appwidget.AppWidgetHostView
import com.yyhd.base.BaseMvpPresenter
import com.yyhd.myreader.db.DBManager
import com.yyhd.myreader.db.table.Book

/**
 * Created by hanli
 * date 2020-05-14.
 * ps:
 */
class BookshelfPresenter(view : BookshelfContract.View) : BookshelfContract.Presenter , BaseMvpPresenter<BookshelfContract.View>(view) {

    override fun loadAll(): MutableList<Book> {
        val bookList = DBManager.mDaoSession.bookDao.loadAll()
        view.fillData(bookList)
        return bookList
    }
}