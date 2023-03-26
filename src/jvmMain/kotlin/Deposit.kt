
import Classes.LabelSingle
import Classes.LabeledTextFieldColumn
import Classes.LabeledTextFieldRow
import Classes.SessionMaterialsData
import java.awt.*
import javax.swing.*

class Deposit : JFrame() {
    init {
        title = "Deposit"
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        setSize(screenSize.width, screenSize.height)

        defaultCloseOperation = EXIT_ON_CLOSE
        minimumSize = Dimension(screenSize.width, screenSize.height)

        val container = JPanel(GridBagLayout())
        container.layout = BoxLayout(container, BoxLayout.Y_AXIS)
        container.preferredSize = Dimension(screenSize.width, screenSize.height -100)

        val scrollPane = JScrollPane(container)
        scrollPane.verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS

        val sessionGeneralInformation = SessionMaterialsData("Session General Information");
        container.add(sessionGeneralInformation)
        container.add(Box.createVerticalStrut(10))

        val formMaterialInfo = JPanel(GridBagLayout())
        formMaterialInfo.minimumSize = Dimension(container.preferredSize.width, 300)
        formMaterialInfo.maximumSize = Dimension(container.preferredSize.width, 300)

        val sessionMaterialInfo = SessionPanel("MATERIAL INFORMATION", formMaterialInfo)
        container.add(sessionMaterialInfo)

        container.add(formMaterialInfo)
        container.add(Box.createVerticalStrut(10))

        val subtitleMaterialDesignation = LabeledTextFieldRow(formMaterialInfo, true,"Material Designation", 0, 0)
        val labeledTextFieldDesignation = LabeledTextFieldRow(formMaterialInfo, false, "Designation additional remarks", 0, 9)
        val labeledTextFieldMaterialGroup = LabeledTextFieldRow(formMaterialInfo, false,"Material group", 0, 10)
        val labeledTextFieldSteelSubGroup = LabeledTextFieldRow(formMaterialInfo, false,"Steel subgroup", 0, 11)
        val labeledTextFieldTypicalApplication = LabeledTextFieldRow(formMaterialInfo, false,"Typical application", 0, 12)
        val labeledTextFieldAISI = LabeledTextFieldRow(formMaterialInfo, false,"AISI", 2, 0)
        val labeledTextFieldAFNOR = LabeledTextFieldRow(formMaterialInfo, false,"AFNOR", 2, 1)
        val labeledTextFieldASTM = LabeledTextFieldRow(formMaterialInfo, false,"ASTM", 2, 2)
        val labeledTextFieldDIN = LabeledTextFieldRow(formMaterialInfo, false,"DIN", 2, 3)
        val labeledTextFieldEN = LabeledTextFieldRow(formMaterialInfo, false,"EN", 2, 4)
        val labeledTextFieldGOST = LabeledTextFieldRow(formMaterialInfo, false,"GOST", 2, 5)
        val labeledTextFieldHRN = LabeledTextFieldRow(formMaterialInfo, false,"HRN", 2, 6)
        val labeledTextFieldISO = LabeledTextFieldRow(formMaterialInfo, false,"ISO", 2, 7)
        val labeledTextFieldJIS = LabeledTextFieldRow(formMaterialInfo, false,"JIS", 4, 0)
        val labeledTextFieldJUS = LabeledTextFieldRow(formMaterialInfo, false,"JUS", 4, 1)
        val labeledTextFieldSAE = LabeledTextFieldRow(formMaterialInfo, false,"SAE", 4, 2)
        val labeledTextFieldSS = LabeledTextFieldRow(formMaterialInfo, false,"SS", 4, 3)
        val labeledTextFieldUNS = LabeledTextFieldRow(formMaterialInfo, false,"UNS", 4, 4)
        val labeledTextFieldWNR = LabeledTextFieldRow(formMaterialInfo, false,"W.Nr.", 4, 5)
        val labeledTextFieldBS = LabeledTextFieldRow(formMaterialInfo, false,"BS", 4, 6)
        val labeledTextFieldOtherMaterialInfo = LabeledTextFieldRow(formMaterialInfo, false,"Other", 4, 7)

        val formTestedMaterial = JPanel(GridBagLayout())
        formTestedMaterial.background = Color.GREEN
        formTestedMaterial.minimumSize = Dimension(container.preferredSize.width, 475)
        formTestedMaterial.maximumSize = Dimension(container.preferredSize.width, 475)

        val sessionTestedMaterial = SessionPanel("TESTED MATERIAL", formTestedMaterial)
        container.add(sessionTestedMaterial)

        container.add(formTestedMaterial)
        container.add(Box.createVerticalStrut(10))

        val subtitleChemicalComposition = LabeledTextFieldColumn(formTestedMaterial, true,"Chemical composition, (%)", 0, 0)
        val labeledTextFieldSemiFinishedMaterial = LabeledTextFieldRow(formTestedMaterial, false,"Semifinished material (source)", 0, 8)
        val labeledTextFieldOtherHeatTreatment  = LabeledTextFieldRow(formTestedMaterial, false,"Heat treatment ", 0, 9)
        val labeledTextFieldAdditionalRemarksHTreatment = LabeledTextFieldRow(formTestedMaterial, false,"Additional remarks", 0, 10)
        val labeledTextFieldMicrostructure = LabeledTextFieldRow(formTestedMaterial, false,"Microstructure", 0, 11)
        val labeledTextFieldAdditionalRemarksMicro = LabeledTextFieldRow(formTestedMaterial, false,"Additional remarks", 0, 12)
        val labelHardness = LabelSingle(formTestedMaterial, "labelOnly","Hardness", 0, 13)
        val labelValue= LabelSingle(formTestedMaterial, "labelOnly","Value(s)", 2, 13)
        val labelMethod= LabelSingle(formTestedMaterial, "labelOnly","Method", 5, 13)
        val labeledTextFieldsBrinell= LabelSingle(formTestedMaterial, "labeledTextFields","Brinell", 0, 14)
        val labeledTextFieldsVickers= LabelSingle(formTestedMaterial, "labeledTextFields","Vickers", 0, 15)
        val labeledTextFieldsRockwell= LabelSingle(formTestedMaterial, "labeledTextFields","Rockwell", 0, 16)
        val labeledTextFieldsAdditionalRemarks= LabelSingle(formTestedMaterial, "labeledTextFields","Additional remarks:", 0, 17)

        val labeledTextFieldCarbon = LabeledTextFieldColumn(formTestedMaterial, false, "C", 2, 0)
        val labeledTextFieldSilicon = LabeledTextFieldColumn(formTestedMaterial, false,"Si", 3, 0)
        val labeledTextFieldManganese = LabeledTextFieldColumn(formTestedMaterial, false,"Mn", 4, 0)
        val labeledTextFieldPhosphorus = LabeledTextFieldColumn(formTestedMaterial, false,"P", 5, 0)
        val labeledTextFieldASulfur = LabeledTextFieldColumn(formTestedMaterial, false,"S", 6, 0)
        val labeledTextFieldChromium = LabeledTextFieldColumn(formTestedMaterial, false,"Cr", 7, 0)
        val labeledTextFieldMolybdenum = LabeledTextFieldColumn(formTestedMaterial, false,"Mo", 2, 2)
        val labeledTextFieldNickel = LabeledTextFieldColumn(formTestedMaterial, false,"Ni", 3, 2)
        val labeledTextFieldCooper = LabeledTextFieldColumn(formTestedMaterial, false,"Cu", 4, 2)
        val labeledTextFieldAluminium = LabeledTextFieldColumn(formTestedMaterial, false,"Al", 5, 2)
        val labeledTextFieldCobalt = LabeledTextFieldColumn(formTestedMaterial, false,"Co", 6, 2)
        val labeledTextFieldTitanium = LabeledTextFieldColumn(formTestedMaterial, false,"Ti", 7, 2)
        val labeledTextFieldTungsten = LabeledTextFieldColumn(formTestedMaterial, false,"W", 2, 4)
        val labeledTextFieldVanadium = LabeledTextFieldColumn(formTestedMaterial, false,"V", 3, 4)
        val labeledTextFieldNiobium = LabeledTextFieldColumn(formTestedMaterial, false,"Nb", 4, 4)
        val labeledTextFieldNitrogen = LabeledTextFieldColumn(formTestedMaterial, false,"N", 5, 4)
        val nullSpace1 = LabeledTextFieldColumn(formTestedMaterial, false,"", 6, 4)
        val nullSpace2 = LabeledTextFieldColumn(formTestedMaterial, false,"", 7, 4)
        val labeledTextFieldOtherMaterialTested = LabeledTextFieldColumn(formTestedMaterial, false,"Other", 2, 6)

        val sessionMonotonicData = SessionMaterialsData("MONOTONIC DATA - AXIAL LOADING");
        container.add(sessionMonotonicData)
        container.add(Box.createVerticalStrut(10))

        val formTestingConditions = JPanel(GridBagLayout())
        formTestingConditions.minimumSize = Dimension(container.preferredSize.width, 125)
        formTestingConditions.maximumSize = Dimension(container.preferredSize.width, 125)

        val subSessionTestConditions = SessionPanel("TESTING CONDITIONS AND SPECIMEN INFORMATION", formTestingConditions)
        container.add(subSessionTestConditions)

        container.add(formTestingConditions)
        container.add(Box.createVerticalStrut(10))

        val labeledTextFieldTestingTemperature = LabeledTextFieldRow(formTestingConditions, false,"Testing temperature, T (°C)", 0, 0)
        val labeledTextFieldTestingMedium  = LabeledTextFieldRow(formTestingConditions, false, "Testing medium", 0, 1)
        val labeledTextFieldLoadingType  = LabeledTextFieldRow(formTestingConditions, false,"Loading type", 0, 2)
        val labeledTextFieldLoadingControl = LabeledTextFieldRow(formTestingConditions, false,"Loading control", 0, 3)
        val labeledTextFieldSpecimen  = LabeledTextFieldRow(formTestingConditions, false,"Specimen", 0, 4)
        val labeledTextFieldAdditionalRemarks  = LabeledTextFieldRow(formTestingConditions, false,"Additional remarks", 0, 4)

        val formMonotonicProperties = JPanel(GridBagLayout())
        formMonotonicProperties.minimumSize = Dimension(container.preferredSize.width, 200)
        formMonotonicProperties.maximumSize = Dimension(container.preferredSize.width, 200)

        val subSessionMonotonicProperties= SessionPanel("MONOTONIC PROPERTIES", formMonotonicProperties)
        container.add(subSessionMonotonicProperties)

        container.add(formMonotonicProperties)
        container.add(Box.createVerticalStrut(10))

        val labeledTextFieldYoungModulus = LabeledTextFieldRow(formMonotonicProperties, false,"Young's modulus, E (Nmm-2)", 0, 0)
        val labeledTextFieldPoissonRatio  = LabeledTextFieldRow(formMonotonicProperties, false, "Poisson's ratio, ν", 0, 1)
        val labeledTextFieldYieldStrength  = LabeledTextFieldRow(formMonotonicProperties, false,"Yield strength (conventional), Re or Rp0,2 (Nmm-2)", 0, 2)
        val labeledTextFieldTensileStrength = LabeledTextFieldRow(formMonotonicProperties, false,"Ultimate tensile strength, Rm (Nmm-2)", 0, 3)
        val labeledTextFieldElongationRelated  = LabeledTextFieldRow(formMonotonicProperties, false,"Elongation related to 5x diameter of specimen, A 5 (%) ", 0, 4)
        val labeledTextFieldREductionAreaFracture  = LabeledTextFieldRow(formMonotonicProperties, false,"Reduction of area at fracture, Z (RA) (%) ", 0, 5)
        val labeledTextFieldFractureStress  = LabeledTextFieldRow(formMonotonicProperties, false,"True fracture stress, σ f (Nmm-2)", 0, 6)
        val labeledTextFieldFractureStrain  = LabeledTextFieldRow(formMonotonicProperties, false,"True fracture strain, ε f", 0, 7)

        val formMonotonicStress = JPanel(GridBagLayout())
        formMonotonicStress.minimumSize = Dimension(container.preferredSize.width, 50)
        formMonotonicStress.maximumSize = Dimension(container.preferredSize.width, 50)

        val subSessionMonotonicParameters = SessionPanel("MONOTONIC STRESS-STRAIN PARAMETERS AND CURVES - RAMBERG-OSGOOD MODEL", formMonotonicStress)
        container.add(subSessionMonotonicParameters)

        container.add(formMonotonicStress)
        container.add(Box.createVerticalStrut(10))

        val labeledTextFieldStrengthCoefficient  = LabeledTextFieldRow(formMonotonicStress, false,"Strength coefficient, K (Nmm-2)", 0, 0)
        val labeledTextFieldStrainHardening = LabeledTextFieldRow(formMonotonicStress, false, "Strain hardening exponent, n", 0, 1)

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


