package com.example.a0328class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random



class game2 : AppCompatActivity() {
    private lateinit var txtcom: TextView
    private lateinit var txtResult: TextView
    private lateinit var btnscissors: ImageButton
    private lateinit var btnrock: ImageButton
    private lateinit var btnpaper: ImageButton
    private lateinit var imageView:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
        val btnBacktoFirst = findViewById<Button>(R.id.btnBacktoFirst)

        btnBacktoFirst.setOnClickListener {
            //  var mainIntent = Intent(this,MainActivity::class.java)
            //  startActivity(mainIntent)
            finish()
        }

        txtcom = findViewById(R.id.txtcom)
        txtResult = findViewById(R.id.txtResult)
        btnscissors = findViewById(R.id.imbtnscissors)
        btnrock = findViewById(R.id.imbtnrock)
        btnpaper = findViewById(R.id.imbtnpaper)
        imageView = findViewById(R.id.imageView)

        btnscissors.setOnClickListener {
            playGame(Choice.scissors)
        }
        btnrock.setOnClickListener {
            playGame(Choice.rock)
        }
        btnpaper.setOnClickListener {
            playGame(Choice.paper)
        }



    }

    enum class Choice {
        scissors,rock,paper
    }
    fun playGame(playerChoice: Choice) {
        val computerChoice = Choice.values()[Random.nextInt(Choice.values().size)]

        when {
            playerChoice == computerChoice -> {
                txtcom.setText(getChoiceString(computerChoice))
                imageView.setImageResource(getDrawableResource(computerChoice))
                txtResult.setText(R.string.draw)
            }
            (playerChoice == Choice.scissors && computerChoice == Choice.paper) ||
                    (playerChoice == Choice.rock && computerChoice == Choice.scissors) ||
                    (playerChoice == Choice.paper && computerChoice == Choice.rock) -> {
                txtcom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.win)
                imageView.setImageResource(getDrawableResource(computerChoice))
            }
            else -> {
                txtcom.setText(getChoiceString(computerChoice))
                txtResult.setText(R.string.lose)
                imageView.setImageResource(getDrawableResource(computerChoice))
            }
        }
    }


    fun getChoiceString(choice: Choice):Int {
        return when (choice) {
            Choice.scissors ->R.string.scissors
            Choice.rock -> R.string.rock
            Choice.paper ->R.string.paper
        }
    }
    fun getDrawableResource(choice: Choice):Int {
        return when (choice) {
            Choice.scissors ->R.drawable.scissor
            Choice.rock -> R.drawable.rock
            Choice.paper ->R.drawable.paper
        }
    }

}