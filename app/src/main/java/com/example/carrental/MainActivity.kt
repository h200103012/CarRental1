package com.example.carrental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.skydka)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        // Do a dice roll when the app starts
        rollDice()
    }


    class Dice(val numSides: Int) {

        fun roll(): Int {
            return (10..20).random()
        }
    }


    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {

        val dice = Dice(8)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView2)
        val resultTextView: TextView = findViewById(R.id.textView6)
        resultTextView.text = diceRoll.toString()



        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = R.drawable.random_1

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

}

