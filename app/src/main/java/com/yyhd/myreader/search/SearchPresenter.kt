package com.yyhd.myreader.search

import com.yyhd.base.BaseMvpPresenter
import com.yyhd.myreader.engine.BookEngine
import com.yyhd.myreader.engine.EngineFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by hanli
 * date 2020-05-27.
 * ps:
 */
class SearchPresenter(view: SearchFragment) : BaseMvpPresenter<SearchContract.View>(view), SearchContract.Presenter {

    override fun searchBook(searchStr: String?) {
        var bookEngine : BookEngine = EngineFactory.getBookEngine()
        GlobalScope.launch(Dispatchers.IO) {
            searchStr?.let {
                val bookList = bookEngine.searchBook(searchStr)
                for(item in bookList){
                    item.engineName = bookEngine.getEngineName()
                    item.engineClassName = EngineFactory.currentEngineClassName
                }
                withContext(Dispatchers.Main){
                    view.fillData(bookList)
                }
            }
        }
    }


}