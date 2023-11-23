package com.example.tolong_aku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class Rumah_sakit : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rumah_sakit)

        val buttonClick: ImageButton = findViewById(R.id.buttonDokter)
        buttonClick.setOnClickListener(this)

        val buttonClick2: ImageButton = findViewById(R.id.buttonAmbulance)
        buttonClick2.setOnClickListener(this)

        val buttonClick3: Button = findViewById(R.id.buttonback)
        buttonClick3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.buttonback -> {
                    val moveIntent = Intent(this, MainMenu::class.java)
                    startActivities(arrayOf(moveIntent))
                }
                R.id.buttonDokter -> {
                    val moveIntent = Intent(this, Dokter::class.java)
                    startActivities(arrayOf(moveIntent))
                }
                R.id.buttonAmbulance -> {
                    val moveIntent = Intent(this, Ambulance::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }
}