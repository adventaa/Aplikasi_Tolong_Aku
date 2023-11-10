package com.example.tolong_aku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class Pemadam : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemadam)

        val buttonClick: ImageButton = findViewById(R.id.imageButton)
        buttonClick.setOnClickListener(this)

        val buttonClick2: Button = findViewById(R.id.button_tolong)
        buttonClick2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.imageButton -> {
                    val moveIntent = Intent(this, MainMenu::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.button_tolong -> {
                    val moveIntent = Intent(this, Pemadam_lanjutan::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }
}