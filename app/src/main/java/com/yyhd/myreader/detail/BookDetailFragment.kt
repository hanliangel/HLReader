package com.yyhd.myreader.detail

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.blankj.utilcode.util.ToastUtils
import com.yyhd.base.BaseMvpFragment
import com.yyhd.base.widget.rerycleview.HeaderAndFooterRecycleView
import com.yyhd.myreader.R
import com.yyhd.myreader.db.Book
import com.yyhd.myreader.db.Chapter

/**
 * Created by hanli
 * date 2020-08-21.
 * ps:
 */
open class BookDetailFragment : BaseMvpFragment<BookDetailContract.Presenter>() , BookDetailContract.View{


    lateinit var book : Book

    lateinit var chapterAdapter : ChapterAdapter

    @BindView(R.id.recycle_view)
    lateinit var recycleView : HeaderAndFooterRecycleView

    init {
        setPresenter(BookDetailPresenter(this))
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_bookdetail
    }

    override fun initValues(arguments: Bundle?) {
        arguments?.let {
            book = arguments.getSerializable(PARAM_KEY_BOOK) as Book

            val headerView = View.inflate(activity , R.layout.book_detail_header , null)
            val tvBookName = headerView.findViewById<TextView>(R.id.tv_book_name)
            val tvAuthorName = headerView.findViewById<TextView>(R.id.tv_author)

            tvBookName.text = book.bookName
            tvAuthorName.text = book.author

            recycleView.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            chapterAdapter = ChapterAdapter()
            recycleView.adapter =chapterAdapter

            recycleView.addHeader(headerView)

            getPresenter().loadBookDetail(book)
        }
    }

    override fun initView(savedInstanceState: Bundle?, rootView: View) {

    }

    override fun fillData(book: Book) {
        chapterAdapter.setData(book.Chapters)
    }

    companion object {
        val PARAM_KEY_BOOK = "PARAM_KEY_BOOK"
    }
}