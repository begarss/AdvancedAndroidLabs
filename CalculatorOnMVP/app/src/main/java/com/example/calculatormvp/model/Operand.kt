package com.example.calculatormvp.model

class Operand {

    var value = EMPTY_VALUE


    fun appendValue(value: String) {
        if (this.value == EMPTY_VALUE) {
            this.value = value
        } else {
            this.value += value
        }
    }


    fun reset() {
        value = EMPTY_VALUE
    }

    companion object {
        const val EMPTY_VALUE = "0"
        const val ERROR_VALUE = "ERROR"
        const val MAX_LENGTH = 10
        const val MAX_DECIMAL_DIGITS = 1
    }
}
