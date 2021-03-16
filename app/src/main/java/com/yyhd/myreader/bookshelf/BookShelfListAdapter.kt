package com.yyhd.myreader.bookshelf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.yyhd.base.BaseRecycleAdapter
import com.yyhd.myreader.R
import com.yyhd.myreader.R2
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.detail.BookDetailActivity

/**
 * Created by hanli
 * date 2021-02-28.
 * ps: 书架adapter
 */
class BookShelfListAdapter : BaseRecycleAdapter<Book, BookShelfListAdapter.BookShelfItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookShelfItemHolder {
        return BookShelfItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_bookshelf_list , parent , false))
    }

    override fun onBindViewHolder(holder: BookShelfItemHolder, position: Int) {
        var bean = getItemBean(position)
        Glide.with(holder.itemView.context)
            .load(bean.coverUrl)
            .error(R.drawable.book_cover_placeholder)
            .placeholder(R.drawable.book_cover_placeholder)
            .into(holder.ivCover)

        holder.tvBookName.text = bean.bookName
        holder.tvAuthorName.text = bean.author
        holder.tvIntroduction.text = bean.introduction
        holder.tvEngineName.text = bean.engineName

        holder.itemView.setOnClickListener { v -> BookDetailActivity.startActivity(v.context , bean) }
    }


    class BookShelfItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivCover : ImageView = itemView.findViewById(R.id.iv_cover)

        var tvBookName : TextView = itemView.findViewById(R.id.tv_book_name)

        var tvAuthorName : TextView = itemView.findViewById(R.id.tv_author)

        var tvIntroduction : TextView = itemView.findViewById(R.id.tv_introduction)

        var tvEngineName : TextView = itemView.findViewById(R.id.tv_engine_name)

    }
}