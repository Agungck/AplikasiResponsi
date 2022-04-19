package com.example.aplikasiresponsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val Email = findViewById<TextView>(R.id.Email)
        val Password = findViewById<TextView>(R.id.Password)
        val ConPassword = findViewById<TextView>(R.id.ConPassword)
        val signup = findViewById<Button>(R.id.signup)

        signup.setOnClickListener{
        val bundle = Bundle()
            bundle.putString("Email",Email.text.toString())
            bundle.putString("Password",Password.text.toString())
            bundle.putString("ConPassword",ConPassword.text.toString())

            if (!Patterns.EMAIL_ADDRESS.matcher(Email.text.toString()).matches()){
                Email.error = "Masukkan Email Dengan Benar..!!"
            }
            else if (Password.length()==0){
                Password.error = "Password Tidak Boleh Kosong..!!"
            }
            else{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan..!!")
                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar..??")
                    .setCancelable(false)
                    .setPositiveButton("Yes")
                    { dialogInterface, i ->
                        val intent = Intent (this, MainActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this,"Data Profil berhasil Disimpan", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No"){
                            dialogInterface, i -> dialogInterface.cancel()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }




    }
}