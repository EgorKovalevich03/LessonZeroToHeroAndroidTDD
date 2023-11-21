package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var uiState: UiState
    private val count = Count.Base(2,4,0)
    private lateinit var tv: TextView
    private lateinit var btnInc: Button
    private lateinit var btnDec: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.countTextView)
        btnInc = findViewById(R.id.incrementButton)
        btnDec = findViewById(R.id.decrementButton)

        btnInc.setOnClickListener {
            uiState = count.increment(tv.text.toString())
            uiState.apply(btnInc,btnDec,tv)
        }

        btnDec.setOnClickListener {
            uiState = count.decrement(tv.text.toString())
            uiState.apply(btnInc,btnDec,tv)
        }
        if(savedInstanceState==null){
            uiState = count.initial(tv.text.toString())
            uiState.apply(btnInc,btnDec,tv)
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
        uiState.apply(btnInc,btnDec,tv)
    }


    companion object{
        private const val KEY = "uiKeyState"
    }
}