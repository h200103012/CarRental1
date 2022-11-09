package com.example.carrental


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout

class discountFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skydka, container, false)
    }
}

class Activity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.skydka)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }


    class Dice(val numSides: Int) {

        fun roll(): Int {
            return (10..20).random()
        }
    }


    private fun rollDice() {

        val dice = Dice(8)
        val diceRoll = dice.roll()
        val diceImage: ImageView = findViewById(R.id.imageView2)
        val resultTextView: TextView = findViewById(R.id.textView6)
        resultTextView.text = diceRoll.toString()



        val drawableResource = R.drawable.random_1

        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()
    }

}