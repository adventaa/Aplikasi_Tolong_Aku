package com.example.tolong_aku

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tolong_aku.databinding.ActivityLoginHelperPolisiBinding

class LoginHelper_Polisi : AppCompatActivity() {
    private lateinit var binding : ActivityLoginHelperPolisiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperPolisiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(InformasiPolisi())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.informasi -> replaceFragment(InformasiPolisi())
                R.id.bantuan-> replaceFragment(BantuanPolisi())
                R.id.on_going -> replaceFragment(ProcessPolisi())

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
