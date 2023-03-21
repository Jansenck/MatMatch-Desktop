package Classes

import java.awt.Color
import java.awt.Dimension
import java.awt.FlowLayout
import javax.swing.JLabel
import javax.swing.JPanel
class SessionPanel(title: String) : JPanel(FlowLayout(FlowLayout.LEFT)) {
    init {
        preferredSize = Dimension(Int.MAX_VALUE, 30)
        maximumSize = Dimension(Int.MAX_VALUE, 20)

        val label = JLabel(title)
        add(label)
        background = Color(181,208,227)
        label.foreground = Color.BLACK
    }
}