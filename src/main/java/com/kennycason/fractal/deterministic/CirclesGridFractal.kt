package com.kennycason.fractal.stochastic

import javafx.geometry.Dimension2D
import javafx.geometry.Point2D
import java.awt.*
import java.util.*

/**
 * Created by kenny on 7/11/16.
 */
class CirclesGridFractal(val radius: Int = 220,
                         val minRadius: Int = 4,
                         val color: Color = Color.WHITE) {

    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = color
        drawHelper(g, x, y, radius)
    }

    private fun drawHelper(g: Graphics, x: Int, y: Int, radius: Int) {
        if (radius <= minRadius) { return }

        val radiusHalf = radius.div(2).toInt()

        g.drawOval(x - radiusHalf, y - radiusHalf, radius, radius)

        drawHelper(g, x + radiusHalf, y, radiusHalf)
        drawHelper(g, x - radiusHalf, y, radiusHalf)
        drawHelper(g, x, y + radiusHalf, radiusHalf)
        drawHelper(g, x, y - radiusHalf, radiusHalf)
    }

}