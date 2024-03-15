package com.example.thirdlesson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.userLogin)
        val userPassword: EditText = findViewById(R.id.userPassword)
        val userEmail: EditText = findViewById(R.id.userEmail)
        val button: Button = findViewById(R.id.buttonConfirmInLoginContext)
        val buttonLogin : Button = findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val password= userPassword.text.toString()
            val email= userEmail.text.toString().trim()

            if (login.isEmpty() || password.isEmpty() || email.isEmpty()){
                Toast.makeText(this, "Not all of fields are filled up",Toast.LENGTH_LONG).show()
            }
            else{
                val user = User(login,password,email)

                val db = DbHelper(this,null)
                db.addUser(user)
                Toast.makeText(this,"User $login is added", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
            }
        }
    }
}