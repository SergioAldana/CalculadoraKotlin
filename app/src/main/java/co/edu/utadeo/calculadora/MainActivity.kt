package co.edu.utadeo.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun presionarDigito(view: View) {
        val tv_num2: TextView = findViewById(R.id.tv_num2)
        val num2: String = tv_num2.text.toString()

        when(view.id) {
            R.id.cero -> tv_num2.setText(num2 + "0")
            R.id.uno -> tv_num2.setText(num2 + "1")
            R.id.dos -> tv_num2.setText(num2 + "2")
            R.id.tres -> tv_num2.setText(num2 + "3")
            R.id.cuatro -> tv_num2.setText(num2 + "4")
            R.id.cinco -> tv_num2.setText(num2 + "5")
            R.id.seis -> tv_num2.setText(num2 + "6")
            R.id.siete -> tv_num2.setText(num2 + "7")
            R.id.ocho -> tv_num2.setText(num2 + "8")
            R.id.nueve -> tv_num2.setText(num2 + "9")
            R.id.punto -> tv_num2.setText(num2 + ".")
        }
    }
}