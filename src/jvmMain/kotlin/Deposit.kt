import java.awt.*
import javax.swing.*
import javax.swing.border.LineBorder
import Classes.SessionPanel
import Classes.LabeledTextField
class Deposit : JFrame() {
    init {
        title = "Materials"
        defaultCloseOperation = EXIT_ON_CLOSE

        val container = JPanel()
        container.layout = BoxLayout(container, BoxLayout.Y_AXIS)

        val sessionMaterialInfo = SessionPanel("MATERIAL INFORMATION")
        sessionMaterialInfo.border = BorderFactory.createCompoundBorder(
            LineBorder(Color(150,185,212), 1), BorderFactory.createEmptyBorder(0, 0, 0, 0)
        )
        container.add(sessionMaterialInfo)

        val formMaterialInfo = JPanel(GridBagLayout())
        formMaterialInfo.preferredSize = Dimension(formMaterialInfo.preferredSize.width, 315)
        formMaterialInfo.minimumSize = Dimension(600, 320)
        formMaterialInfo.maximumSize = Dimension(1200, 320)

        val formMaterial = JPanel(GridBagLayout())
        formMaterial.background = Color.YELLOW
        formMaterial.preferredSize = Dimension(formMaterial.preferredSize.width, 140)
        formMaterial.minimumSize = Dimension(600, 140)
        formMaterial.maximumSize = Dimension(2000, 140)
        val constraints = GridBagConstraints()

        val label = JLabel("Material Designation")
        label.background = Color(236,245,248)
        label.isOpaque = true
        label.minimumSize = Dimension(307,0)
        label.maximumSize = Dimension(307,0)
        label.verticalAlignment = SwingConstants.CENTER
        label.horizontalAlignment = SwingConstants.CENTER
        label.border = BorderFactory.createCompoundBorder(
            LineBorder(Color(150,185,212), 1), BorderFactory.createEmptyBorder(5, 5, 5, 5)
        )

        formMaterialInfo.background = Color.GREEN
        formMaterialInfo.minimumSize = Dimension(container.preferredSize.width, 280)
        formMaterialInfo.maximumSize = Dimension(container.preferredSize.width, 280)

        constraints.gridx = 0
        constraints.gridy = 0
        constraints.anchor = GridBagConstraints.WEST
        constraints.weightx = 0.315
        constraints.weighty = 1.0
        constraints.gridwidth = 1
        constraints.gridheight = 8
        constraints.fill = GridBagConstraints.BOTH
        formMaterialInfo.add(label, constraints)

        val sessionTestedMaterial = SessionPanel("TESTED MATERIAL")
        val sessionTestConditions = SessionPanel("TESTING CONDITIONS AND SPECIMEN INFORMATION")
        val sessionMonotonicProperties= SessionPanel("MONOTONIC PROPERTIES")
        val sessionMonotonicParameters = SessionPanel("MONOTONIC STRESS-STRAIN PARAMETERS AND CURVES - RAMBERG-OSGOOD MODEL")

        container.add(formMaterialInfo)
        container.add(formMaterial)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionTestedMaterial)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionTestConditions)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionMonotonicProperties)
        container.add(Box.createVerticalStrut(10))
        container.add(sessionMonotonicParameters)

        val labeledTextFieldDesignation = LabeledTextField(formMaterial, "Designation additional remarks", 0, 9)
        val labeledTextFieldMaterialGroup = LabeledTextField(formMaterial, "Material group", 0, 10)
        val labeledTextFieldSteelSubGroup = LabeledTextField(formMaterial, "Steel subgroup", 0, 11)
        val labeledTextFieldTypicalApplication = LabeledTextField(formMaterial, "Typical application", 0, 12)
        val labeledTextFieldAISI = LabeledTextField(formMaterialInfo, "AISI", 1, 0)
        val labeledTextFieldAFNOR = LabeledTextField(formMaterialInfo, "AFNOR", 1, 1)
        val labeledTextFieldASTM = LabeledTextField(formMaterialInfo, "ASTM", 1, 2)
        val labeledTextFieldDIN = LabeledTextField(formMaterialInfo, "DIN", 1, 3)
        val labeledTextFieldEN = LabeledTextField(formMaterialInfo, "EN", 1, 4)
        val labeledTextFieldGOST = LabeledTextField(formMaterialInfo, "GOST", 1, 5)
        val labeledTextFieldHRN = LabeledTextField(formMaterialInfo, "HRN", 1, 6)
        val labeledTextFieldISO = LabeledTextField(formMaterialInfo, "ISO", 1, 7)
        val labeledTextFieldJIS = LabeledTextField(formMaterialInfo, "JIS", 2, 0)
        val labeledTextFieldJUS = LabeledTextField(formMaterialInfo, "JUS", 2, 1)
        val labeledTextFieldSAE = LabeledTextField(formMaterialInfo, "SAE", 2, 2)
        val labeledTextFieldSS = LabeledTextField(formMaterialInfo, "SS", 2, 3)
        val labeledTextFieldUNS = LabeledTextField(formMaterialInfo, "UNS", 2, 4)
        val labeledTextFieldWNR = LabeledTextField(formMaterialInfo, "W.Nr.", 2, 5)
        val labeledTextFieldBS = LabeledTextField(formMaterialInfo, "BS", 2, 6)
        val labeledTextFieldOther = LabeledTextField(formMaterialInfo, "Other", 2, 7)

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
