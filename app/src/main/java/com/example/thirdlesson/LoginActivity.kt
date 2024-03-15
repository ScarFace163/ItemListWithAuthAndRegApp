package com.example.thirdlesson

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val userLogin:EditText = findViewById(R.id.userLogin)
        val userPassword:EditText = findViewById(R.id.userPassword)
        val button1: Button = findViewById(R.id.buttonForReg)
        val buttonConfirm: Button = findViewById(R.id.buttonConfirmInLoginContext)

        button1.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonConfirm.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()
            if (login.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Not all of fields are filled up", Toast.LENGTH_LONG).show()
            } else {
                try {
                    val db = DbHelper(this, null)
                    if (db.checkUser(login, password)) {
                        Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show()

                        val intent = Intent(this,ItemsActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Invalid login or password", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }

    }

}