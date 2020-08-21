package com.yyhd.myreader.search

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ObjectUtils
import com.blankj.utilcode.util.ProcessUtils
import com.miguelcatalan.materialsearchview.MaterialSearchView
import com.yyhd.base.BaseMvpFragment
import com.yyhd.base.widget.NoBottomDividerItemDecoration
import com.yyhd.myreader.R
import com.yyhd.myreader.db.Book
import com.yyhd.myreader.engine.BaseBookEngine
import com.yyhd.myreader.engine.BequgeBookEngine
import com.yyhd.myreader.engine.BiqukanBookEngine
import com.yyhd.myreader.engine.BookEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

    lateinit var bookEngine: BaseBookEngine

    override fun initValues(arguments: Bundle?) {
        bookEngine = BiqukanBookEngine()

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
                GlobalScope.launch(Dispatchers.IO) {
                    query?.let {
                        val bookList = bookEngine.searchBook(query)
                        withContext(Dispatchers.Main){
                            fillData(bookList)
                            textView.setText("成功加载嘿嘿")
                            LogUtils.i("当前的线程：" + Thread.currentThread().name + " -- 结果大小：" + bookList.size)
                        }
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    fun fillData(bookList : List<Book>){
        searchResultAdapter.setData(bookList)
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }


}