package com.yyhd.base.widget

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import com.blankj.utilcode.util.ScreenUtils
import com.yyhd.base.R

/**
 * Created by hanli
 * date 2021-03-16.
 * ps: 正在加载使用的dialog
 */
class LoadingDialog(context : Context) : Dialog(context) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }

    override fun show() {
        super.show()

        val dialogWindow = window ?: return
        val layoutParams = dialogWindow.attributes
        layoutParams.width = (ScreenUtils.getScreenWidth() * 0.8).toInt()
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialogWindow.setGravity(Gravity.CENTER)
        setCanceledOnTouchOutside(false)
    }


}