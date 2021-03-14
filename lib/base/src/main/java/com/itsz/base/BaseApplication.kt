package com.itsz.base

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.annotation.CallSuper

/**
 * @author itsZ
 */
open class BaseApplication : Application() {

    @CallSuper
    override fun onCreate() {
        super.onCreate()
        context = this
        globalHandler = Handler(Looper.getMainLooper())
        initDebugTools()
    }

    private fun initDebugTools() {

    }

    companion object {
        lateinit var context: Context
        lateinit var globalHandler: Handler
        private const val LOG_TAG = "LOG_TAG"
    }
}