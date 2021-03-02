package com.yyhd.myreader.search

import com.yyhd.base.BasePresenter
import com.yyhd.base.BaseView
import com.yyhd.myreader.db.table.Book

/**
 * Created by hanli
 * date 2020-05-27.
 * ps: 搜索
 */
class SearchContract {

    interface Presenter : BasePresenter {
        /**
         * 搜索书本
         */
        fun searchBook(searchStr : String?)
    }

    interface View : BaseView<Presenter> {

        fun fillData(bookList : List<Book>)
    }
}