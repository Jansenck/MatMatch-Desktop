import java.awt.*
import javax.swing.Box
import javax.swing.BoxLayout
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel

class Deposit : JFrame() {
    init {
        title = "Materials"
        defaultCloseOperation = EXIT_ON_CLOSE

        val label = JLabel("MATERIAL INFORMATION")
        val panel1 = JPanel(FlowLayout(FlowLayout.LEFT))
        panel1.preferredSize = Dimension(Int.MAX_VALUE, 30)
        panel1.maximumSize = Dimension(Int.MAX_VALUE, 20)
        panel1.add(label)
        panel1.background = Color.BLUE

        val testedLbl = JLabel("TESTED MATERIAL")
        val testedMaterial = JPanel(FlowLayout(FlowLayout.LEFT))
        testedMaterial.preferredSize = Dimension(Int.MAX_VALUE, 30)
        testedMaterial.maximumSize = Dimension(Int.MAX_VALUE, 20)
        testedMaterial.add(testedLbl)

        val testConditionsLbl = JLabel("TESTING CONDITIONS AND SPECIMEN INFORMATION")
        val testConditions = JPanel(FlowLayout(FlowLayout.LEFT))
        testConditions.preferredSize = Dimension((Int.MAX_VALUE), 30)
        testConditions.maximumSize = Dimension(Int.MAX_VALUE, 20)
        testConditions.add(testConditionsLbl)

        val properties = JLabel("MONOTONIC PROPERTIES")
        val monoProperties= JPanel(FlowLayout(FlowLayout.LEFT))
        monoProperties.preferredSize = Dimension(Int.MAX_VALUE, 30)
        monoProperties.maximumSize = Dimension(Int.MAX_VALUE, 20)
        monoProperties.add(properties)

        val stress = JLabel("MONOTONIC STRESS-STRAIN PARAMETERS AND CURVES - RAMBERG-OSGOOD MODEL")
        val stressParameter = JPanel(FlowLayout(FlowLayout.LEFT))
        stressParameter.preferredSize = Dimension(Int.MAX_VALUE, 30)
        stressParameter.maximumSize = Dimension(Int.MAX_VALUE, 20)
        stressParameter.add(stress)

        val containerForm = JPanel(FlowLayout(FlowLayout.LEFT))
        val screenSize = Toolkit.getDefaultToolkit().screenSize
        val width = screenSize.width
        val height = screenSize.height


        containerForm.preferredSize = Dimension((width * 0.8).toInt(), (height* 0.6).toInt())
        containerForm.layout = BoxLayout(containerForm, BoxLayout.Y_AXIS) // orientação vertical
        containerForm.add(panel1)
        containerForm.add(Box.createVerticalStrut(10)) // espaçamento vertical
        containerForm.add(testedMaterial)
        containerForm.add(Box.createVerticalStrut(10))
        containerForm.add(testConditions)
        containerForm.add(Box.createVerticalStrut(10))
        containerForm.add(monoProperties)
        containerForm.add(Box.createVerticalStrut(10))
        containerForm.add(stressParameter)

        contentPane.add(containerForm, BorderLayout.CENTER)

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
