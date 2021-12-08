package com.example.registerfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextEmailAddress: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var gilaki: Button
    private lateinit var gilaki1: Button
    private lateinit var gilaki2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        registerListeners()
    }

    private fun init() {
        editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        gilaki = findViewById(R.id.gilaki)
        gilaki1 = findViewById(R.id.gilaki1)
        gilaki2 = findViewById(R.id.gilaki2)

    }

    private fun registerListeners() {
        gilaki.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        gilaki2.setOnClickListener {
            startActivity(Intent(this, ForgotpasswordActivity::class.java))
        }
        gilaki1.setOnClickListener {
            val email = editTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty~!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        gotoProfile()
                    } else {
                        Toast.makeText(this, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

    private fun gotoProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()

    }
}