package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState :Serializable{

    fun apply(tv: TextView, btn: Button)

    data class Base(private val text:String): UiState{
        override fun apply(tv: TextView, btn: Button) {
            tv.text = text
        }
    }

    data class Max(private val text:String): UiState{
        override fun apply(tv: TextView, btn: Button) {
            tv.text = text
            btn.isEnabled = false
        }

    }

}