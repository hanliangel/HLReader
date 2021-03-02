package com.yyhd.myreader.db

import android.content.Context
import com.yyhd.myreader.db.table.DaoMaster
import com.yyhd.myreader.db.table.DaoSession

/**
 * Created by hanli
 * date 2021-03-01.
 * ps:
 */
object DBManager {

    open lateinit var mDaoSession : DaoSession

    fun initGreenDao(context: Context){
        val helper = MyOpenHelper(context, "hanli_book")
        val writableDatabase = helper.getWritableDatabase()
        val master = DaoMaster(writableDatabase)
        mDaoSession = master.newSession()
    }

}