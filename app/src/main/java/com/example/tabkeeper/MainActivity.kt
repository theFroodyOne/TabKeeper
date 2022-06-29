package com.example.tabkeeper

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.roundToInt

//todo: undo button?

/**
 * The main activity for this app. Intended to keep track of the tabs for multiple people who are
 * splitting a bill at a restaurant or bar
 */
class MainActivity : AppCompatActivity() {
    private var TOTAL: Double = 0.0 //variable to store the total bill so far
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    
    /**
     * Main method to calculate tabs thus far. Triggered whenever any of the buttons are pressed
     * @param view The particular button that triggered this method
     */
    fun calculate(view: View){
        val buttonNum = view.id
        val valueOffset = 414   //offsets needed to get from the id of the button that has been
        val tabOffset = 336 //pressed to the id for the corresponding value, tab and tabTip views
        val tabTipOffset = 346
        //retrieve the tip as a double
        val tipValue = findViewById<EditText>(R.id.tipEditTextNumber).text.toString()
        val tip: Double = if(tipValue == ""){
            0.0
        }else{
            tipValue.toDouble()/100
        }
        //retrieve the value that must be added to the tab
        val value = findViewById<EditText>(buttonNum + valueOffset).text.toString()
        val num: Double = if(value == ""){
            0.0
        }else{
            value.toDouble()
        }
        //retrieve the tab up to this point
        val tab = findViewById<TextView>(buttonNum + tabOffset)
        val tabString = tab.text.toString()
        val prevNum: Double = if(tabString == ""){
            0.0
        }else{
            tabString.toDouble()
        }
        //add the newest value to the running totals
        val newNum = ((num + prevNum)*100).roundToInt().toDouble()/100
        val newNumTip = (newNum*(1+tip)*100).roundToInt().toDouble()/100
        val tabTip = findViewById<TextView>(buttonNum + tabTipOffset)
        tab.text = newNum.toString()
        tabTip.text = newNumTip.toString()
        //increase the total of all tabs commensurately
        TOTAL += num
        val total = findViewById<TextView>(R.id.tabTotal)
        total.text = TOTAL.toString()
        val totalTip = findViewById<TextView>(R.id.tabTipTotal)
        totalTip.text = (((((TOTAL)*(1+tip))*100).roundToInt().toDouble())/100).toString()
    }
}