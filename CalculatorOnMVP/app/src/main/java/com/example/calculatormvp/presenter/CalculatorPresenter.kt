package com.example.calculatormvp.presenter

import com.example.calculatormvp.contract.CalculatorContract
import com.example.calculatormvp.model.Calculator
import com.example.calculatormvp.model.Operator
import com.example.calculatormvp.model.State

class CalculatorPresenter(
    var view: CalculatorContract.View,
    val repository: Calculator
) : CalculatorContract.Presenter {
    override fun clearCalculation() {
        repository.firstNumber = ""
        repository.secondNumber = ""
        repository.operator = Operator.EMPTY
        repository.state = State.EMPTY
        view.clear()
    }


    override fun appendValue(value: String) {
        when (repository.state) {
            State.EMPTY -> {
                view.updateDisplay("")
                repository.state = State.FIRST_NUMBER_ADDED
                repository.firstNumber = value
            }
            State.OPERATION -> {
                repository.state = State.SECOND_NUMBER_ADDED
                repository.secondNumber = value
            }
            State.FIRST_NUMBER_ADDED -> {
                repository.firstNumber += value
            }
            State.SECOND_NUMBER_ADDED -> {
                repository.secondNumber += value
            }
        }
        view.updateDisplay(value)
    }

    override fun appendOperator(operator: String) {
        when (repository.state) {
            State.FIRST_NUMBER_ADDED -> {
                repository.operator = Operator.getOperator(operator)
                repository.state = State.OPERATION
                view.updateDisplay(operator)
            }
            State.OPERATION -> {
                repository.operator = Operator.getOperator(operator)
                repository.state = State.OPERATION
                view.updateDisplay(operator)
            }
            else -> {
            }
        }
    }

    override fun performCalculation() {
        when (repository.state) {
            State.FIRST_NUMBER_ADDED -> {
                view.updateDisplay(repository.firstNumber)
            }
            State.SECOND_NUMBER_ADDED -> {
                if (repository.firstNumber.isNotEmpty() || repository.secondNumber.isNotEmpty()) {
                    when (repository.operator) {
                        Operator.PLUS -> repository.result = repository.add().toString()
                        Operator.DIVIDE -> repository.result = repository.div().toString()
                        Operator.MINUS -> repository.result = repository.sub().toString()
                        Operator.MULTIPLY -> repository.result = repository.mult().toString()
                    }
                }
            }
        }
        setResult(repository.result)

    }

    private fun setResult(result: String) {
        repository.operator = Operator.EMPTY
        repository.secondNumber = ""
        repository.firstNumber = result
        repository.state = State.FIRST_NUMBER_ADDED
        view.clear()
        view.updateDisplay(result)
    }


}