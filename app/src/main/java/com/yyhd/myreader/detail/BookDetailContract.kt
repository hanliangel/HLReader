package com.yyhd.myreader.detail

import com.yyhd.base.BasePresenter
import com.yyhd.base.BaseView
import com.yyhd.myreader.db.table.Book

/**
 * Created by hanli
 * date 2020-08-21.
 * ps: 书本详情
 */
class BookDetailContract {

    interface Presenter : BasePresenter {

        fun loadBookDetail(book : Book)

        // 收藏
        fun collectBook(book : Book) : Boolean

        // 取消收藏
        fun cancelCollectBook(book : Book) : Boolean

        // 是否是已收藏的书本
        fun isCollect(book: Book) : Book?
    }

    interface View : BaseView<Presenter> {

        fun fillData(book : Book)
    }
}