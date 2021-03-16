package com.yyhd.myreader.detail

import com.blankj.utilcode.util.ObjectUtils
import com.yyhd.base.BaseMvpPresenter
import com.yyhd.myreader.db.DBManager
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.db.table.BookDao
import com.yyhd.myreader.engine.BookEngine
import com.yyhd.myreader.engine.EngineFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * Created by hanli
 * date 2020-08-25.
 * ps:
 */
class BookDetailPresenter(view : BookDetailContract.View) : BookDetailContract.Presenter , BaseMvpPresenter<BookDetailContract.View>(view){



    override fun loadBookDetail(book : Book) {
        var bookEnngine : BookEngine = EngineFactory.getBookEngine()
        GlobalScope.launch(Dispatchers.IO){
            bookEnngine.getBookDetail(book)
            withContext(Dispatchers.Main) {
                view.fillData(book)
            }
        }
    }


    override fun collectBook(book: Book) : Boolean{
        try{
            DBManager.mDaoSession.insertOrReplace(book)
            return true
        } catch (e : Exception){
            e.printStackTrace()
        }
        return false
    }


    override fun isCollect(book: Book): Book? {
        try{
            val list = DBManager.mDaoSession.bookDao.queryBuilder()
                .where(BookDao.Properties.BookDetailUrl.eq(book.bookDetailUrl)).list()
            if(ObjectUtils.isNotEmpty(list)){
                return list[0]
            }
        } catch (e:Exception){
            e.printStackTrace()
        }
        return null
    }

    override fun cancelCollectBook(book: Book): Boolean {
        try {
            val list = DBManager.mDaoSession.bookDao.queryBuilder()
                .where(BookDao.Properties.BookDetailUrl.eq(book.bookDetailUrl)).list()
            DBManager.mDaoSession.bookDao.deleteInTx(list)
            return true
        } catch (e : Exception){
            e.printStackTrace()
        }
        return false
    }
}