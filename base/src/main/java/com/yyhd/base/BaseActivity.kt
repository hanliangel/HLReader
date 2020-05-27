package com.yyhd.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife

/**
 * Created by hanli
 * date 2020-05-12.
 * ps:
 */
open abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())
        ButterKnife.bind(this)
        init(savedInstanceState)
    }


    /**
     * 返回布局的id
     */
    protected abstract fun getLayoutId() : Int

    /**
     * 初始化
     */
    protected abstract fun init(savedInstanceState: Bundle?)
}