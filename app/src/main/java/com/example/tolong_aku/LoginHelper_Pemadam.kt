package com.example.tolong_aku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tolong_aku.databinding.ActivityLoginHelperPemadamBinding

class LoginHelper_Pemadam : AppCompatActivity() {

    private lateinit var binding : ActivityLoginHelperPemadamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperPemadamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(InformasiPemadam())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> replaceFragment(InformasiPemadam())
                R.id.bantuan-> replaceFragment(BantuanPemadam())
                R.id.on_going -> replaceFragment(ProcessPemadam())

                else -> {
                }
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}