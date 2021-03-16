package com.yyhd.myreader.search

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.OnClick
import com.blankj.utilcode.util.ObjectUtils
import com.blankj.utilcode.util.ToastUtils
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.yyhd.base.BaseMvpFragment
import com.yyhd.base.widget.NoBottomDividerItemDecoration
import com.yyhd.myreader.R
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.engine.BaseBookEngine
import com.yyhd.myreader.engine.BiqukanBookEngine
import com.yyhd.myreader.engine.EngineFactory

/**
 * Created by hanli
 * date 2020-05-27.
 * ps: 搜索结果的页面
 */
class SearchFragment : BaseMvpFragment<SearchContract.Presenter>() , SearchContract.View{

    @BindView(R.id.tv_test)
    lateinit var textView: TextView

    @BindView(R.id.floating_search_view)
    lateinit var searchView : MaterialSearchView

    @BindView(R.id.recycle_view)
    lateinit var recyclerView: RecyclerView

    lateinit var searchResultAdapter : SearchResultAdapter

    init {
        setPresenter(SearchPresenter(this))
    }

    override fun initValues(arguments: Bundle?) {

        activity?.let {
            recyclerView.layoutManager = LinearLayoutManager(it , LinearLayoutManager.VERTICAL , false)
            val dividerItemDecoration =
                NoBottomDividerItemDecoration(it, DividerItemDecoration.VERTICAL)
            dividerItemDecoration.setDrawable(it.resources.getDrawable(R.drawable.common_divider_list_grey_8dp))
            recyclerView.addItemDecoration(dividerItemDecoration)
        }

        searchResultAdapter = SearchResultAdapter()
        recyclerView.setAdapter(searchResultAdapter)
    }

    override fun initView(savedInstanceState: Bundle?, rootView: View) {
        searchView.showSearch(false)
        searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                getPresenter().searchBook(query)
                showLoading()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    @OnClick(R.id.bt_search)
    fun clickStartSearch(){
        searchView.showSearch(false)
    }

    override fun fillData(bookList : List<Book>){
        if(ObjectUtils.isEmpty(bookList)){
            ToastUtils.showShort("没有搜到东西啊！")
        }
        searchResultAdapter.setData(bookList)
        dismissLoading()
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }


}