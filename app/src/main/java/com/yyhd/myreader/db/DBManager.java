//package com.yyhd.myreader.db;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//
//
//
///**
// * Created by hanli
// * date 2019/4/23.
// * ps: 数据库的管理者，单例形式
// */
//public class DBManager {
//
//    /**
//     * 单例对象
//     */
//    private static DBManager mDBManager = new DBManager();
//
//    /**
//     * 数据库的连接
//     */
//    private DaoSession mDaoSession;
//
//    private DBManager(){
//    }
//
//    public static DBManager getInstance(){
//        if(mDBManager == null) {
//            mDBManager = new DBManager();
//        }
//        return mDBManager;
//    }
//
//    /**
//     * 初始化greenDao数据库相关
//     */
//    public void initGreenDao(Context context){
//        DaoMaster.DevOpenHelper helper = new MyOpenHelper(context, "yyhd");
//        SQLiteDatabase writableDatabase =helper.getWritableDatabase();
//        DaoMaster master = new DaoMaster(writableDatabase);
//        mDaoSession = master.newSession();
//    }
//
//
//    /**
//     * 获得数据库的daoSession
//     * @return
//     */
//    public DaoSession getDaoSession(){
//        return mDaoSession;
//    }
//}
