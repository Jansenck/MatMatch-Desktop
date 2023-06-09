package Classes

import java.awt.*
import javax.swing.border.AbstractBorder
class InvalidInputStyle(private val border: Int) : AbstractBorder() {
    override fun paintBorder(c: Component, g: Graphics, x: Int, y: Int, width: Int, height: Int) {
        val g2 = g as Graphics2D
        g2.stroke = BasicStroke(border.toFloat())
        g2.color = Color.RED;
        g2.drawRoundRect(x, y, width - 1, height - 1, 10, 10)
    }
    override fun getBorderInsets(c: Component): Insets {
        return Insets(border, border +10, border, border +10)
    }
}