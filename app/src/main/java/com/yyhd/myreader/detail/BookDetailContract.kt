package com.yyhd.myreader.detail

import com.yyhd.base.BasePresenter
import com.yyhd.base.BaseView
import com.yyhd.myreader.db.Book

/**
 * Created by hanli
 * date 2020-08-21.
 * ps: 书本详情
 */
class BookDetailContract {

    interface Presenter : BasePresenter {

        fun loadBookDetail(book : Book)
    }

    interface View : BaseView<Presenter> {

        fun fillData(book : Book)
    }
}