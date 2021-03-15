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
     * 从获得的包含各种html标签的内容中获得格式化好的内容
     * @param rawContent
     * @return
     */
    protected fun getContentFromHtml(rawContent: String): String {
        var rawContent = rawContent
        rawContent = rawContent.replace("<br>".toRegex(), "")
        rawContent = rawContent.replace("&nbsp;".toRegex(), " ")
        //        rawContent = rawContent.replaceAll("<.*>.*</[\\w-\\W-]*>", "");
        return rawContent
    }
}