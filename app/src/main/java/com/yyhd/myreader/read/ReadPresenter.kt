package com.yyhd.myreader.read

import com.yyhd.base.BaseMvpPresenter
import com.yyhd.myreader.db.table.Chapter
import com.yyhd.myreader.engine.BookEngine
import com.yyhd.myreader.engine.EngineFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by hanli
 * date 2020-08-30.
 * ps:
 */
class ReadPresenter(view : ReadContract.View) : ReadContract.Presenter , BaseMvpPresenter<ReadContract.View>(view) {


    override fun loadChapter(chapter: Chapter) {
        val bookEngine : BookEngine = EngineFactory.getBookEngine()
        GlobalScope.launch(Dispatchers.IO) {
            bookEngine.getChapterContent(chapter)
            withContext(Dispatchers.Main) {
                view.fillData(chapter)

            }
        }
    }
}