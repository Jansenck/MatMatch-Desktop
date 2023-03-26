package Classes

import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import javax.swing.BorderFactory
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.border.Border
import javax.swing.border.LineBorder

class LabelSingle(
    private val form: JPanel,
    private val type: String,
    private val labelName: String,
    private val gridx: Int,
    private val gridy: Int
) {
    private val label = JLabel(labelName)
    private val textFieldValue = JTextField(20).apply { name = labelName + "Value" }
    private val textFieldMethod = JTextField(20).apply { name = labelName + "Method" }

    init {
        if(gridx == 0) {
            label.preferredSize = label.preferredSize.width.coerceAtLeast(110).let { Dimension(400, 30) }
        } else {
            label.preferredSize = label.preferredSize.width.coerceAtLeast(110).let { Dimension(it +30, 30) }
        }
        customizeLabel()
        if(type == "labelOnly"){
            customizeTextField(textFieldValue)
            addLabelToForm()
        } else {
            customizeTextField(textFieldMethod)
            addLabelAnd2FieldsToForm()
        }
    }

    private fun customizeLabel() {
        label.preferredSize = Dimension(
            label.preferredSize.width.coerceAtLeast(110),30
        )
        label.maximumSize = Dimension(Int.MAX_VALUE,30)
        label.border = createBorder(Color(152, 188, 215))
        label.background = Color(236, 245, 248)
        label.foreground = Color(51, 83, 127)
        label.isOpaque = true
    }
    private fun customizeTextField(textField: JTextField) {
        textField.preferredSize = Dimension(0, 10)
        textField.border = createBorder(Color(150, 185, 212))
        textField.background = Color(250, 251, 253)
        textField.isOpaque = true
    }
    private fun createBorder(color: Color): Border {
        return BorderFactory.createCompoundBorder(
            LineBorder(color, 1),
            BorderFactory.createEmptyBorder(5, 15, 5, 5)
        )
    }
    private fun addLabelToForm() {

        val constraints = GridBagConstraints().apply {
            gridx = this@LabelSingle.gridx
            gridy = this@LabelSingle.gridy
            anchor = GridBagConstraints.EAST
            weightx = 0.0
            weighty = 0.0
            gridwidth = if(gridx == 0) 2 else 3
            gridheight = 1
            fill = GridBagConstraints.BOTH
        }
        form.add(label, constraints)
    }
    private fun addLabelAnd2FieldsToForm() {

        val constraints = GridBagConstraints().apply {
            gridx = this@LabelSingle.gridx
            gridy = this@LabelSingle.gridy
            anchor = GridBagConstraints.EAST
            weightx = 0.0
            weighty = 0.0
            gridwidth = if(this@LabelSingle.gridx == 0) 2 else 3
            gridheight = 1
            fill = GridBagConstraints.BOTH
        }
        form.add(label, constraints)

        constraints.apply {
            gridx = this@LabelSingle.gridx + 2
            gridy = this.gridy
            anchor = GridBagConstraints.EAST
            weightx = 0.0
            weighty = 0.0
            gridwidth = 3
            gridheight = 1
        }
        customizeTextField(textFieldValue)
        form.add(textFieldValue, constraints)

        constraints.apply {
            gridx = this@LabelSingle.gridx + 5
            gridy = this.gridy
            anchor = GridBagConstraints.EAST
            weightx = 0.0
            weighty = 0.0
            gridwidth = 3
            gridheight = 1
        }
        customizeTextField(textFieldMethod)
        form.add(textFieldMethod, constraints)
    }
}
