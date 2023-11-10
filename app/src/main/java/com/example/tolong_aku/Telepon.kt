package com.example.tolong_aku

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Telepon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telepon)
    }
    fun makePhoneCall(view: View) {
        val phoneNumber = "911"
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data =  Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }
}