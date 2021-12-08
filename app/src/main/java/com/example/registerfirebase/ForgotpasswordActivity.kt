package com.example.registerfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotpasswordActivity : AppCompatActivity() {
    private lateinit var editTextTextEmailAddress3: TextView
    private lateinit var button5: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)
        init()

        registerListeners()
    }

    private fun init() {
        editTextTextEmailAddress3 = findViewById(R.id.editTextTextEmailAddress3)
        button5 = findViewById(R.id.button5)
    }

    private fun registerListeners() {
        button5.setOnClickListener {
            val email = editTextTextEmailAddress3.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Check Email!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}