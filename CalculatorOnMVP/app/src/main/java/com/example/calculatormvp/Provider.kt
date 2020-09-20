package com.example.calculatormvp

import com.example.calculatormvp.contract.CalculatorContract
import com.example.calculatormvp.model.Calculator
import com.example.calculatormvp.presenter.CalculatorPresenter

class Provider {
    fun getCalculatorPresenter(view: CalculatorContract.View): CalculatorContract.Presenter {
        return CalculatorPresenter(view, getRepo())
    }

    private fun getRepo(): Calculator {
        return Calculator()
    }
}