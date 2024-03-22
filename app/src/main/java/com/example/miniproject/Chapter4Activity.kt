package com.example.miniproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Chapter4Activity : AppCompatActivity() {
    private val correctAnswers = listOf(
        "Doctor", "Teacher", "Engineer", "Lawyer", "Architect",
        "Chef", "Artist", "Pilot", "Scientist", "Firefighter",
        "Police", "Actor", "Nurse", "Farmer", "Footballer"
    )

    private lateinit var occupationImageView: ImageView
    private lateinit var questionTextView: TextView
    private lateinit var answerEditText: EditText
    private lateinit var submitAnswerButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var scoreTextView: TextView

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter4)

        occupationImageView = findViewById(R.id.occupationImageView)
        questionTextView = findViewById(R.id.questionTextView)
        answerEditText = findViewById(R.id.answerEditText)
        submitAnswerButton = findViewById(R.id.submitAnswerButton)
        resultTextView = findViewById(R.id.resultTextView)
        scoreTextView = findViewById(R.id.scoreTextView)

        submitAnswerButton.setOnClickListener {
            checkAnswer()
        }

        updateQuestion()
    }

    private fun updateQuestion() {
        val currentOccupation = correctAnswers[currentQuestionIndex]
        val drawableResourceId = resources.getIdentifier(currentOccupation.toLowerCase(), "drawable", packageName)
        occupationImageView.setImageResource(drawableResourceId)
        scoreTextView.text = "${currentQuestionIndex + 1}/15"
    }

    private fun checkAnswer() {
        val userAnswer = answerEditText.text.toString()
        val correctAnswer = correctAnswers[currentQuestionIndex]
        if (userAnswer.equals(correctAnswer, ignoreCase = true)) {
            score++
            showResult("Correct", Color.GREEN)
        } else {
            showResult("Wrong", Color.RED)
        }
        currentQuestionIndex++
        if (currentQuestionIndex < correctAnswers.size) {
            updateQuestion()
            answerEditText.text.clear()
        } else {
            val intent = Intent(this, Score4Activity::class.java).apply {
                putExtra("SCORE", score)
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)
            finish()
        }
    }

    private fun showResult(message: String, color: Int) {
        resultTextView.apply {
            text = message
            setTextColor(color)
            visibility = View.VISIBLE
        }
    }
}
