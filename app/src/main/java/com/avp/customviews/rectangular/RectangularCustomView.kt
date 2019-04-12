package com.avp.customviews.rectangular

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import com.avp.customviews.R

class RectangularCustomView : View {
    private lateinit var mPaint: Paint
    private lateinit var mRect: Rect
    private var mSquareColor: Int = 0

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context, attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(attrs)
    }

    private fun init(set: AttributeSet?) {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mRect = Rect()

        if (set == null) return

        val ta = context.obtainStyledAttributes(set, R.styleable.RectangularCustomView)
        mSquareColor = ta.getColor(R.styleable.RectangularCustomView_square_color, Color.GREEN)
        ta.recycle()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        /*
        * Avoid object allocations during draw/layout operations (preallocate and reuse instead) less... (Ctrl+F1)
        * Inspection info:You should avoid allocating objects during a drawing or layout operation. These are called frequently,
        * so a smooth UI can be interrupted by garbage collection pauses caused by the object allocations.
        * The way this is generally handled is to allocate the needed objects up front and to reuse them for each drawing operation.
        * Some methods allocate memory on your behalf (such as Bitmap.create), and these should be handled in the same way.
        * Issue id: DrawAllocation
        * */
//        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
//        paint.color = Color.GREEN
//        val rect = Rect()
//        rect.left = 0
//        rect.right = width
//        rect.top = 0
//        rect.bottom = height


        mPaint.color = Color.GREEN
        mRect.left = 0
        mRect.right = width
        mRect.top = 0
        mRect.bottom = height

        canvas?.drawRect(mRect, mPaint)
    }

}