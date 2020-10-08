package com.vaibhav.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage : ImageView
    private lateinit var numberDisplay : TextView
    private lateinit var reset : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        numberDisplay = findViewById(R.id.number_display)
        reset = findViewById(R.id.reset)

        val rollButton : Button = findViewById(R.id.roll_button);
        rollButton.setOnClickListener {rollDice()}

        reset.setOnClickListener { resetButton() }
    }

    private fun rollDice(){
        val randomInt = (1..5).random()
        val drawableResource = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        setNumber(number = randomInt)
    }

    private fun setNumber(number : Int){
        numberDisplay.text = "Number is: $number"
    }

    private fun resetButton() {
        diceImage.setImageResource(R.drawable.empty_dice)
        numberDisplay.text = "Roll the Dice!"
    }
}