package co.edu.utadeo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOp)
            entrada.setText("")
        isNewOp = false

        var buclick: String = entrada.text.toString()
        var buselect: Button = view as Button

        when (buselect.id) {
            button_1.id -> {
                buclick += "1"
            }
            button_2.id -> {
                buclick += "2"
            }
            button_3.id -> {
                buclick += "3"
            }
            button_4.id -> {
                buclick += "4"
            }
            button_5.id -> {
                buclick += "5"
            }
            button_6.id -> {
                buclick += "6"
            }
            button_7.id -> {
                buclick += "7"
            }
            button_8.id -> {
                buclick += "8"
            }
            button_9.id -> {
                buclick += "9"
            }
            button_0.id -> {
                buclick += "0"
            }
            button_dot.id -> {
                buclick += "."
            }
            button_mas_menos.id -> {
                buclick = "-$buclick"
            }
        }
        entrada.setText(buclick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = entrada.text.toString()
        var buselect: Button = view as Button

        when (buselect.id) {
            button_multiply.id -> {
                op = "*"
            }
            button_divide.id -> {
                op = "/"
            }
            button_add.id -> {
                op = "+"
            }
            button_subtract.id -> {
                op = "-"
            }
        }
    }

    fun equalEvent(view: View) {
        var newNumber: String = entrada.text.toString()
        var result = 0.0

        when (op) {
            "*" -> {
                result = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                result = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                result = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                result = oldNumber.toDouble() - newNumber.toDouble()
            }
        }
        entrada.setText(result.toString())
    }

    fun clearEvent(view: View) {
        entrada.setText("0")
        isNewOp = true
    }
}