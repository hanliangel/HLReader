package com.yyhd.myreader.db

import java.io.Serializable

/**
 * Created by hanli
 * date 2020-05-28.
 * ps:
 */
data class Book(var bookName : String) : Serializable{

    /**
     * 作者
     */
    var author = ""

    /**
     * 简介
     */
    var introduction = ""

    /**
     * 书本详情的url
     */
    var bookDetailUrl = ""

    /**
     * 本书对应的章节
     */
    lateinit var chapters : List<Chapter>

    override fun toString(): String {
        return "Book(bookName='$bookName', author='$author', introduction='$introduction', bookDetailUrl='$bookDetailUrl')"
    }

}