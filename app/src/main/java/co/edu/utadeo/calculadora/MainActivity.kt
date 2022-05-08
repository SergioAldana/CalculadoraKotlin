package co.edu.utadeo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var identificador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener {
            entrada.text = ""
            salida.text = ""
        }

        button_bracket_left.setOnClickListener {
            entrada.text = addToInputText("(")
        }
        button_bracket_right.setOnClickListener {
            entrada.text = addToInputText(")")
        }
        button_0.setOnClickListener {
            entrada.text = addToInputText("0")
            identificador = 0
        }
        button_1.setOnClickListener {
            entrada.text = addToInputText("1")
            identificador = 1
        }
        button_2.setOnClickListener {
            entrada.text = addToInputText("2")
            identificador = 2
        }
        button_3.setOnClickListener {
            entrada.text = addToInputText("3")
            identificador = 3
        }
        button_4.setOnClickListener {
            entrada.text = addToInputText("4")
            identificador = 4
        }
        button_5.setOnClickListener {
            entrada.text = addToInputText("5")
            identificador = 5
        }
        button_6.setOnClickListener {
            entrada.text = addToInputText("6")
            identificador = 6
        }
        button_7.setOnClickListener {
            entrada.text = addToInputText("7")
            identificador = 7
        }
        button_8.setOnClickListener {
            entrada.text = addToInputText("8")
            identificador = 8
        }
        button_9.setOnClickListener {
            entrada.text = addToInputText("9")
            identificador = 9
        }
        button_comma.setOnClickListener {
            entrada.text = addToInputText(",")
        }
        button_divide.setOnClickListener {
            entrada.text = addToInputText("÷")
        }
        button_multiply.setOnClickListener {
            entrada.text = addToInputText("×")
        }
        button_subtract.setOnClickListener {
            entrada.text = addToInputText("-")
        }
        button_add.setOnClickListener {
            entrada.text = addToInputText("+")
        }
        button_mas_menos.setOnClickListener {
            //entrada.text = addToInputText("-")
            //conversionNumero()
            entrada.text = ("-$")
        }
        button_equal.setOnClickListener {
            showResult()
        }

    }

    private fun addToInputText(buttonValue: String): String {
        return "${entrada.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = entrada.text
        expression = expression.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        expression = expression.replace(Regex(","), ".")
        return expression
    }

    /**
    private fun conversionNumero() {
        try {
            when (identificador) {
                0 -> {
                    var cero = Integer.parseInt(entrada.text as String)
                    val retorno = cero * -1
                }
                1 -> {
                    var uno = entrada.text.toString().toInt()
                    val retorno = uno * -1
                    retorno.toString()
                }
                2 -> {
                    Integer.parseInt(entrada.text as String)
                    var dos = Integer.parseInt(entrada.text as String)
                    val retorno = dos * -1
                    retorno.toString()
                }
                3 -> Integer.parseInt(entrada.text as String)
                4 -> Integer.parseInt(entrada.text as String)
                5 -> Integer.parseInt(entrada.text as String)
                6 -> Integer.parseInt(entrada.text as String)
                7 -> Integer.parseInt(entrada.text as String)
                8 -> Integer.parseInt(entrada.text as String)
                9 -> Integer.parseInt(entrada.text as String)
            }

            //multiplicando por -1 cambia para ambos valores
            //le puede llegar no solo numero
            //verificacion de que se a un nmero

        } catch (e: Exception) {
            salida.text = "Error en el metodo conversionNumero"
        }
    }


    private fun numberButtonClick() {
        if (operadorCliqueado) {
            operando1 = strNumber.toString().toInt()
            strNumber.clear
            operadorCliqueado = false
        }
    }
    */

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                salida.text = "Error"
            } else {
                salida.text = DecimalFormat("0.#######").format(result).toString()
            }
        } catch (e: Exception) {
            salida.text = "Error en el metodo showResult"
        }
    }
}