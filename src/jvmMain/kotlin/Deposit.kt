import java.awt.*
import javax.swing.*
import Classes.LabeledTextField
class Deposit : JFrame() {
    init {
        title = "Materials"
        defaultCloseOperation = EXIT_ON_CLOSE
        minimumSize = Dimension(1300, 600)

        val container = JPanel(GridBagLayout())
        container.layout = BoxLayout(container, BoxLayout.Y_AXIS)

        val formMaterialInfo = JPanel(GridBagLayout())

        val sessionMaterialInfo = SessionPanel("MATERIAL INFORMATION", formMaterialInfo)
        container.add(sessionMaterialInfo)

        formMaterialInfo.isOpaque = true
        formMaterialInfo.preferredSize = Dimension(800, 325)
        formMaterialInfo.minimumSize = Dimension(container.preferredSize.width, 325)
        formMaterialInfo.maximumSize = Dimension(container.preferredSize.width, 325)

        container.add(formMaterialInfo)
        container.add(Box.createVerticalStrut(10))

        val subtitleMaterialDesignation = LabeledTextField(formMaterialInfo, true,"Material Designation", 0, 0)
        val labeledTextFieldDesignation = LabeledTextField(formMaterialInfo, false, "Designation additional remarks", 0, 9)
        val labeledTextFieldMaterialGroup = LabeledTextField(formMaterialInfo, false,"Material group", 0, 10)
        val labeledTextFieldSteelSubGroup = LabeledTextField(formMaterialInfo, false,"Steel subgroup", 0, 11)
        val labeledTextFieldTypicalApplication = LabeledTextField(formMaterialInfo, false,"Typical application", 0, 12)
        val labeledTextFieldAISI = LabeledTextField(formMaterialInfo, false,"AISI", 2, 0)
        val labeledTextFieldAFNOR = LabeledTextField(formMaterialInfo, false,"AFNOR", 2, 1)
        val labeledTextFieldASTM = LabeledTextField(formMaterialInfo, false,"ASTM", 2, 2)
        val labeledTextFieldDIN = LabeledTextField(formMaterialInfo, false,"DIN", 2, 3)
        val labeledTextFieldEN = LabeledTextField(formMaterialInfo, false,"EN", 2, 4)
        val labeledTextFieldGOST = LabeledTextField(formMaterialInfo, false,"GOST", 2, 5)
        val labeledTextFieldHRN = LabeledTextField(formMaterialInfo, false,"HRN", 2, 6)
        val labeledTextFieldISO = LabeledTextField(formMaterialInfo, false,"ISO", 2, 7)
        val labeledTextFieldJIS = LabeledTextField(formMaterialInfo, false,"JIS", 4, 0)
        val labeledTextFieldJUS = LabeledTextField(formMaterialInfo, false,"JUS", 4, 1)
        val labeledTextFieldSAE = LabeledTextField(formMaterialInfo, false,"SAE", 4, 2)
        val labeledTextFieldSS = LabeledTextField(formMaterialInfo, false,"SS", 4, 3)
        val labeledTextFieldUNS = LabeledTextField(formMaterialInfo, false,"UNS", 4, 4)
        val labeledTextFieldWNR = LabeledTextField(formMaterialInfo, false,"W.Nr.", 4, 5)
        val labeledTextFieldBS = LabeledTextField(formMaterialInfo, false,"BS", 4, 6)
        val labeledTextFieldOther = LabeledTextField(formMaterialInfo, false,"Other", 4, 7)

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


