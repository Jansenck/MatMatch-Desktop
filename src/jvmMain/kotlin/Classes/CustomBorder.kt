package Classes

import java.awt.*
import javax.swing.border.AbstractBorder
class CustomBorder(private val height: Int) : AbstractBorder() {
    override fun paintBorder(c: Component, g: Graphics, x: Int, y: Int, width: Int, height: Int) {
        val g2 = g as Graphics2D
        g2.color = Color(82, 97, 147)
        g2.drawRoundRect(x, y, width - 1, height - 1, 10, 3)
    }
    override fun getBorderInsets(c: Component): Insets {
        return Insets(height, 10, height, 10)
    }
}