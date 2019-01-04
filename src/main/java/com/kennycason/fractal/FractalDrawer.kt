package com.kennycason.fractal

import com.kennycason.fractal.stochastic.*
import java.awt.Color
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

/**
 * Created by kenny on 7/11/16.
 */
fun main(args: Array<String>) {
    FractalDrawer().run()
}

class FractalDrawer {
    val width = 800
    val height = 600
    val canvas: BufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)
    val canvasGraphics = canvas.graphics

    val stochasticLineFractal = StochasticLineFractal(branches = 2, depth = 7, maxBranchLength = 100)
    val circlesLineFractal = CirclesLineFractal(radius = 220, minRadius = 4)
    val circlesGridFractal = CirclesGridFractal(radius = 220, minRadius = 4)
    val cantorSet = CantorSet()
    val sierpinskiTriangle = SierpinskiTriangle()

    fun run() {
        val frame = JFrame()
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        frame.setSize(width + 18, height + 24)
        frame.setVisible(true)

        val panel = object: JPanel() {
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                canvasGraphics.color = Color.BLACK
                canvasGraphics.fillRect(0, 0, width, height)

               // stochasticLineFractal.draw(canvasGraphics, width / 2, height / 2)
                // circlesLineFractal.draw(canvasGraphics, width / 2, height / 2)
               // circlesGridFractal.draw(canvasGraphics, width / 2, height / 2)
               //  cantorSet.draw(canvasGraphics, 10, 10)
                sierpinskiTriangle.draw(canvasGraphics, 8, 10f, 10f, 650f)

                g.drawImage(canvas, 0, 0, width, height, this)
            }
        }
        frame.add(panel)
        panel.revalidate()

        do {
            panel.repaint()
            Thread.sleep(2500)
        } while (true)
    }

}
