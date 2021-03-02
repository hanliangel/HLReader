package com.yyhd.myreader.bookshelf

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yyhd.base.BaseRecycleAdapter
import com.yyhd.myreader.db.table.Book

/**
 * Created by hanli
 * date 2021-02-28.
 * ps:
 */
class BookShelfListAdapter : BaseRecycleAdapter<Book, BookShelfListAdapter.BookShelfItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookShelfItemHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BookShelfItemHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class BookShelfItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}