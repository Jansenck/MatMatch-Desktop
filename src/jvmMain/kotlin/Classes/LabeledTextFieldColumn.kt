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

class LabeledTextFieldColumn(
    private val form: JPanel,
    private val isSubtitle: Boolean,
    private val labelName: String,
    private val gridx: Int,
    private val gridy: Int
) {
    private val label = JLabel(labelName)
    private val textField = JTextField(20)

    init {
        customizeLabel()
        customizeTextField()
        addComponentsToForm()
    }

    private fun customizeLabel() {
        label.border = createBorder(Color(152, 188, 215))
        label.background = Color(236, 245, 248)
        label.foreground = Color(51, 83, 127)
        label.isOpaque = true

        if(gridx == 0) {
            label.preferredSize.width = 400
        } else {
            label.preferredSize.width + 30
        }

        label.preferredSize = Dimension(label.preferredSize.width.coerceAtLeast(110), 25)
    }

    private fun customizeTextField() {
        textField.preferredSize = Dimension(0, 25)
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

    private fun addComponentsToForm() {

        var gridWidthElement = 1;
        if(gridx == 0){
            gridWidthElement = 2
        } else if(labelName == "Other"){
            gridWidthElement = 6;
        }

        val constraints = GridBagConstraints().apply {
            gridx = this@LabeledTextFieldColumn.gridx
            gridy = this@LabeledTextFieldColumn.gridy
            anchor = GridBagConstraints.EAST
            weightx = 1.0
            weighty = 0.0
            gridwidth = gridWidthElement
            gridheight = if (isSubtitle) 8 else 1
            fill = GridBagConstraints.BOTH
        }
        form.add(label, constraints)

        if (!isSubtitle) {
            constraints.apply {
                gridx = if (gridx == 0) this@LabeledTextFieldColumn.gridx + 2 else this@LabeledTextFieldColumn.gridx
                gridy = if (gridx == 0) this@LabeledTextFieldColumn.gridy else this@LabeledTextFieldColumn.gridy + 1
                anchor = GridBagConstraints.EAST
                weightx = 1.0
                weighty = 0.0
                gridwidth = if (gridx == 0) 2 else if (labelName == "Other") 6 else 1
                gridheight = 1
            }

            form.add(textField, constraints)
        }
    }
}
