package com.yyhd.base

/**
 * Created by hanli
 * date 2019-10-18.
 * ps: MVP中View的接口基类
 */
interface BaseView<T : BasePresenter> {

    fun setPresenter(presenter : T)

    fun getPresenter() : T
}