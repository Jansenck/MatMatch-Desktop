package Classes

import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.Insets
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.border.LineBorder
class LabeledTextField(val form: JPanel, labelName: String, val gridx: Int, val gridy: Int) {
    val label = JLabel(labelName)
    val textField = JTextField(20)
    init {

        if(gridx == 0) {
            label.preferredSize = label.preferredSize.width.coerceAtLeast(110).let { Dimension(270, 35) }
        } else {
            label.preferredSize = label.preferredSize.width.coerceAtLeast(110).let { Dimension(it +30, 35) }
            label.minimumSize = label.preferredSize
        }

        label.border = BorderFactory.createEmptyBorder(0,10,0,0)
        label.border = BorderFactory.createCompoundBorder(
            LineBorder(Color(152,188,215), 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)
        )
        label.background = 	Color(236,245,248)
        label.isOpaque = true

        textField.preferredSize = Dimension(0,35)
        textField.border = BorderFactory.createCompoundBorder(
            LineBorder(Color(150,185,212), 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)
        )
        textField.background = Color(250,251,253)
        textField.isOpaque = true

        val constraints = GridBagConstraints()
        constraints.gridx = gridx
        constraints.gridy = gridy
        constraints.anchor = GridBagConstraints.EAST
        constraints.weightx = 0.0
        constraints.weighty = 1.0
        constraints.gridwidth = 1
        constraints.gridheight = 1
        form.add(label, constraints)

        constraints.fill = GridBagConstraints.HORIZONTAL
        constraints.insets = Insets(0, 0, 0, 140)
        constraints.ipadx = 0
        constraints.ipady = 0

        constraints.gridx = gridx + 1
        constraints.gridy = gridy
        constraints.anchor = GridBagConstraints.WEST
        constraints.weightx = 1.0
        constraints.weighty = 1.0
        constraints.gridwidth = 1
        constraints.gridheight = 1
        form.add(textField, constraints)
    }
}