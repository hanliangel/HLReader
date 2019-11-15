package com.yyhd.base

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

    private var mHolder : Gloading.Holder


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



        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected abstract fun getLayoutId() : Int

    protected fun getStatusViewHolder() : View? {
        return null
    }

}