package com.kennycason.fractal.stochastic

import javafx.geometry.Dimension2D
import javafx.geometry.Point2D
import java.awt.*
import java.util.*

/**
 * Created by kenny on 7/11/16.
 */
class SierpinskiTriangle( val color: Color = Color.WHITE) {

    fun draw(g: Graphics, n: Int, x: Float, y: Float, size: Float) {
        if (n == 0) { return }

        g.color = Color.WHITE

        val x1: Float = x
        val y1: Float = y
        val x2 : Float = x1 + size
        val y2: Float = y1
        val x3: Float = x1 + size / 2f
        val y3: Float = (y1 + Math.sqrt(3.0) * size / 2f).toFloat()

        g.drawLine(x1.toInt(), y1.toInt(), x2.toInt(), y2.toInt())
        g.drawLine(x1.toInt(), y1.toInt(), x3.toInt(), y3.toInt())
        g.drawLine(x2.toInt(), y2.toInt(), x3.toInt(), y3.toInt())

        draw(g, n - 1, x1, y1, size / 2f)
        draw(g, n - 1, (x1 + x2) / 2f, (y1 + y2) / 2f, size / 2f)
        draw(g, n - 1, (x1 + x3) / 2f, (y1 + y3) / 2f, size / 2f)
    }

}