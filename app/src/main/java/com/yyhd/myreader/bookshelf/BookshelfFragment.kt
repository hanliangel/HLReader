package com.yyhd.myreader.bookshelf

import android.os.Bundle
import android.view.View
import com.yyhd.base.BaseMvpFragment
import com.yyhd.myreader.R

/**
 * Created by hanli
 * date 2020-05-14.
 * ps:
 */
class BookshelfFragment : BaseMvpFragment<BookshelfContract.Presenter>(), BookshelfContract.View{

    override fun initView(savedInstanceState: Bundle?, rootView: View) {
    }

    override fun initValues(arguments: Bundle?) {
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_bookshelf
    }


}