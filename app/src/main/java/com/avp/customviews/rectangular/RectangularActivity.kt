package com.avp.customviews.rectangular

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.avp.customviews.R
import kotlinx.android.synthetic.main.activity_rectangular.*

class RectangularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rectangular)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.one -> {
                rectangularCustomView.customPaddingUp(30)
            }
            R.id.two -> {
                rectangularCustomView.swapColor()
            }
            R.id.three -> {
                rectangularCustomView.customPaddingDown(30)
            }
        }
    }
}