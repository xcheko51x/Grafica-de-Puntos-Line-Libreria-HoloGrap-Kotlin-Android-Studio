package com.example.linealgraph_holograph_kotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.echo.holographlibrary.Line
import com.echo.holographlibrary.LineGraph
import com.echo.holographlibrary.LinePoint
import com.example.linealgraph_holograph_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvPuntos.text = "PUNTOS \n"

        var linea = Line()
        linea = datosGrafica(linea, 1.0, 1.0)
        linea = datosGrafica(linea, 2.0, 9.0)
        linea = datosGrafica(linea, 3.0, 3.0)
        linea = datosGrafica(linea, 4.0, 5.0)
        linea.color = Color.parseColor("FFBB33")

        graficar(linea)

        binding.lineGrafica.setOnPointClickedListener { lineIndex, pointIndex ->
            Toast.makeText(
                this@MainActivity,
                "Linea: $lineIndex, Punto: $pointIndex",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    fun datosGrafica(linea: Line, ejeX: Double, ejeY: Double): Line {
        val punto = LinePoint()
        punto.setX(ejeX)
        punto.setY(ejeY)
        linea.addPoint(punto)

        binding.tvPuntos.text = "${binding.tvPuntos.text}\nX: $ejeX, Y:$ejeY"

        return linea
    }

    fun graficar(linea: Line) {
        binding.lineGrafica.addLine(linea)
        binding.lineGrafica.setRangeX(1f, 4f)
        binding.lineGrafica.setRangeY(0f, 10f)
        binding.lineGrafica.lineToFill = 0
    }
}