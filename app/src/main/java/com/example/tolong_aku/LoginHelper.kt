package com.example.tolong_aku

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tolong_aku.databinding.ActivityLoginHelperBinding
import com.google.firebase.auth.FirebaseAuth

class LoginHelper : AppCompatActivity() {

    private lateinit var binding: ActivityLoginHelperBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        binding = ActivityLoginHelperBinding.inflate(layoutInflater)
        //
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        binding.buttonceklogin.setOnClickListener {
            val email = binding.username.text.toString()
            val pass = binding.password.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                if (email == "polisi@gmail.com" && pass == "polisi1") {
                    // If the credentials match, start MainActivity
                    val intent = Intent(this, LoginHelper_Polisi::class.java)
                    startActivity(intent)
//                    startActivities(arrayOf(intent))
                } else {
                    // For other credentials, perform additional checks
                    if (email == "pemadam2@gmail.com" && pass == "pemadam1") {
                        // If admin credentials match, start AdminActivity
                        val intent = Intent(this, LoginHelper_Pemadam::class.java)
                        startActivity(intent)
                    } else if (email == "dokterTirta@gmail.com" && pass == "dokter1") {
                        // If user1 credentials match, start User1Activity
                        val intent = Intent(this, LoginHelperDokter::class.java)
                        startActivity(intent)
                    } else if (email == "timsar1@gmail.com" && pass == "timsar1") {
                        // If user2 credentials match, start User2Activity
                        val intent = Intent(this, LoginHelper::class.java)
                        startActivity(intent)
                    } else if (email == "ormasambulance1@gmail.com" && pass == "ormass1") {
                        // If user3 credentials match, start User3Activity
                        val intent = Intent(this, LoginHelperAmbulance::class.java)
                        startActivity(intent)
                    } else if (email == "rsambulance1@gmail.com" && pass == "ambulance1") {
                        // If user4 credentials match, start User4Activity
                        val intent = Intent(this, LoginHelperAmbulance::class.java)
                        startActivity(intent)
                    } else {
                        // For other credentials, perform Firebase authentication
                        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }
    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}