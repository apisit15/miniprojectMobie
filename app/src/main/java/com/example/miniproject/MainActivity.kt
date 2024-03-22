package com.example.miniproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chapter1Button = findViewById<Button>(R.id.chapter1)
        val chapter2Button = findViewById<Button>(R.id.chapter2)
        val chapter3Button = findViewById<Button>(R.id.chapter3)
        val chapter4Button = findViewById<Button>(R.id.chapter4)

        chapter1Button.setOnClickListener {
            startActivity(Intent(this, Chapter1Activity::class.java))

        }
        chapter2Button.setOnClickListener {
            startActivity(Intent(this, Chapter2Activity::class.java))

        }
        chapter3Button.setOnClickListener {
            startActivity(Intent(this, Chapter3Activity::class.java))
        }

        chapter4Button.setOnClickListener {
            startActivity(Intent(this, Chapter4Activity::class.java))
        }

    }


}




