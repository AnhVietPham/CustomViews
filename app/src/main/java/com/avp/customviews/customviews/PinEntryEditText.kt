package com.avp.customviews.customviews

import android.annotation.TargetApi
import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.text.Editable
import android.util.AttributeSet
import android.widget.EditText
import com.sun.xml.internal.fastinfoset.util.CharArray


class PinEntryEditText : EditText {
    val XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android"
    private var mSpace: Float = 24f
    private var mCharSize: Float = 0f
    private var mNumberChars: Float = 6f
    private var mLineSpacing: Float = 8f
    private var mMaxLength = 4

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context = context, attrs = attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context = context, attrs = attrs)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context = context, attrs = attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        setBackgroundColor(0)
        val multi: Float = context?.resources?.displayMetrics?.density ?: 0f
        mSpace *= multi
        mLineSpacing *= multi
        mMaxLength = attrs?.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 4) ?: 0
        mNumberChars = mMaxLength.toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        val availableWidth = width - paddingRight - paddingLeft
        mCharSize = if (mSpace < 0) {
            (availableWidth / (mNumberChars * 2 - 1))
        } else {
            (availableWidth - (mSpace * (mNumberChars - 1))) / mNumberChars
        }

        var startX: Float = paddingLeft.toFloat()
        val bottom: Float = height.toFloat() - paddingBottom.toFloat()


        // Text Width
        val text : Editable = text
        val textLength = text.length
        val textWidths = FloatArray(textLength)
        paint.getTextWidths(getText(), 0, textLength, textWidths)

        for (i in 0 until mNumberChars.toInt()) {
            canvas?.drawLine(
                startX,
                bottom,
                startX + mCharSize,
                bottom,
                paint
            )

            if (text.length > i){
                val middle: Float = startX + mCharSize / 2
                canvas?.drawText(text,i,i+1, middle - textW)
            }

            startX += if (mSpace < 0) {
                mCharSize + 2
            } else {
                mCharSize + mSpace
            }
        }
    }
}