package com.yyhd.myreader.bookshelf

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.yyhd.base.BaseMvpFragment
import com.yyhd.myreader.R
import com.yyhd.myreader.db.DBManager

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

    lateinit var adapter : BookShelfListAdapter

    override fun initView(savedInstanceState: Bundle?, rootView: View) {

    }

    override fun initValues(arguments: Bundle?) {
        val bookList = DBManager.mDaoSession.bookDao.loadAll()
        adapter = BookShelfListAdapter()
        adapter.data = bookList

        recycleView.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
        recycleView.adapter = adapter
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_bookshelf
    }


}