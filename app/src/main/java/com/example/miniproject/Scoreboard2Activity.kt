package com.example.miniproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Scoreboard2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard2)


        val player1Score = intent.getIntExtra("PLAYER_1_SCORE", 0)



        val player1ScoreTextView = findViewById<TextView>(R.id.player1ScoreTextView)



        player1ScoreTextView.text = "Player 1 Score: $player1Score"



        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
