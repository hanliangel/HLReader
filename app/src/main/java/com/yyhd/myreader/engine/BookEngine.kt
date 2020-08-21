package com.yyhd.myreader.engine

import com.yyhd.myreader.db.Book

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


}