import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Insets
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.*
import javax.swing.border.LineBorder

class SessionPanel(subSessionTitle: String, form: JPanel) : JPanel(BorderLayout()) {

    init {
        preferredSize = Dimension(Int.MAX_VALUE, 35)
        minimumSize = Dimension(Int.MAX_VALUE, 35)
        maximumSize = Dimension(Int.MAX_VALUE, 35)

        val label = createTitleLabel(subSessionTitle)
        val toggleButton = createToggleButton()

        val buttonPanel = createButtonPanel(toggleButton)

        add(label, BorderLayout.WEST)
        add(buttonPanel, BorderLayout.EAST)

        background = Color(181,208,227)

        border = BorderFactory.createCompoundBorder(
            LineBorder(Color(150,185,212), 1), BorderFactory.createEmptyBorder(5, 15, 5, 5)
        )



        toggleButton.addActionListener(SessionPanelToggleButtonListener(form))
    }

    private fun createTitleLabel(title: String): JLabel {
        val label = JLabel(title)
        label.foreground = Color(51,51,51)
        return label
    }

    private fun createToggleButton(): JButton {
        val toggleButton = JButton()
        toggleButton.alignmentX = RIGHT_ALIGNMENT

        val icon = ImageIcon("assets/images/arrow.png")
        val image = icon.image.getScaledInstance(10, 15, java.awt.Image.SCALE_SMOOTH)
        val resizedIcon = ImageIcon(image)

        toggleButton.icon = resizedIcon
        toggleButton.background = Color(230,235,227)
        toggleButton.isContentAreaFilled = false
        toggleButton.isOpaque= true
        toggleButton.isFocusPainted = false
        toggleButton.isContentAreaFilled = false

        Insets(0, 0, 0, 0).also { toggleButton.margin = it }
        toggleButton.preferredSize = Dimension(30,30)

        toggleButton.border = BorderFactory.createCompoundBorder(
            LineBorder(Color(150, 150, 212), 1),
            BorderFactory.createEmptyBorder(2, 5, 2, 5)
        )

        return toggleButton
    }

    private fun createButtonPanel(toggleButton: JButton): JPanel {
        val buttonPanel = JPanel(BorderLayout())
        buttonPanel.add(toggleButton, BorderLayout.EAST)
        return buttonPanel
    }

    private class SessionPanelToggleButtonListener(val form: JPanel) : ActionListener {
        override fun actionPerformed(e: ActionEvent) {
            form.isVisible = !form.isVisible
        }
    }
}
