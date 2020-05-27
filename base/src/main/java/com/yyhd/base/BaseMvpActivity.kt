package com.yyhd.base

import android.os.Bundle
import com.blankj.utilcode.util.FragmentUtils

/**
 * Created by hanli
 * date 2020-05-12.
 * ps:
 */
open abstract class BaseMvpActivity<V : BaseMvpFragment<out BasePresenter>> : BaseActivity() {

    protected lateinit var mCurrentFragment: V

    /**
     * 初始化
     */
    protected abstract fun init(savedInstanceState : Bundle? , fragment : V)

    /**
     * 创建当前的activity对应的fragment对象
     */
    protected abstract fun createMvpFragment() : V

    override fun getLayoutId(): Int {
        return R.layout.activity_base_mvp
    }

    override fun init(savedInstanceState: Bundle?) {
        FragmentUtils.removeAll(supportFragmentManager)
        mCurrentFragment = createMvpFragment()
        FragmentUtils.add(supportFragmentManager , mCurrentFragment , R.id.fl_root)

        init(savedInstanceState , mCurrentFragment)
    }
}