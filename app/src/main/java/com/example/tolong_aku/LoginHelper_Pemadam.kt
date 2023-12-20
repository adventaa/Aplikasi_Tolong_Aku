package com.example.tolong_aku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tolong_aku.databinding.ActivityLoginHelperPemadamBinding

class LoginHelper_Pemadam : AppCompatActivity() {

    private lateinit var binding : ActivityLoginHelperPemadamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperPemadamBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login_helper_pemadam)

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> InformasiPemadam()
                R.id.bantuan-> BantuanPemadam()
                R.id.on_going -> ProcessPemadam()

                else -> {
                }
            }
            true
        }
    }
}