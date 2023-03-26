package Classes
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Insets
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import javax.swing.border.LineBorder

class SessionMaterialsData(sessionTitle: String) : JPanel(BorderLayout()) {

    init {
        preferredSize = Dimension(Int.MAX_VALUE, 40)
        minimumSize = Dimension(Int.MAX_VALUE, 40)
        maximumSize = Dimension(Int.MAX_VALUE, 40)

        val label = createTitleLabel(sessionTitle)
        add(label, BorderLayout.WEST)

        background = Color(27,90,161)

        border = BorderFactory.createCompoundBorder(
            LineBorder(Color(19,54,96), 1), BorderFactory.createEmptyBorder(5, 15, 5, 5)
        )

    }

    private fun createTitleLabel(title: String): JLabel {
        val label = JLabel(title)
        label.foreground = Color.WHITE
        return label
    }
}
