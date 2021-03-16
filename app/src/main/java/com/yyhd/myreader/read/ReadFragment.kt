package com.yyhd.myreader.read

import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import com.blankj.utilcode.util.ToastUtils
import com.yyhd.base.BaseMvpFragment
import com.yyhd.myreader.R
import com.yyhd.myreader.R2
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.db.table.Chapter

/**
 * Created by hanli
 * date 2020-08-28.
 * ps: 阅读的页面
 */
class ReadFragment : BaseMvpFragment<ReadContract.Presenter>() , ReadContract.View{



    @BindView(R2.id.tv_chapter_content)
    lateinit var tv_content : TextView

    @BindView(R2.id.tv_last)
    lateinit var tv_last : TextView

    @BindView(R2.id.tv_next)
    lateinit var tv_next : TextView

    @BindView(R2.id.scroll_view)
    lateinit var scrollView : ScrollView

    lateinit var book: Book

    var currentChapterIndex : Int = 0

    init {
        setPresenter(ReadPresenter(this))
    }

    override fun fillData(chapter: Chapter) {
        tv_content.text = chapter.content
        scrollView.scrollTo(0 , 0)
    }

    override fun initValues(arguments: Bundle?) {
        arguments?.let {
            book = arguments.getSerializable(PARAM_KEY_BOOK) as Book
            currentChapterIndex = arguments.getInt(PARAM_KEY_CHAPTER_INDEX)

            getPresenter().loadChapter(book.chapters.get(currentChapterIndex))
        }

    }

    override fun initView(savedInstanceState: Bundle?, rootView: View) {

    }

    @OnClick(R.id.tv_next)
    fun clickNext(){
        if(currentChapterIndex == book.chapters.size -1){
            ToastUtils.showShort("已经看到最后了！")
            return
        }
        currentChapterIndex ++
        getPresenter().loadChapter(book.chapters.get(currentChapterIndex))
    }

    @OnClick(R.id.tv_last)
    fun clickLast(){
        if(currentChapterIndex == 0){
            ToastUtils.showShort("当前是第一章")
            return
        }
        currentChapterIndex --
        getPresenter().loadChapter(book.chapters.get(currentChapterIndex))
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_read
    }

    companion object {

        val PARAM_KEY_BOOK = "param_key_book"

        val PARAM_KEY_CHAPTER_INDEX = "param_key_chapter_index"
    }

}