package Classes

import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.border.LineBorder
class LabeledTextFieldRow(val form: JPanel, isSubtitle: Boolean, labelName: String, val gridx: Int, val gridy: Int) {
    val label = JLabel(labelName)
    val textField = JTextField(20)
    init {
        if(gridx == 0) {
            label.preferredSize = label.preferredSize.width.coerceAtLeast(110).let { Dimension(400, 25) }
        } else {
            label.preferredSize = label.preferredSize.width.coerceAtLeast(110).let { Dimension(it +30, 25) }
        }

        label.border = BorderFactory.createEmptyBorder(0,10,0,0)
        label.border = BorderFactory.createCompoundBorder(
            LineBorder(Color(152,188,215), 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)
        )
        label.background = 	Color(236,245,248)
        label.foreground = Color(51,83,127)
        label.isOpaque = true

        textField.preferredSize = Dimension(0,25)
        textField.border = BorderFactory.createCompoundBorder(
            LineBorder(Color(150,185,212), 1), BorderFactory.createEmptyBorder(5, 15, 5, 5)
        )
        textField.background = Color(250,251,253)
        textField.isOpaque = true

        val constraints = GridBagConstraints()
        constraints.gridx = gridx
        constraints.gridy = gridy
        constraints.anchor = GridBagConstraints.EAST
        constraints.weightx = 0.0
        constraints.weighty = 0.0
        constraints.gridwidth = if (gridx == 0) 2 else 1
        constraints.gridheight = if (isSubtitle) 8 else 1
        constraints.fill = GridBagConstraints.BOTH
        form.add(label, constraints)

        if(!isSubtitle){
            constraints.gridx = if(gridx == 0) gridx + 2 else gridx +1
            constraints.gridy = gridy
            constraints.anchor = GridBagConstraints.EAST
            constraints.weightx = 1.0
            constraints.weighty = 0.0
            constraints.gridwidth = if(gridx == 0) 6 else 1
            constraints.gridheight = 1
            form.add(textField, constraints)
        }
    }
}