package com.yyhd.myreader

import android.os.Bundle
import butterknife.BindView
import com.yyhd.base.BaseActivity
import com.yyhd.normal.MainBottomTabView

class MainActivity : BaseActivity() {

    @BindView(R.id.mbtv)
    lateinit var mBottomView : MainBottomTabView

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        mBottomView.setAdapter(MainAdapter(this) , supportFragmentManager)
    }

}
