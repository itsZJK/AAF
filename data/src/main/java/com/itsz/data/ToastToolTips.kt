package com.itsz.data

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.itsz.ToolTips

/**
 * @author itsZ
 */
class ToastToolTips : ToolTips {

    override fun toastTip(content: String?) {
        LogUtils.e(content)
        content?.let {
            ToastUtils.showShort(it)
        }
    }
}