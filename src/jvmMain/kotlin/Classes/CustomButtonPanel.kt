package Classes

import java.awt.*
import javax.swing.*

class CustomButtonPanel(
    private val form: JPanel,
    private val buttonName: String,
    private val gridx: Int,
    private val gridy: Int,
) : JPanel() {

    init {
        val submitButton = CustomButton("Submit")
        submitButton.name = "submit$buttonName"
        submitButton.background = Color(82, 97, 147)
        submitButton.border = BorderFactory.createEmptyBorder(5, 5, 5, 5)

        submitButton.addActionListener {
            val nComponents = form.componentCount
            for (i in 0 until nComponents) {
                val component = form.getComponent(i)
                if (component is JTextField) {
                    val label = form.getComponent(i-1) as JLabel
                    val text = component.text
                    if(text.isNotEmpty()) println("${label.text}: $text")
                }
            }
        }

        val buttonPanel = JPanel(GridBagLayout()).apply {
            minimumSize = Dimension(300, 30)
            maximumSize = Dimension(300, 30)

            val constraints = GridBagConstraints().apply {
                gridx = 1
                gridy = 0
                fill = GridBagConstraints.HORIZONTAL
                weightx = 1.0
                weighty = 1.0
                anchor = GridBagConstraints.EAST
                fill = GridBagConstraints.VERTICAL
                insets = Insets(10, 10, 0, 0)
            }

            add(Box.createHorizontalStrut(10), GridBagConstraints().apply {
                gridx = 0
                gridy = 0
                weightx = 0.0
                fill = GridBagConstraints.BOTH
                anchor = GridBagConstraints.EAST
            })

            add(submitButton, constraints)
        }

        val constraintsForms = GridBagConstraints().apply {
            gridx = this@CustomButtonPanel.gridx
            gridy = this@CustomButtonPanel.gridy
            anchor = GridBagConstraints.LINE_END
            weightx = 1.0
            weighty = 1.0
            gridwidth = 1
            gridheight = 1
            fill = GridBagConstraints.BOTH
        }
        form.add(buttonPanel, constraintsForms)
        form.add(Box.createVerticalStrut(10))
    }
}
