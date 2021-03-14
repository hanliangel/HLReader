package com.yyhd.myreader.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.yyhd.base.BaseMvpActivity
import com.yyhd.myreader.db.table.Book

/**
 * Created by hanli
 * date 2020-08-21.
 * ps: 书本详情界面
 */
class BookDetailActivity : BaseMvpActivity<BookDetailFragment>() {

    override fun init(savedInstanceState: Bundle?, fragment: BookDetailFragment) {

    }

    override fun createMvpFragment(): BookDetailFragment {
        val bookDetailFragment = BookDetailFragment()
        bookDetailFragment.arguments = intent.extras
        return bookDetailFragment
    }


    companion object {
        fun startActivity(context: Context , book: Book){
            val bundle = Bundle()
            bundle.putSerializable(BookDetailFragment.PARAM_KEY_BOOK, book)
            val intent = Intent(context , BookDetailActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

}