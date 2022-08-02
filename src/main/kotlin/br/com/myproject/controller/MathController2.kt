package br.com.myproject.controller

import br.com.myproject.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

//@RestController
class MathController2 {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    fun sum(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value= "numberTwo") numberTwo: String?):
        Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    fun sub(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value= "numberTwo") numberTwo: String?):
            Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    fun div(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value= "numberTwo") numberTwo: String?):
            Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/multi/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value= "numberOne") numberOne: String?,
              @PathVariable(value= "numberTwo") numberTwo: String?):
            Double {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false;
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}