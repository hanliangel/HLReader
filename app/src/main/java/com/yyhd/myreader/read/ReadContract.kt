package com.yyhd.myreader.read

import com.yyhd.base.BasePresenter
import com.yyhd.base.BaseView
import com.yyhd.myreader.db.table.Chapter

/**
 * Created by hanli
 * date 2020-08-28.
 * ps:
 */
class ReadContract {

    interface Presenter : BasePresenter {

        /**
         * 加载一个章节的内容，如果本地有缓存，那么直接使用本地的，否则从网络加载
         */
        fun loadChapter(chapter: Chapter)
    }

    interface View : BaseView<Presenter> {

        /**
         * 显示当前章节内容
         */
        fun fillData(chapter: Chapter)
    }
}