package com.example.tolong_aku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tolong_aku.databinding.ActivityLoginHelperPolisiBinding

class LoginHelper_TimSar : AppCompatActivity() {
    private lateinit var binding : ActivityLoginHelperPolisiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperPolisiBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login_helper_tim_sar)

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> InformasiTimSar()
                R.id.bantuan-> BantuanTimSar()
                R.id.on_going -> ProcessTimSar()

                else -> {
                }
            }
            true
        }

    }
}