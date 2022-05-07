package co.edu.utadeo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
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
        }
        button_1.setOnClickListener {
            entrada.text = addToInputText("1")
        }
        button_2.setOnClickListener {
            entrada.text = addToInputText("2")
        }
        button_3.setOnClickListener {
            entrada.text = addToInputText("3")
        }
        button_4.setOnClickListener {
            entrada.text = addToInputText("4")
        }
        button_5.setOnClickListener {
            entrada.text = addToInputText("5")
        }
        button_6.setOnClickListener {
            entrada.text = addToInputText("6")
        }
        button_7.setOnClickListener {
            entrada.text = addToInputText("7")
        }
        button_8.setOnClickListener {
            entrada.text = addToInputText("8")
        }
        button_9.setOnClickListener {
            entrada.text = addToInputText("9")
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
        button_equal.setOnClickListener {
            showResult()
        }

    }

    private fun addToInputText(buttonValue: String): String {
        return "${entrada.text}$buttonValue"
    }

    private fun getInputExpression(): String {
        var expression = entrada.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                //Aqui va el error del if
                salida.text = "Error"
            } else {
                //Aqui va el resultado
                salida.text = DecimalFormat("0.#######").format(result).toString()
            }
        } catch (e: Exception) {
            //Aqui va el mensaje si aparece error en la excepcion
            salida.text = "Error en la excepcion"

        }
    }

}