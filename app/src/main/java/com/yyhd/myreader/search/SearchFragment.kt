package com.yyhd.myreader.search

import com.yyhd.base.BaseMvpFragment
import com.yyhd.myreader.R

/**
 * Created by hanli
 * date 2020-05-27.
 * ps:
 */
class SearchFragment : BaseMvpFragment<SearchContract.Presenter>() , SearchContract.View{


    override fun getLayoutId(): Int {
        return R.layout.fragment_search
    }


}