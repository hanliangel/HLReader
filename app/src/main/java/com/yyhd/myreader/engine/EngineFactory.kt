package com.yyhd.myreader.engine

import java.lang.Exception

/**
 * Created by hanli
 * date 2021-03-14.
 * ps:
 */
class EngineFactory {

    companion object{

        /**
         * 根据引擎名字返回对应的引擎
         */
        fun getBookEngine(engineName : String = "com.yyhd.myreader.engine.YzwBookEngine") : BaseBookEngine{
            try{
                return Class.forName(engineName).newInstance() as BaseBookEngine
            } catch (e : Exception){
                e.printStackTrace()
            }
            return YzwBookEngine()
        }

    }
}