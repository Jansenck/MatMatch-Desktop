import java.awt.*
import javax.swing.*
import kotlinx.html.InputType

class SessionPanel(title: String) : JPanel(FlowLayout(FlowLayout.LEFT)) {
    init {
        preferredSize = Dimension(Int.MAX_VALUE, 30)
        maximumSize = Dimension(Int.MAX_VALUE, 20)

        val label = JLabel(title)
        add(label)
        background = Color(82, 97, 147)
        label.foreground = Color.WHITE
    }
}

class LabeledTextField(val formMaterialInfo: JPanel, labelName: String, val gridx: Int, val gridy: Int) {
    private val label = JLabel(labelName)
    val textField = JTextField(20)

    init {
        val constraints = GridBagConstraints()
        constraints.gridx = gridx
        constraints.gridy = gridy
        constraints.anchor = GridBagConstraints.EAST
        constraints.weightx = 0.0
        constraints.weighty = 1.0
        constraints.gridwidth = 1
        constraints.gridheight = 1
        formMaterialInfo.add(label, constraints)

        constraints.gridx = gridx + 1
        constraints.gridy = gridy
        constraints.anchor = GridBagConstraints.WEST
        constraints.weightx = 1.0
        constraints.weighty = 1.0
        constraints.gridwidth = 1
        constraints.gridheight = 1
        formMaterialInfo.add(textField, constraints)
    }
}

class Deposit : JFrame() {
    init {
        title = "Materials"
        defaultCloseOperation = EXIT_ON_CLOSE

        val container = JPanel()
        container.layout = BoxLayout(container, BoxLayout.Y_AXIS)

        val labelMaterialInfo = JLabel("MATERIAL INFORMATION")
        val sessionMaterialInfo = SessionPanel("MATERIAL INFORMATION")
        sessionMaterialInfo.add(labelMaterialInfo)
        container.add(sessionMaterialInfo)

        val formMaterialInfo = JPanel(GridBagLayout())
        formMaterialInfo.preferredSize = Dimension(formMaterialInfo.preferredSize.width, 200)
        val constraints = GridBagConstraints()

        val labelSubSessionMaterialInfo = JLabel("Material Designation")
        val subSessionMaterialInfoForm = JPanel()
        subSessionMaterialInfoForm.preferredSize = Dimension(200, 200)
        val label = JLabel("Material Designation")
        label.horizontalAlignment = SwingConstants.CENTER
        subSessionMaterialInfoForm.add(label)

        constraints.gridx = 0
        constraints.gridy = 0
        constraints.anchor = GridBagConstraints.WEST
        constraints.weightx = 1.0
        constraints.weighty = 1.0
        constraints.gridwidth = 2
        constraints.gridheight = 8
        formMaterialInfo.add(subSessionMaterialInfoForm, constraints)

        val labeledTextFieldAISI = LabeledTextField(formMaterialInfo, "AISI", 2, 0)
        val labeledTextFieldAFNOR = LabeledTextField(formMaterialInfo, "AFNOR", 2, 1)
        val labeledTextFieldASTM = LabeledTextField(formMaterialInfo, "ASTM", 2, 2)
        val labeledTextFieldDIN = LabeledTextField(formMaterialInfo, "DIN", 2, 3)
        val labeledTextFieldEN = LabeledTextField(formMaterialInfo, "EN", 2, 4)
        val labeledTextFieldGOST = LabeledTextField(formMaterialInfo, "GOST", 2, 5)
        val labeledTextFieldHRN = LabeledTextField(formMaterialInfo, "HRN", 2, 6)
        val labeledTextFieldISO = LabeledTextField(formMaterialInfo, "ISO", 2, 7)
        val labeledTextFieldJIS = LabeledTextField(formMaterialInfo, "JIS", 3, 0)
        val labeledTextFieldJUS = LabeledTextField(formMaterialInfo, "JUS", 3, 1)
        val labeledTextFieldSAE = LabeledTextField(formMaterialInfo, "SAE", 3, 2)
        val labeledTextFieldSS = LabeledTextField(formMaterialInfo, "SS", 3, 3)
        val labeledTextFieldUNS = LabeledTextField(formMaterialInfo, "UNS", 3, 4)
        val labeledTextFieldWNR = LabeledTextField(formMaterialInfo, "W.Nr.", 3, 5)
        val labeledTextFieldOther = LabeledTextField(formMaterialInfo, "Other", 3, 6)
        val labeledTextFieldBS = LabeledTextField(formMaterialInfo, "BS", 3, 7)

        val labelTestedMaterial = JLabel("TESTED MATERIAL")
        val sessionTestedMaterial = SessionPanel("TESTED MATERIAL")
        val labelTestConditions = JLabel("TESTING CONDITIONS AND SPECIMEN INFORMATION")
        val sessionTestConditions = SessionPanel("TESTING CONDITIONS AND SPECIMEN INFORMATION")
        val labelMonotonicProperties = JLabel("MONOTONIC PROPERTIES")
        val sessionMonotonicProperties= SessionPanel("MONOTONIC PROPERTIES")
        val labelMonotonicParameters = JLabel("MONOTONIC STRESS-STRAIN PARAMETERS AND CURVES - RAMBERG-OSGOOD MODEL")
        val sessionMonotonicParameters = SessionPanel("MONOTONIC STRESS-STRAIN PARAMETERS AND CURVES - RAMBERG-OSGOOD MODEL")

        container.add(formMaterialInfo)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionTestedMaterial)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionTestConditions)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionMonotonicProperties)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionMonotonicParameters)

        contentPane.add(container, BorderLayout.CENTER)

        pack()
        setLocationRelativeTo(null)
        isVisible = true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Deposit()
        }
    }
}
