package com.yyhd.myreader.read

import com.yyhd.base.BaseMvpPresenter
import com.yyhd.myreader.db.Chapter
import com.yyhd.myreader.engine.BaseBookEngine
import com.yyhd.myreader.engine.BiqukanBookEngine
import com.yyhd.myreader.engine.BookEngine
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

    val bookEngine : BookEngine = BiqukanBookEngine()

    override fun loadChapter(chapter: Chapter) {
        GlobalScope.launch(Dispatchers.IO) {
            bookEngine.getChapterContent(chapter)
            withContext(Dispatchers.Main) {
                view.fillData(chapter)

            }
        }
    }
}