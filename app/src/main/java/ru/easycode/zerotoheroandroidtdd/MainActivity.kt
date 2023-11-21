package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var uiState: UiState = UiState.Base("0")
    private val count = Count.Base(2,4)
    private lateinit var tv: TextView
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.countTextView)
        btn = findViewById(R.id.incrementButton)
        btn.setOnClickListener {
            uiState = count.increment(tv.text.toString())
            uiState.apply(tv,btn)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY,uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(KEY) as UiState
        }
        uiState.apply(tv,btn)
    }

    companion object{
        private const val KEY = "uiKeyState"
    }
}