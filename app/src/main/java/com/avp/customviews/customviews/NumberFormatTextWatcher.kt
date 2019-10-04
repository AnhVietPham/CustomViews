package com.avp.customviews.customviews

import android.support.v7.widget.AppCompatEditText
import android.text.Editable
import android.text.TextWatcher
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class NumberFormatTextWatcher(private val editText: AppCompatEditText) : TextWatcher {
    companion object {
        const val PATTERN_FORMAT_NUMBER = "#,###,###"
    }

    override fun afterTextChanged(s: Editable?) {
        editText.removeTextChangedListener(this)
        try {
            var originalString = s.toString()
            val originalLong: Long
            if (originalString.contains(",")) {
                originalString = originalString.replace(",", "")
            }

            originalLong = originalString.toLong()

            val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
            formatter.applyPattern(PATTERN_FORMAT_NUMBER)
            val formatCurrency = formatter.format(originalLong)
            editText.setText(formatCurrency)
            editText.setSelection(editText.text?.length ?: 0)
        } catch (nfe: NumberFormatException) {
            nfe.printStackTrace()
        }
        editText.addTextChangedListener(this)

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

}