package com.example.vvw.hellocanvas.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.properties.Delegates

val TAG = "SliderView"

class SliderView : View {

    lateinit var linePaint: Paint
    lateinit var circlePaint: Paint
    lateinit var textPaint: Paint
    private var viewWidth by Delegates.notNull<Int>()
    private var viewHeight by Delegates.notNull<Int>()
    lateinit var leftCenter: PointF
    private val radius: Float = 30f
    private var leftText: String = "LeftText"
    private var startX: Float = 0f
    private var lineHeight: Float = 10f
    private val MIN_WIDTH: Int = 300
    private val MIN_HEIGHT: Int = 100


    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attributes: AttributeSet?) : this(context, null, -1) {

    }

    constructor(context: Context, attributes: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attributes,
        defStyleAttr
    ) {
        init(context)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthMode = MeasureSpec.getMode(widthMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        viewHeight = MeasureSpec.getSize(heightMeasureSpec)
        if (widthMode == MeasureSpec.UNSPECIFIED) {
            viewWidth = MIN_WIDTH
        }
        if (heightMode != MeasureSpec.EXACTLY) {
            viewHeight = MIN_HEIGHT
        }


        leftCenter.y = viewHeight * 1f / 2

        setMeasuredDimension(viewWidth, viewHeight)

    }

    private fun init(context: Context) {

        linePaint = Paint()
        linePaint.color = Color.BLUE
        linePaint.style = Paint.Style.FILL


        circlePaint = Paint()
        circlePaint.color = Color.RED
        circlePaint.style = Paint.Style.FILL
        circlePaint.strokeWidth = 6f

        textPaint = Paint()
        textPaint.color = Color.BLACK
        textPaint.textSize = 30f


        leftCenter = PointF(radius, 0f)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                if (touchOnCircle(event, leftCenter, radius)) startX = event.x

            }
            MotionEvent.ACTION_MOVE -> {
                if (touchOnCircle2(event, leftCenter, radius)) {
                    Log.e(TAG, "onTouchEvent: 555")
                    val x = event.x
                    val dx = x - startX
                    startX = event.x
                    leftCenter.x = leftCenter.x + dx
                    invalidate()
                }
                Log.e(TAG, "onTouchEvent: 555")


            }
            MotionEvent.ACTION_UP -> {
            }


        }
        return true
    }

    private fun touchOnCircle2(event: MotionEvent, leftCenter: PointF, radius: Float): Boolean {

        return true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        assert(canvas != null)
        val newCanvas = canvas!!
        drawLine(newCanvas)
        drawLeftCircle(newCanvas)
        drawLeftText(newCanvas)


    }


    private fun drawLeftText(canvas: Canvas) {
        //画在线的上方
        //x,y 是Text Rect的左下点 （这是粗略的说法，具体的说法，可以在网上搜索一下）
        canvas.drawText(leftText, 5f, viewHeight / 2 - 35f, textPaint)
    }

    private fun drawLeftCircle(canvas: Canvas) {
        Log.d("Test", "drawLeftCircle")
        leftCenter.x = if (leftCenter.x.compareTo(radius) <= 0) {
            radius
        } else if (leftCenter.x.compareTo(viewWidth - radius) >= 0) {
            viewWidth - radius
        } else {
            leftCenter.x
        }
        canvas.drawCircle(leftCenter.x, leftCenter.y, radius, circlePaint);

    }

    private fun drawLine(canvas: Canvas) {
        Log.d("Test", "drawLine")
        // 线条粗细：10f
        canvas.drawRect(
            0f,
            (viewHeight - lineHeight) / 2,
            viewWidth * 1.0f,
            (viewHeight + lineHeight) / 2,
            linePaint
        )

    }

    private fun touchOnCircle(event: MotionEvent, center: PointF, radius: Float): Boolean {
        val distance =
            sqrt(((center.x - event.x) * 1.0).pow(2.0) + ((center.y - event.y) * 1.0).pow(2.0))
        return radius.compareTo(distance) >= 0;
    }


}