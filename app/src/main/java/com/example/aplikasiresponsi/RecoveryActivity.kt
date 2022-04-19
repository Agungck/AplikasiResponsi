package com.example.aplikasiresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import org.w3c.dom.Text

class RecoveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recovery)


        val sendemail = findViewById<Button>(R.id.sendemail)
        val ReEmail = findViewById<EditText>(R.id.ReEmail)


        sendemail.setOnClickListener {
            if (!Patterns.EMAIL_ADDRESS.matcher(ReEmail.text.toString()).matches()) {
                ReEmail.error = "Masukkan Email Dengan Benar..!!"
            } else if (ReEmail.length() == 0) {
                ReEmail.error = "Email Tidak Boleh Kosong..!!"
            } else {
                val buttonClick = findViewById<Button>(R.id.sendemail)
                buttonClick.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent) }
            }


        }
    }
}