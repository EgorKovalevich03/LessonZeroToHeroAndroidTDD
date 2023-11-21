package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.actionButton)
        val tv = findViewById<TextView>(R.id.titleTextView)
        val pb = findViewById<ProgressBar>(R.id.progressBar)

        btn.setOnClickListener {
            btn.isEnabled = false
            pb.visibility = View.VISIBLE

            btn.postDelayed(
                {
                    tv.visibility = View.VISIBLE
                    pb.visibility = View.GONE
                    btn.isEnabled = true
                },
                3000
            )
        }

    }
}