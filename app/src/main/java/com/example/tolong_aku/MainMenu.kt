package com.example.tolong_aku

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MainMenu : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val buttonClick: ImageButton = findViewById(R.id.dialbutton)
        buttonClick.setOnClickListener(this)

        val buttonClick2: ImageButton = findViewById(R.id.button_polisi)
        buttonClick2.setOnClickListener(this)

        val buttonClick3: ImageButton = findViewById(R.id.button_ambulance)
        buttonClick3.setOnClickListener(this)

        val buttonClick4: ImageButton = findViewById(R.id.button_pemadam)
        buttonClick4.setOnClickListener(this)

        val buttonClick5: ImageButton = findViewById(R.id.button_rs)
        buttonClick5.setOnClickListener(this)

        val buttonClick6: ImageButton = findViewById(R.id.button_sar)
        buttonClick6.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.dialbutton -> {
                    val phoneNumber = "911"
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data =  Uri.parse("tel:$phoneNumber")
                    startActivity(intent)
                }

                R.id.button_polisi -> {
                    val moveIntent = Intent(this, Polisi::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.button_ambulance -> {
                    val moveIntent = Intent(this, Ambulance::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.button_pemadam -> {
                    val moveIntent = Intent(this, MainMenu::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.button_rs -> {
                    val moveIntent = Intent(this, Rumah_sakit::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.button_sar -> {
                    val moveIntent = Intent(this, Tim_sar::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }
}