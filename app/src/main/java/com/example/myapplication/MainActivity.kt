package com.example.myapplication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.math.*
import kotlin.math.sqrt
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

lateinit var textView: TextView
lateinit var  textViewSec: TextView
var operation = "+"
var firstNumber = ""
var oper = true
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.header)
        textViewSec = findViewById<TextView>(R.id.headers)
    }

    fun onOperationClick(view: View) {
        if(oper)
            textView.setText("")
        oper=  false
        textView.text = textView.text.toString() +(view as Button).text
    }

    fun OperClick(view: View) {
        oper = true
        firstNumber = textView.text.toString()
        var bic:Button = view as Button
        when (bic.id)
        {
            R.id.minus -> textView.text = "-"
            R.id.plus -> textView.text = "+"
            R.id.delitel -> textView.text = "÷"
            R.id.multi -> textView.text = "×"
        }
        operation = textView.text.toString()
    }

    fun Result(view: View) {
        var secNumber:String = textView.text.toString()
        var result = "0.0"
        when(operation){
            "+"->{
                result = (firstNumber.toDouble() + secNumber.toDouble()).toString()
                textViewSec.text = "$firstNumber" + "+" + secNumber + "=" +"$result"
            }
            "-"->{
                result = (firstNumber.toDouble() - secNumber.toDouble()).toString()
                textViewSec.text = "$firstNumber" + "-" +secNumber + "=" +"$result"
            }
            "×"->{
                result = (firstNumber.toDouble() * secNumber.toDouble()).toString()
                textViewSec.text = "$firstNumber" + "*" +secNumber + "=" +"$result"
            }
            "÷"->{
                var check:String = secNumber.toDouble().toString()
                if(check.toString().toDouble() == 0.0)
                {
                    result = "Нельзя делить на ноль"
                }
                else
                result = (firstNumber.toDouble() / secNumber.toDouble()).toString()
                textViewSec.text = "$firstNumber" + "/" + secNumber + "=" +"$result"
            }

        }
        textView.text = result
    }

    fun deleteEvent(view: View) {
        textView.setText("0")
        oper = true
    }

    fun PersClick(view: View) {
        var percent = textView.text.toString().toDouble()/100
        textView.setText(percent.toString())
        oper = true
    }

    fun psclick(view: View) {
        var sk:Double =-textView.text.toString().toDouble()
        textView.text = sk.toString()
    }

    fun stepenclick(view: View) {



        var step:Double = textView.text.toString().toDouble().pow(2)
        textView.text = step.toString()
        oper = true
    }


    }
