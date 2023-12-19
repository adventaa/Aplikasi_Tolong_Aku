package com.example.tolong_aku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tolong_aku.databinding.ActivityLoginHelperPolisiBinding

class LoginHelper_Polisi : AppCompatActivity() {
    private lateinit var binding : ActivityLoginHelperPolisiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperPolisiBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login_helper_polisi)

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> InformasiPolisi()
                R.id.bantuan-> BantuanPolisi()
                R.id.on_going -> ProcessPolisi()

                else -> {
                }
            }
            true
        }

    }
}
