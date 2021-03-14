package com.itsz.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

/**
 * @author itsZ
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var rootContentView: View? = null

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRootContentView(bindLayout())
        initViews(savedInstanceState,rootContentView)
    }

    open fun setRootContentView(@LayoutRes layoutId: Int) {
        setContentView(LayoutInflater.from(this).inflate(layoutId, null)
            .also { rootContentView = it })
    }

    abstract fun initViews(savedInstanceState: Bundle?, rootContentView: View?)

    abstract fun bindLayout(): Int

    abstract fun doBusiness()

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()

    }
}