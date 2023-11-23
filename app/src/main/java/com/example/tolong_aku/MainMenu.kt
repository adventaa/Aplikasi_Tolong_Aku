package com.example.tolong_aku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainMenu : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val buttonClick : ImageButton = findViewById(R.id.buttonKeRumahSakit)
        buttonClick.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.buttonKeRumahSakit -> {
                    val moveIntent = Intent(this, Rumah_sakit::class.java)
                    startActivities(arrayOf(moveIntent))
                }

            }
        }
    }
}