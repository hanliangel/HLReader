package com.yyhd.myreader.bookshelf

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.yyhd.base.BaseMvpFragment
import com.yyhd.myreader.R

/**
 * Created by hanli
 * date 2020-05-14.
 * ps: 书架页面
 */
class BookshelfFragment : BaseMvpFragment<BookshelfContract.Presenter>(), BookshelfContract.View{

    /**
     * 书架列表
     */
    @BindView(R.id.recycle_view)
    lateinit var recycleView: RecyclerView

    override fun initView(savedInstanceState: Bundle?, rootView: View) {

    }

    override fun initValues(arguments: Bundle?) {

    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_bookshelf
    }


}