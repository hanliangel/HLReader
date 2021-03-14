package com.yyhd.myreader.engine

import com.yyhd.myreader.db.DBManager
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.db.table.BookDao
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

/**
 * Created by hanli
 * date 2020-05-28.
 * ps:
 */
abstract class BaseBookEngine : BookEngine {


    fun getDocument(url : String) : Document {
        return Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36")
            .cookie("auth", "token")
            .timeout(30_000)
            .followRedirects(true)
            .get()
    }

    /**
     * 保存一本书到数据库
     */
    fun saveBookToDB(book : Book) {
        DBManager.mDaoSession.insert(book)
        DBManager.mDaoSession.bookDao.insert(book)
        DBManager.mDaoSession.bookDao.insertInTx(book)
        DBManager.mDaoSession.bookDao.insertOrReplace(book)

        DBManager.mDaoSession.update(book)
        DBManager.mDaoSession.bookDao.updateInTx(book)

        DBManager.mDaoSession.delete(book)
        DBManager.mDaoSession.bookDao.deleteAll()

        DBManager.mDaoSession.bookDao.loadAll()
        val resultList = DBManager.mDaoSession.bookDao.queryRaw("where bookName = ?", "诛仙")
        DBManager.mDaoSession.bookDao.deleteInTx(resultList)

        val list = DBManager.mDaoSession.bookDao.queryBuilder().where(BookDao.Properties.BookName.eq("诛仙")).list()
    }
}