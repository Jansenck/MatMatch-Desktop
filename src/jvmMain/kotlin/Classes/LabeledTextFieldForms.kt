package Classes

import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.Insets
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
class LabeledTextFieldForms(val form: JPanel, labelName: String, val gridx: Int, val gridy: Int) {

    val label = JLabel(labelName)
    val textField = JTextField(20)

    init{
        textField.border = CustomBorder(10)
        textField.preferredSize = Dimension(0, 40)

        val constraints = GridBagConstraints()

        constraints.gridx = gridx
        constraints.gridy = gridy
        constraints.insets = Insets(10, 10, 10, 10)
        constraints.anchor = GridBagConstraints.LINE_START
        constraints.fill = GridBagConstraints.HORIZONTAL
        form.add(label, constraints)

        constraints.gridx = gridx
        constraints.gridy = gridy +1
        constraints.insets = Insets(10, 10, 10, 10)
        constraints.anchor = GridBagConstraints.LINE_START
        constraints.fill = GridBagConstraints.HORIZONTAL
        form.add(textField, constraints)
    }
}