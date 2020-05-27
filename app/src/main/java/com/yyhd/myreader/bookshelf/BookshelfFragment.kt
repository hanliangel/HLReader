package com.yyhd.myreader.bookshelf

import com.yyhd.base.BaseMvpFragment
import com.yyhd.myreader.R

/**
 * Created by hanli
 * date 2020-05-14.
 * ps:
 */
class BookshelfFragment : BaseMvpFragment<BookshelfContract.Presenter>(), BookshelfContract.View{



    override fun getLayoutId(): Int {
        return R.layout.fragment_bookshelf;
    }


}