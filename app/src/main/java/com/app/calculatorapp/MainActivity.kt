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

        val viewModel = ViewModelProviders.of(this).get(CalculatorViewModel::class.java)

        viewModel.result.observe(this, Observer<String> { resultStr ->
            result.setText(resultStr)
        })

        viewModel.newNumber.observe(
            this,
            Observer<String> { newNumStr -> newNumber.setText(newNumStr) })

        viewModel.operator.observe(this, Observer<String> { operatorStr ->
            operator.text = operatorStr
        })

        val listner = View.OnClickListener { v ->
            viewModel.digitPressed((v as Button).text.toString())
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
            viewModel.operandPressed((v as Button).text.toString())
        }

        buttonNeg.setOnClickListener { v: View? ->
            viewModel.negPressed()
        }

        buttonEqual.setOnClickListener(opListner)
        buttonAdd.setOnClickListener(opListner)
        buttonSub.setOnClickListener(opListner)
        buttonMultiply.setOnClickListener(opListner)
        buttonDivide.setOnClickListener(opListner)
    }
}