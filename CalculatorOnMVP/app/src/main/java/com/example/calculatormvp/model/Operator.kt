package com.example.calculatormvp.model


enum class Operator(private val operator: String) {
    EMPTY(""), PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    override fun toString(): String {
        return operator
    }

    companion object {
        fun getOperator(operator: String?): Operator {
            var op = EMPTY
            when (operator) {
                "+" -> op = PLUS
                "-" -> op = MINUS
                "*" -> op = MULTIPLY
                "/" -> op = DIVIDE
            }
            return op
        }
    }

}
