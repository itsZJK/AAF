package com.itsz.base

import android.app.Application
import androidx.annotation.CallSuper

/**
 * @author itsZ
 */
open class BaseApplication : Application() {

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        initDebugTools()
    }

    private fun initDebugTools() {


    }
}