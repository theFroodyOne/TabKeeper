package com.example.tabkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt


//todo: undo button

class MainActivity : AppCompatActivity() {
    private var TOTAL: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View){
        val buttonNum = view.id
        val tipValue = findViewById<EditText>(R.id.tipEditTextNumber).text.toString()
        val tip: Double = if(tipValue == ""){
            0.0
        }else{
            tipValue.toDouble()/100
        }
        val value = findViewById<EditText>(buttonNum + 414).text.toString()   //buttonNum + 414 is the corresponding value textbox
        val num: Double = if(value == ""){
            0.0
        }else{
            value.toDouble()
        }
        val tab = findViewById<TextView>(buttonNum + 336)
        val tabString = tab.text.toString()
        val prevNum: Double = if(tabString == ""){
            0.0
        }else{
            tabString.toDouble()
        }
        val newNum = ((num + prevNum)*100).roundToInt().toDouble()/100
        val newNumTip = (newNum*(1+tip)*100).roundToInt().toDouble()/100
        val tabTip = findViewById<TextView>(buttonNum + 346)
        tab.text = newNum.toString()
        tabTip.text = newNumTip.toString()
        TOTAL += num
        val total = findViewById<TextView>(R.id.tabTotal)
        total.text = TOTAL.toString()
        val totalTip = findViewById<TextView>(R.id.tabTipTotal)
        totalTip.text = (((((TOTAL)*(1+tip))*100).roundToInt().toDouble())/100).toString()
        //
    }
}