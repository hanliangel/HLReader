package com.yyhd.base

import com.yyhd.base.widget.LoadingDialog

/**
 * Created by hanli
 * date 2019-10-21.
 * ps: 公共的mvp结构的fragment
 */
open abstract class BaseMvpFragment<T : BasePresenter> : BaseFragment , BaseView<T>{

    /**
     * 当前界面对应的presenter
     */
    lateinit var mPresenter : T

    var loadingDialog : LoadingDialog? = null

    constructor()

    override fun setPresenter(presenter : T){
        this.mPresenter = presenter
    }

    override fun getPresenter() : T {
        return mPresenter
    }

    override fun showLoading() {
        dismissLoading()
        loadingDialog = LoadingDialog(context!!)
        loadingDialog?.show()
    }

    override fun dismissLoading() {
        if(loadingDialog != null && loadingDialog!!.isShowing){
            loadingDialog?.dismiss()
        }
    }
}