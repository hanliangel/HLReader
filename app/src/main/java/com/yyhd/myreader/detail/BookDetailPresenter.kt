package com.yyhd.myreader.detail

import com.yyhd.base.BaseMvpPresenter
import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.engine.BiqukanBookEngine
import com.yyhd.myreader.engine.BookEngine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by hanli
 * date 2020-08-25.
 * ps:
 */
class BookDetailPresenter(view : BookDetailContract.View) : BookDetailContract.Presenter , BaseMvpPresenter<BookDetailContract.View>(view){

    var bookEnngine : BookEngine = BiqukanBookEngine()

    override fun loadBookDetail(book : Book) {
        GlobalScope.launch(Dispatchers.IO){
            bookEnngine.getBookDetail(book)
            withContext(Dispatchers.Main) {
                view.fillData(book)
            }
        }
    }


}