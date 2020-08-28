package com.yyhd.myreader.db

import java.io.Serializable

/**
 * Created by hanli
 * date 2020-05-28.
 * ps:
 */
data class Chapter(var name : String) : Serializable{

    var content = ""

    var url = ""
}