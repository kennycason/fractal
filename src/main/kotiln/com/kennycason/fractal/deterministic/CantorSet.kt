package com.kennycason.fractal.stochastic

import javafx.geometry.Dimension2D
import javafx.geometry.Point2D
import java.awt.*
import java.util.*

/**
 * Created by kenny on 7/11/16.
 */
class CantorSet(val startLength: Int = 600,
                val minLength: Int = 1,
                val rectangleHeight: Int = 20,
                val spaceHeight: Int = 20,
                val color: Color = Color.WHITE) {

    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = color
        drawHelper(g, x, y, startLength)
    }

    private fun drawHelper(g: Graphics, x: Int, y: Int, length: Int) {
        if (length <= minLength) { return }

        g.fillRect(x, y, length, rectangleHeight)

        val newY = y + (rectangleHeight + spaceHeight)

        drawHelper(g, x, newY, length / 3)
        drawHelper(g, x + (length * 2 / 3), newY, length / 3)
    }

}