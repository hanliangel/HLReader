package com.yyhd.base

/**
 * Created by hanli
 * date 2019-10-21.
 * ps: 公共的mvp结构的fragment
 */
open class BaseMvpFragment<T : BasePresenter> : BaseFragment , BaseView<T>{

    /**
     * 当前界面对应的presenter
     */
    lateinit var mPresenter : T

    constructor()

    override fun setPresenter(presenter : T){
        this.mPresenter = presenter
    }

    override fun getPresenter() : T {
        return mPresenter
    }

}