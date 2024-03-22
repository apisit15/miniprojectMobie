package com.example.miniproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Score4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score4)

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val nextButton = findViewById<Button>(R.id.nextButton)

        val score = intent.getIntExtra("SCORE", 0)
        scoreTextView.text = "$score/15"

        nextButton.setOnClickListener {

            val intent = Intent(this, Scoreboard4Activity::class.java)

            intent.putExtra("PLAYER_1_SCORE", score)
            intent.putExtra("PLAYER_2_SCORE", score)
            intent.putExtra("PLAYER_3_SCORE", score)

            startActivity(intent)

            finish()
        }
    }
}
