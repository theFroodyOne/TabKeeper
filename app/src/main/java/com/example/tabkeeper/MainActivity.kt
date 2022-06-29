package com.example.tabkeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView


//todo: undo button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculate(view: View){
        val buttonNum = view.id
        val value = findViewById<EditText>(buttonNum + 414).text.toString()   //buttonNum + 414 is the corresponding value textbox
        val num: Int = if(value == ""){
            0
        }else{
            value.toInt()
        }
        val tab = findViewById<TextView>(buttonNum + 336)
        val tabString = tab.text.toString()
        //val prevNum = tab.text.toString().toInt()
        val prevNum: Int = if(tabString == ""){
            0
        }else{
            tabString.toInt()
        }
        val newNum = num + prevNum
        tab.text = newNum.toString()
    }
}