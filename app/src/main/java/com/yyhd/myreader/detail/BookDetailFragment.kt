package com.yyhd.myreader.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import butterknife.BindView
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.yyhd.base.BaseMvpFragment
import com.yyhd.base.event.CollectionChangedEvent
import com.yyhd.base.widget.rerycleview.HeaderAndFooterRecycleView
import com.yyhd.myreader.R
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.read.ReadActivity
import com.yyhd.myreader.read.ReadFragment
import org.greenrobot.eventbus.EventBus

/**
 * Created by hanli
 * date 2020-08-21.
 * ps:
 */
open class BookDetailFragment : BaseMvpFragment<BookDetailContract.Presenter>() , BookDetailContract.View
    , ChapterAdapter.ChapterListListener , View.OnClickListener{

    lateinit var book : Book

    lateinit var chapterAdapter : ChapterAdapter

    lateinit var headerView : LinearLayout

    @BindView(R.id.recycle_view)
    lateinit var recycleView : HeaderAndFooterRecycleView


    lateinit var tvBookName : TextView
    lateinit var tvAuthorName : TextView
    lateinit var tvIntroduction : TextView
    lateinit var btCollect : Button
    lateinit var ivCover : ImageView
    lateinit var tvEngineName : TextView

    /**
     * 当前是否收藏了
     */
    var isCollected = false



    companion object {
        val PARAM_KEY_BOOK = "PARAM_KEY_BOOK"
    }

    init {
        setPresenter(BookDetailPresenter(this))
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_bookdetail
    }

    override fun initValues(arguments: Bundle?) {
        arguments?.let {
            book = arguments.getSerializable(PARAM_KEY_BOOK) as Book
            val collectedBook = getPresenter().isCollect(book)
            if(collectedBook != null){
                isCollected = true
                book = collectedBook
            }

            recycleView.layoutManager = LinearLayoutManager(activity , LinearLayoutManager.VERTICAL , false)
            headerView = LayoutInflater.from(context).inflate(R.layout.book_detail_header , recycleView , false) as LinearLayout

            tvBookName = headerView.findViewById<TextView>(R.id.tv_book_name)
            tvAuthorName = headerView.findViewById<TextView>(R.id.tv_author)
            tvIntroduction = headerView.findViewById<TextView>(R.id.tv_introduction)
            btCollect = headerView.findViewById<Button>(R.id.bt_collect)
            ivCover = headerView.findViewById<ImageView>(R.id.iv_cover)
            tvEngineName = headerView.findViewById<TextView>(R.id.tv_engine_name)

            fillHeader(book)
            btCollect.setOnClickListener(this)

            chapterAdapter = ChapterAdapter()
            chapterAdapter.chapterListListener = this
            recycleView.adapter =chapterAdapter

            recycleView.addHeader(headerView)

            getPresenter().loadBookDetail(book)
            showLoading()
        }
    }

    override fun initView(savedInstanceState: Bundle?, rootView: View) {

    }

    override fun onItemClick(index: Int) {
        val context = activity
        context?.let {
            val bundle = Bundle()
            bundle.putSerializable(ReadFragment.PARAM_KEY_BOOK , book)
            bundle.putInt(ReadFragment.PARAM_KEY_CHAPTER_INDEX , index)
            ReadActivity.startActivity(context , bundle)
        }
    }

    override fun fillData(book: Book) {
        fillHeader(book)
        chapterAdapter.setData(book.chapters)
        dismissLoading()
    }

    /**
     * 填充header部分的文章信息相关
     */
    fun fillHeader(book : Book){
        tvBookName.text = book.bookName
        tvAuthorName.text = book.author
        tvIntroduction.text = book.introduction
        tvEngineName.text = book.engineName

        if(isCollected){
            btCollect.text = "取消收藏"
        } else {
            btCollect.text = "收藏"
        }

        Glide.with(context)
            .load(book.coverUrl)
            .error(R.drawable.book_cover_placeholder)
            .into(ivCover)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.bt_collect ->{
                // 点击了收藏
                if(isCollected){
                    if(getPresenter().cancelCollectBook(book)){
                        ToastUtils.showShort("取消收藏成功")
                        EventBus.getDefault().post(CollectionChangedEvent())
                        isCollected = false
                    } else {
                        ToastUtils.showShort("取消收藏失败")
                    }
                } else {
                    if(getPresenter().collectBook(book)){
                        ToastUtils.showShort("收藏成功")
                        EventBus.getDefault().post(CollectionChangedEvent())
                        isCollected = true
                    } else {
                        ToastUtils.showShort("收藏失败")
                    }
                }
                fillHeader(book)
            }
        }
    }
}