package com.example.aplikasiresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById<Button>(R.id.login)
        val signup = findViewById<Button>(R.id.signup)
        val Email = findViewById<EditText>(R.id.Email)
        val Password = findViewById<EditText>(R.id.Password)
        val lupa = findViewById<Button>(R.id.lupa)


        login.setOnClickListener {
            val bukabundle =intent.extras
            if (bukabundle != null) {
                Email.setText(bukabundle.getString("Email"))
                Password.setText(bukabundle.getString("Password"))
            }


            if (!Patterns.EMAIL_ADDRESS.matcher(Email.text.toString()).matches()) {
                Email.error = "Masukkan Email Dengan Benar..!!"
            } else if (Password.length() == 0) {
                Password.error = "Password Tidak Boleh Kosong..!!"
            } else {
                val buttonClick = findViewById<Button>(R.id.sendemail)
                buttonClick.setOnClickListener {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        signup.setOnClickListener {
            val buttonClick = findViewById<Button>(R.id.signup)
            buttonClick.setOnClickListener {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent) }
        }
        lupa.setOnClickListener{
            val buttonClick = findViewById<Button>(R.id.lupa)
            buttonClick.setOnClickListener {
                val intent = Intent(this, RecoveryActivity::class.java)
                startActivity(intent)}
        }




    }
}