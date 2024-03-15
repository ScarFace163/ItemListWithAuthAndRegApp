package com.example.thirdlesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class item_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val name:TextView = findViewById(R.id.itemInName)
        val text:TextView = findViewById(R.id.itemInText)
        val button:Button = findViewById(R.id.buttonBuyItNow)
        val image : ImageView = findViewById(R.id.itemInImage)

        name.text = intent.getStringExtra("itemName")
        text.text = intent.getStringExtra("itemText")
        image.setImageResource(intent.getIntExtra("itemImage", 0))
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}