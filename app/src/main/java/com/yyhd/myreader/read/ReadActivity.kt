package com.yyhd.myreader.read

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.RequiresPermission
import com.yyhd.base.BaseMvpActivity
import com.yyhd.myreader.db.Book

/**
 * Created by hanli
 * date 2020-08-28.
 * ps:
 */
class ReadActivity : BaseMvpActivity<ReadFragment>() {


    override fun createMvpFragment(): ReadFragment {
        val readFragment = ReadFragment()
        readFragment.arguments = intent.extras
        return readFragment
    }


    override fun init(savedInstanceState: Bundle?, fragment: ReadFragment) {
    }


    companion object {

        fun startActivity(context: Context , bundle: Bundle) {
            val intent = Intent(context , ReadActivity::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}