package com.example.tolong_aku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tolong_aku.databinding.ActivityLoginHelperPolisiBinding

class LoginHelper_RumahSakit : AppCompatActivity() {
    private lateinit var binding : ActivityLoginHelperPolisiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperPolisiBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login_helper_polisi)

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> InformasiRumahSakit()
                R.id.bantuan-> BantuanRumahSakit()
                R.id.on_going -> ProcessRumahSakit()

                else -> {
                }
            }
            true
        }

    }
}