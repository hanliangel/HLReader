package com.yyhd.myreader.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yyhd.base.BaseRecycleAdapter
import com.yyhd.myreader.R
import com.yyhd.myreader.db.table.Chapter

/**
 * Created by hanli
 * date 2020-08-24.
 * ps:
 */
class ChapterAdapter : BaseRecycleAdapter<Chapter, ChapterAdapter.ViewHolder>() {

    lateinit var chapterListListener : ChapterListListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_chapter , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBean = getItemBean(position)
        holder.tvChapter.text = itemBean.name
        holder.itemView.setOnClickListener {
            chapterListListener?.let {
                chapterListListener.onItemClick(position)
            }
        }
    }



    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tvChapter : TextView = itemView.findViewById(R.id.tv_chapter_name)

    }


    interface ChapterListListener {

        abstract fun onItemClick(index : Int)
    }
}