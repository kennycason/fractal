package com.kennycason.fractal.stochastic

import javafx.geometry.Dimension2D
import javafx.geometry.Point2D
import java.awt.*
import java.util.*

/**
 * Created by kenny on 7/11/16.
 */
class StochasticLineFractal(val depth: Int = 5,
                            val branches: Int = 2,
                            val maxBranchLength: Int = 100,
                            val color: Color = Color.WHITE) {
    private val random = Random()

    fun draw(g: Graphics, x: Int, y: Int) {
        g.color = color
        (1..branches).forEach {
            draw(g, x, y, 0)
        }
    }

    private fun draw(g: Graphics, x: Int, y: Int, currentDepth: Int) {
        if (currentDepth == depth) { return }
        val colorScale = 0xFF / depth

        g.color = Color(
                color.red - colorScale * currentDepth,
                color.green - colorScale * currentDepth,
                color.blue - colorScale * currentDepth)

        (1..branches).forEach {
            val toX = x + random.nextInt(maxBranchLength + 1) - (maxBranchLength / 2)
            val toY = y + random.nextInt(maxBranchLength + 1) - (maxBranchLength / 2)
            g.drawLine(x, y, toX, toY)
            draw(g, toX, toY, currentDepth + 1)
        }

    }

}