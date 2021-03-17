package com.yyhd.myreader.bookshelf

import com.yyhd.base.BasePresenter
import com.yyhd.base.BaseView
import com.yyhd.myreader.db.table.Book

/**
 * Created by hanli
 * date 2019-10-18.
 * ps: 书架的契约类
 */
class BookshelfContract {

    interface Presenter : BasePresenter{
        fun loadAll() : MutableList<Book>
    }

    interface View : BaseView<Presenter>{
        fun fillData(bookList: MutableList<Book>)
    }

}