package com.example.miniproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Scoreboard1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreboard1)

        // Get individual scores from Intent extras
        val player1Score = intent.getIntExtra("PLAYER_1_SCORE", 0)


        // Initialize TextViews
        val player1ScoreTextView = findViewById<TextView>(R.id.player1ScoreTextView)


        // Display scores for each player
        player1ScoreTextView.text = "Player 1 Score: $player1Score"


        // Initialize Next button
        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            // Go to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish this activity to prevent going back to it when pressing the back button
        }
    }
}
