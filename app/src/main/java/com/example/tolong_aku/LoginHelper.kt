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
                authenticateUser(email, pass)
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }

        }
    }
    override fun onStart() {
        super.onStart()
        val currentUser = firebaseAuth.currentUser
        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun authenticateUser(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
            if (it.isSuccessful) {
                val user = firebaseAuth.currentUser
                if (user != null) {
                    redirectUser(user.email)
                }
            } else {
                // Authentication failed, show error message
                Toast.makeText(this, "Authentication failed: ${it.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun redirectUser(email: String?) {
        when (email) {
            "polisi@gmail.com" -> startNewActivity(LoginHelper_Polisi::class.java)
            "pemadam2@gmail.com" -> startNewActivity(LoginHelper_Pemadam::class.java)
            "dokterTirta@gmail.com" -> startNewActivity(LoginHelperDokter::class.java)
            "timsar1@gmail.com" -> startNewActivity(LoginHelper_TimSar::class.java)
            "ormasambulance1@gmail.com" -> startNewActivity(LoginHelperAmbulance::class.java)
            "rsambulance1@gmail.com" -> startNewActivity(LoginHelper_RumahSakit::class.java)
            else -> {
                // If the email doesn't match any predefined cases, show a default message
                Toast.makeText(this, "User with email $email is not authorized.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startNewActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish() // Finish the current activity to prevent going back to it
    }
}