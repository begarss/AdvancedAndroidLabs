package com.example.calculatormvp.model

interface ICalculatorRepository {
    fun add(): Double

    fun mult(): Double

    fun div(): Double

    fun sub(): Double
}