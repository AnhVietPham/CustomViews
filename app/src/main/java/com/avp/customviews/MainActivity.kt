package com.avp.customviews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btGet.setOnClickListener {
            Toast.makeText(this,pinEntryEditText.text,Toast.LENGTH_LONG).show()
        }
    }
}
