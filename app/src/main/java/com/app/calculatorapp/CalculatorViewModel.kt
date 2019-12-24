package com.app.calculatorapp


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    //    Variables for operands
    private var operand1: Double? = null
    private var pendingOperation = "="

    val result = MutableLiveData<String>()
    val newNumber = MutableLiveData<String>()
    val operator = MutableLiveData<String>()

    fun digitPressed(digit: String) {

        if (newNumber.value != null) {
            newNumber.value = newNumber.value + digit
        } else {
            newNumber.value = digit
        }
    }

    fun operandPressed(op: String) {
        try {
            val value = newNumber.value?.toDouble()
            if (value != null)
                performOperation(value, op)
        } catch (e: NumberFormatException) {
            newNumber.value = ""
        }
        pendingOperation = op
        operator.value = pendingOperation

    }

    fun negPressed() {
        val value = newNumber.value
        if (value == null || value.isEmpty()) {
            newNumber.value = "-"
        } else {
            try {
                var doubleValue = value.toDouble()
                doubleValue *= -1
                newNumber.value = doubleValue.toString()
            } catch (e: NumberFormatException) {
//                    if newnumber was "-" or "."
                newNumber.value = ""
            }
        }

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
                "/" -> operand1 = if (value == 0.0) {
                    Double.NaN
                } else {
                    operand1!! / value
                }
                "+" -> operand1 = operand1!! + value
                "-" -> operand1 = operand1!! - value
                "*" -> operand1 = operand1!! * value
            }
        }
        result.value = operand1.toString()
        newNumber.value = ""
    }

}