package com.app.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val STATE_PENDING_OPERATION = "PendingOperation"
private const val STATE_OPERAND_1 = "Operand1"
private const val STATE_OPERAND1_STORED = "Operand1_Stored"

class MainActivity : AppCompatActivity() {


    //    Variables for operands
    private var operand1: Double? = null
    private var pendingOperation = "="


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listner = View.OnClickListener { v ->
            val b = v as Button
            newNumber.append(b.text)
        }


        button0.setOnClickListener(listner)
        button1.setOnClickListener(listner)
        button2.setOnClickListener(listner)
        button3.setOnClickListener(listner)
        button4.setOnClickListener(listner)
        button5.setOnClickListener(listner)
        button6.setOnClickListener(listner)
        button7.setOnClickListener(listner)
        button8.setOnClickListener(listner)
        button9.setOnClickListener(listner)
        buttonDot.setOnClickListener(listner)

        val opListner = View.OnClickListener { v: View? ->
            val op = (v as Button).text.toString()
            try {
                val value = newNumber.text.toString().toDouble()
                performOperation(value, op)
            } catch (e: NumberFormatException) {
                newNumber.setText("")
            }
            pendingOperation = op
            operator.text = pendingOperation
        }

        buttonNeg.setOnClickListener { v: View? ->
            val value = newNumber.text.toString()
            if(value.isEmpty()){
                newNumber.setText("-")
            }else{
                try {
                    var doubleValue = value.toDouble()
                    doubleValue *= -1
                    newNumber.setText(doubleValue.toString())
                } catch (e: NumberFormatException) {
//                    if newnumber was "-" or "."
                    newNumber.setText("")
                }
            }
        }

        buttonEqual.setOnClickListener(opListner)
        buttonAdd.setOnClickListener(opListner)
        buttonSub.setOnClickListener(opListner)
        buttonMultiply.setOnClickListener(opListner)
        buttonDivide.setOnClickListener(opListner)


    }

    private fun performOperation(value: Double, operation: String) {
        if (operand1 == null) {
            operand1 = value
        } else {
            if (pendingOperation == "=") {
                pendingOperation = operation
            }

            when (pendingOperation) {
                "=" -> operand1 = value
                "/" -> if (value == 0.0) {
                    Toast.makeText(this, "${Double.NaN}", Toast.LENGTH_SHORT).show()
                    operand1 = 0.0
                } else {
                    operand1 = operand1!! / value
                }
                "+" -> operand1 = operand1!! + value
                "-" -> operand1 = operand1!! - value
                "*" -> operand1 = operand1!! * value
            }
        }
        result.setText(operand1.toString())
        newNumber.setText("")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        operand1 = if (savedInstanceState.getBoolean(STATE_OPERAND1_STORED, false)) {
            savedInstanceState.getDouble(STATE_OPERAND_1)
        } else {
            null
        }
        operator.text = savedInstanceState.get(STATE_PENDING_OPERATION) as CharSequence
//        Log.d("onSaveInstanceState", "${displayOperation.text}, $operand1, ${savedInstanceState.getBoolean(
//            STATE_OPERAND1_STORED)}")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_PENDING_OPERATION, operator.text.toString())
        if (operand1 != null) {
            outState.putDouble(STATE_OPERAND_1, operand1!!)
            outState.putBoolean(STATE_OPERAND1_STORED, true)
        }
//        Log.d("onSaveInstanceState", "${displayOperation.text}, $operand1, ${outState?.getBoolean(
//            STATE_OPERAND1_STORED)}")

    }
}