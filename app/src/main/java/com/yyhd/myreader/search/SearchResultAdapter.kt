package com.yyhd.myreader.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.yyhd.base.BaseRecycleAdapter
import com.yyhd.myreader.R
import com.yyhd.myreader.db.Book

/**
 * Created by hanli
 * date 2020-08-21.
 * ps: 搜索结果列表的adapter
 */
class SearchResultAdapter : BaseRecycleAdapter<Book , SearchResultAdapter.SearchResultHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultHolder {
        return SearchResultHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search_result , parent , false))
    }

    override fun onBindViewHolder(holder: SearchResultHolder, position: Int) {
        val book = getItemBean(position)
        holder.tvBookName.setText(book.bookName)
        holder.tvAuthorName.setText(book.author)
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    class SearchResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.tv_book_name)
        lateinit var tvBookName : TextView

        @BindView(R.id.tv_author)
        lateinit var tvAuthorName : TextView

        init {
            ButterKnife.bind(this , itemView)
        }



    }
}