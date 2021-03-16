package com.yyhd.myreader.engine

import com.yyhd.myreader.engine.impl.YzwBookEngine
import java.lang.Exception

/**
 * Created by hanli
 * date 2021-03-14.
 * ps:
 */
object EngineFactory {

    var cachedEngine : MutableMap<String , BaseBookEngine> = HashMap()

    /**
     * 搜索那会使用的当前引擎
     */
    var currentEngineClassName = YzwBookEngine::class.java.name

    /**
     * 根据引擎名字返回对应的引擎
     */
    fun getBookEngine(engineName : String = currentEngineClassName) : BaseBookEngine{
        try{
            var bookEngine = cachedEngine[engineName]
            if(bookEngine == null){
                bookEngine = Class.forName(engineName).newInstance() as BaseBookEngine
            }
            return bookEngine
        } catch (e : Exception){
            e.printStackTrace()
        }
        return YzwBookEngine()
    }

}