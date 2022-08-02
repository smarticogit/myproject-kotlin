package br.com.myproject.math

import org.springframework.web.bind.annotation.PathVariable

class SimpleMath {

    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo

    fun sub(numberOne: Double, numberTwo: Double) = numberOne - numberTwo

    fun multi(numberOne: Double, numberTwo: Double) = numberOne * numberTwo

    fun div(numberOne: Double, numberTwo: Double) = numberOne / numberTwo
}