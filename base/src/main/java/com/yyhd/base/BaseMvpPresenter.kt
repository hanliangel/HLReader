package com.yyhd.base

/**
 * Created by hanli
 * date 2020-08-21.
 * ps:
 */
open class BaseMvpPresenter<V : BaseView<out BasePresenter>>(view : V) : BasePresenter{

    var view : V = view

}