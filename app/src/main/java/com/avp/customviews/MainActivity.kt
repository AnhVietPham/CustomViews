package com.avp.customviews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        btGet.setOnClickListener {
//            Toast.makeText(this, pinEntryEditText.text, Toast.LENGTH_LONG).show()
//        }
//
//        edtNumber.addTextChangedListener(NumberFormatTextWatcher(edtNumber))
        handleDate(2)
    }

    private fun handleDate(monthAgo: Int) {
        val monthAgos = mutableListOf<String>()
        val rangeDays = mutableListOf<String>()
        for (i in 0..monthAgo) {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MONTH, -i)
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH))
            val date = calendar.time
            val format = SimpleDateFormat("dd/MM/yyyy")
            val dateOutput = format.format(date)
            monthAgos.add(dateOutput)
            val formatRangeDay = SimpleDateFormat("dd/MM/yyyy")
            if (i == 0) {
                formatDate(dateOutput, formatRangeDay, Calendar.getInstance().time, rangeDays)
            } else {
                calendar.set(
                    Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
                )
                formatDate(dateOutput, formatRangeDay, calendar.time, rangeDays)
            }
        }
        val s = monthAgos
        val a = rangeDays
    }

    private fun formatDate(
        dateOutput: String,
        formatRangeDay: SimpleDateFormat,
        currentDate: Date?,
        rangeDays: MutableList<String>
    ) {
        val rangeDay = dateOutput + " " + formatRangeDay.format(currentDate)
        rangeDays.add(rangeDay)
    }
}
