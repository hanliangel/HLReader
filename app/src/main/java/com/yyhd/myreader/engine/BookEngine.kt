package com.yyhd.myreader.engine

import com.yyhd.myreader.db.table.Book
import com.yyhd.myreader.db.table.Chapter

/**
 * Created by hanli
 * date 2020-05-28.
 * ps:
 */
interface BookEngine {

    /**
     * 根据关键字搜索书本
     */
    fun searchBook(searchStr : String) : List<Book>


    /**
     * 获得书本的详情
     */
    fun getBookDetail(book : Book)


    /**
     * 获得章节内容详情
     */
    fun getChapterContent(chapter: Chapter)


    /**
     * 返回当前引擎的名字，也就是网站名字
     */
    abstract fun getEngineName(): String
}