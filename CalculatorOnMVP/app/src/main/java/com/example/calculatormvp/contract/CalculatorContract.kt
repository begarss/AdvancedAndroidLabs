package com.example.calculatormvp.contract

import com.example.calculatormvp.model.Operator

interface CalculatorContract {
    interface View {

        fun updateDisplay(value: String)
        fun clear()

    }

    interface Presenter {
        fun clearCalculation()
        fun appendValue(value: String)
        fun appendOperator(operator: String)
        fun performCalculation()


    }
}
