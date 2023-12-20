package com.example.tolong_aku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tolong_aku.databinding.ActivityLoginHelperAmbulanceBinding

class LoginHelperAmbulance : AppCompatActivity() {
    private lateinit var binding : ActivityLoginHelperAmbulanceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperAmbulanceBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login_helper_ambulance)

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> InformasiAmbulance()
                R.id.bantuan-> BantuanAmbulance()
                R.id.on_going -> ProcessAmbulance()

                else -> {
                }
            }
            true
        }
    }
}