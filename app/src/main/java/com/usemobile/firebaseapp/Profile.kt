package com.usemobile.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import com.usemobile.firebaseapp.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.name
        val mail = binding.mail

        val acct = GoogleSignIn.getLastSignedInAccount(this)

        if (acct != null) {
            name.text = acct.displayName
            mail.text = acct.email

            binding.logout.setOnClickListener {

                FirebaseAuth.getInstance().signOut()
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
            }

            binding.crash.setOnClickListener {
                throw Exception("App parou")
            }


        }
    }


}