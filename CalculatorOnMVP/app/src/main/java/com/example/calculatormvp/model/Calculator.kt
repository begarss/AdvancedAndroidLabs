package com.example.calculatormvp.model

class Calculator : ICalculatorRepository {
    var firstNumber: String = ""
    var secondNumber: String = ""
    var operator: Operator = Operator.EMPTY
    var state: State = State.EMPTY
    var result: String = ""

    override fun add(): Double {
        return firstNumber.toDouble() + secondNumber.toDouble()
    }

    override fun mult(): Double {
        return firstNumber.toDouble() * secondNumber.toDouble()
    }

    override fun div(): Double {
        return if (firstNumber.toDouble() != 0.0) firstNumber.toDouble() / secondNumber.toDouble() else throw IllegalArgumentException(
            "cannot divide by zero"
        )
    }

    override fun sub(): Double {
        return firstNumber.toDouble() - secondNumber.toDouble()
    }

}