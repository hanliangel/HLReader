package com.yyhd.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.billy.android.loading.Gloading


/**
 * Created by hanli
 * date 2019-10-21.
 * ps: fragment 基类
 */
open abstract class BaseFragment : Fragment {

    private lateinit var mHolder : Gloading.Holder


    constructor() : super()

    constructor(contentLayoutId: Int) : super(contentLayoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var layoutId = getLayoutId()
        if(layoutId <= 0){
            layoutId = R.layout.fragment_empty
        }

        var root = inflater.inflate(layoutId , container , false)
        ButterKnife.bind(this , root)

        initView(savedInstanceState , root)

        initValues(arguments)

        return root
    }

    /**
     * 返回布局的id
     */
    protected abstract fun getLayoutId() : Int

    /**
     * 返回状态页替换时候的容器，如果返回空，那么默认替换根布局
     */
    protected fun getStatusViewHolder() : View? {
        return null
    }

    protected abstract fun initValues(arguments : Bundle?)

    protected abstract fun initView(savedInstanceState: Bundle? , rootView : View)

}