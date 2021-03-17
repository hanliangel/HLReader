package com.yyhd.myreader.bookshelf

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.yyhd.base.BaseMvpFragment
import com.yyhd.base.event.CollectionChangedEvent
import com.yyhd.myreader.R
import com.yyhd.myreader.db.DBManager
import com.yyhd.myreader.db.table.Book
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

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

    init {
        setPresenter(BookshelfPresenter(this))
    }

    override fun initView(savedInstanceState: Bundle?, rootView: View) {

    }

    override fun initValues(arguments: Bundle?) {
        EventBus.getDefault().register(this)
        adapter = BookShelfListAdapter()


        recycleView.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
        recycleView.adapter = adapter

        val bookList = getPresenter().loadAll()
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_bookshelf
    }


    override fun fillData(bookList: MutableList<Book>) {
        adapter.data = bookList
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public open fun onCollectionChanged(event : CollectionChangedEvent){
        getPresenter().loadAll()
    }


    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}