package com.gl4.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var txtEmail : EditText
    lateinit var passwd : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtEmail = findViewById(R.id.editTextEmail)
        passwd = findViewById(R.id.editTextPassword)
    }

    fun login(view: View) {
        val text : String
        var email = txtEmail.text.toString()

        if (txtEmail.text.toString() == "gl4@insat.tn" && passwd.text.toString() == "insat2022" ){
            text = "bon couple login, mot de passe"
            val intent = Intent(view.context,WelcomeActivity::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }else{
            text = "mauvais couple login, mot de passe"
        }
        val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT)
        toast.show()
    }

    fun imageUpload(view: View) {
        val intent = Intent(view.context,ImageUploadActivity::class.java)
        startActivity(intent)
    }
}