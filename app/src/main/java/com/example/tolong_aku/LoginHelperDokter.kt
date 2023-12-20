package com.example.tolong_aku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tolong_aku.databinding.ActivityLoginHelperDokterBinding

class LoginHelperDokter : AppCompatActivity() {
    private lateinit var binding : ActivityLoginHelperDokterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperDokterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login_helper_dokter)

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> InformasiDokter()
                R.id.bantuan-> BantuanDokter()
                R.id.on_going -> ProcessDokter()

                else -> {
                }
            }
            true
        }
    }
}