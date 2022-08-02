package br.com.myproject.controller

import br.com.myproject.converters.NumberConverter
import br.com.myproject.exceptions.UnsupportedMathOperationException
import br.com.myproject.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    private val math: SimpleMath = SimpleMath()

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    fun sum(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value= "numberTwo") numberTwo: String?):
        Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    fun sub(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value= "numberTwo") numberTwo: String?):
            Double {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    fun div(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value= "numberTwo") numberTwo: String?):
            Double {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/multi/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value= "numberOne") numberOne: String?,
              @PathVariable(value= "numberTwo") numberTwo: String?):
            Double {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) throw UnsupportedMathOperationException("Please, set a numeric value!")
        return math.multi(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }
}