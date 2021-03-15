package com.yyhd.myreader.engine

/**
 * Created by hanli
 * date 2021-03-14.
 * ps:
 */
class EngineFactory {

    companion object{

        fun getBookEngine() : BaseBookEngine{
            return YzwBookEngine()
        }

    }
}