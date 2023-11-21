package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState: Serializable {
    fun apply(btnInc:Button, btnDec: Button, tv: TextView)

    data class Base(private val text: String) : UiState {
        override fun apply(btnInc: Button, btnDec: Button, tv: TextView) {
            tv.text = text
            btnInc.isEnabled = true
            btnDec.isEnabled = true
        }

    }

    data class Min(private val text: String) : UiState {
        override fun apply(btnInc: Button, btnDec: Button, tv: TextView) {
            tv.text = text
            btnDec.isEnabled = false
        }

    }

    data class Max(private val text: String) : UiState {
        override fun apply(btnInc: Button, btnDec: Button, tv: TextView) {
            tv.text = text
            btnInc.isEnabled = false
        }

    }
}