package com.yyhd.myreader

import android.os.Bundle
import butterknife.BindView
import com.blankj.utilcode.util.LogUtils
import com.yyhd.base.BaseActivity
import com.yyhd.myreader.db.DBManager
import com.yyhd.myreader.db.table.*
import com.yyhd.normal.MainBottomTabView
import org.greenrobot.greendao.query.QueryBuilder
import java.lang.StringBuilder

class MainActivity : BaseActivity() {

    @BindView(R.id.mbtv)
    lateinit var mBottomView : MainBottomTabView

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        mBottomView.setAdapter(MainAdapter(this) , supportFragmentManager)
        DBManager.initGreenDao(this)
    }

}
