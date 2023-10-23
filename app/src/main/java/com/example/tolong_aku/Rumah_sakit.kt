package com.example.tolong_aku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class Rumah_sakit : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rumah_sakit)

        val buttonClick: Button = findViewById(R.id.button_dokter)
        buttonClick.setOnClickListener(this)

        val buttonClick2: Button = findViewById(R.id.button_ambulance)
        buttonClick2.setOnClickListener(this)

        val buttonClick3: ImageButton = findViewById(R.id.imageButton)
        buttonClick3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.imageButton -> {
                    val moveIntent = Intent(this, MainActivity::class.java)
                    startActivities(arrayOf(moveIntent))
                }
                R.id.button_dokter -> {
                    val moveIntent = Intent(this, Dokter::class.java)
                    startActivities(arrayOf(moveIntent))
                }
                R.id.button_ambulance -> {
                    val moveIntent = Intent(this, Ambulance::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }
}