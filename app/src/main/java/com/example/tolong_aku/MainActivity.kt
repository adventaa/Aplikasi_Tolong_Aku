package com.example.tolong_aku


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val buttonClick: Button = findViewById(R.id.buttonuser)
        buttonClick.setOnClickListener(this)

        val buttonClick2: Button = findViewById(R.id.buttonhelper)
        buttonClick2.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.buttonuser -> {
                    val moveIntent = Intent(this, MainMenu::class.java)
//                    val moveIntent = Intent(this, MainMenuFragment::class.java)
                    startActivities(arrayOf(moveIntent))
                }

                R.id.buttonhelper -> {
                    val moveIntent = Intent(this, LoginHelper::class.java)
                    startActivities(arrayOf(moveIntent))
                }
            }
        }
    }

}