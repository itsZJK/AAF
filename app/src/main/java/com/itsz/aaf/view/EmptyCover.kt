package com.itsz.aaf.view

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.itsz.aaf.R

/**
 * @author itsZ
 */
class EmptyCover(context: Context) : ConstraintLayout(context) {

    private val parentId = ConstraintSet.PARENT_ID


    init {
        id = parentId

//        addView(AppCompatImageView(context), createConstraintLayout(
//            LayoutParams.WRAP_CONTENT,
//            LayoutParams.WRAP_CONTENT
//        ).also {
//            it.bottomToBottom = parentId
//        })
    }


//    private fun createConstraintLayout(width: Int, height: Int): LayoutParams {
//        return LayoutParams(width, height)
//
//    }
}