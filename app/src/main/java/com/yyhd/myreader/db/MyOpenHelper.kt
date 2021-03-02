package com.yyhd.myreader.db

import android.content.Context
import com.github.yuweiguocn.library.greendao.MigrationHelper
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.db.table.BookDao
import com.yyhd.myreader.db.table.ChapterDao
import com.yyhd.myreader.db.table.DaoMaster
import org.greenrobot.greendao.database.Database

/**
 * Created by hanli
 * date 2021-03-01.
 * ps:
 */
class MyOpenHelper(context : Context, name : String) : DaoMaster.DevOpenHelper(context , name){

    override fun onUpgrade(db: Database?, oldVersion: Int, newVersion: Int) {
        MigrationHelper.migrate(db , BookDao::class.java , ChapterDao::class.java)
    }

}