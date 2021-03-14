package com.itsz.extension

import android.os.SystemClock
import android.view.View
import android.view.View.*

/**
 * @author itsZ
 */


fun View.setOnDebouncedClickListener(action: () -> Unit) {
    val actionDebouncer = ClickActionDebouncer(action)
    // This is the only place in the project where we should actually use setOnClickListener
    setOnClickListener {
        actionDebouncer.notifyAction()
    }
}

fun View.removeOnDebouncedClickListener() {
    setOnClickListener(null)
    isClickable = false
}

private class ClickActionDebouncer(
    private val action: () -> Unit,
    private val defaultIntervalMilliseconds: Long = DEBOUNCE_INTERVAL_MILLISECONDS
) {

    companion object {
        const val DEBOUNCE_INTERVAL_MILLISECONDS = 600L
    }

    private var lastActionTime = 0L

    fun notifyAction() {
        val now = SystemClock.elapsedRealtime()
        val millisecondsPassed = now - lastActionTime
        val actionAllowed = millisecondsPassed > defaultIntervalMilliseconds
        lastActionTime = now
        if (actionAllowed) {
            action.invoke()
        }
    }
}

var View.visible
    get() = visibility == VISIBLE
    set(value) {
        visibility = if (value) VISIBLE else GONE
    }

fun View.hide(gone: Boolean = true) {
    visibility = if (gone) GONE else INVISIBLE
}

fun View.show() {
    visibility = VISIBLE
}