package com.yyhd.myreader.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yyhd.base.BaseRecycleAdapter
import com.yyhd.myreader.R
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.detail.BookDetailActivity
import com.yyhd.myreader.detail.BookDetailFragment

/**
 * Created by hanli
 * date 2020-08-21.
 * ps: 搜索结果列表的adapter
 */
class SearchResultAdapter : BaseRecycleAdapter<Book, SearchResultAdapter.SearchResultHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultHolder {
        return SearchResultHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_search_result , parent , false))
    }

    override fun onBindViewHolder(holder: SearchResultHolder, position: Int) {
        val book = getItemBean(position)
        holder.tvBookName.setText(book.bookName)
        holder.tvAuthorName.setText(book.author)

        holder.itemView.setOnClickListener { v ->
            val bundle = Bundle()
            bundle.putSerializable(BookDetailFragment.PARAM_KEY_BOOK, book)
            BookDetailActivity.startActivity(v.context, bundle)
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }

    class SearchResultHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvBookName : TextView = itemView.findViewById(R.id.tv_book_name)

        var tvAuthorName : TextView = itemView.findViewById(R.id.tv_author)

    }
}