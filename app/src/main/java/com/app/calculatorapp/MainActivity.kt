package com.app.calculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)
        val viewModel = ViewModelProviders.of(this).get(BigDecimalViewModel::class.java)

        viewModel.stringResult.observe(this, Observer<String> { resultStr ->
            result.setText(resultStr)
        })

        viewModel.stringNewNumber.observe(
            this,
            Observer<String> { newNumStr -> newNumber.setText(newNumStr) })

        viewModel.stringOperator.observe(this, Observer<String> { operatorStr ->
            operator.text = operatorStr
        })

        val listener = View.OnClickListener { v ->
            viewModel.digitPressed((v as Button).text.toString())
        }

        button0.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)

        val opListener = View.OnClickListener { v: View? ->
            viewModel.operandPressed((v as Button).text.toString())
        }

        buttonNeg.setOnClickListener {
            viewModel.negPressed()
        }

        buttonEqual.setOnClickListener(opListener)
        buttonAdd.setOnClickListener(opListener)
        buttonSub.setOnClickListener(opListener)
        buttonMultiply.setOnClickListener(opListener)
        buttonDivide.setOnClickListener(opListener)
    }
}