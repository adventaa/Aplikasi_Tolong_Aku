package com.example.tolong_aku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat.startActivities

class Tim_sar : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tim_sar)

        val buttonClick: ImageButton = findViewById(R.id.imageButton)
        buttonClick.setOnClickListener(this)

        val buttonClick2: Button = findViewById(R.id.button_tolong)
        buttonClick2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.imageButton -> {
                    val moveIntent = Intent(this, MainActivity::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.button_tolong -> {
                    val moveIntent = Intent(this, Tim_sar_lanjutan::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }
}

//    override fun onClick2(v: View?) {
//        if (v != null) {
//            when (v.id) {
//                R.id.button_tolong -> {
//                    val moveIntent = Intent(this, Tim_sar_lanjutan::class.java)
//                    startActivities(arrayOf(moveIntent))
//                }
//            }
//        }
//    }

