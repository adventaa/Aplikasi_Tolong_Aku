package com.example.tolong_aku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Dokter_lanjutan : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dokter_lanjutan)

        val buttonClick : Button = findViewById(R.id.button_batal)
        buttonClick.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.button_batal -> {
                    val moveIntent = Intent(this, Dokter::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }
}