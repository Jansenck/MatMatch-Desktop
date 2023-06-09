import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import javax.swing.*
class CustomButton(text: String) : JButton(text) {
    init {
        isFocusPainted = false
        background = Color(0,0,0,0)
        isBorderPainted = false
        foreground = Color.WHITE
    }
}
class Home : JFrame("Home") {
    private val topBar = JPanel()
    private val customersBtn = CustomButton("CUSTOMERS")
    private val academicBtn = CustomButton("ACADEMIC")
    private val aboutBtn = CustomButton("ABOUT")
    private val supportBtn = CustomButton("SUPPORT")
    private val connectBtn = CustomButton("CONNECT")
    val newDepositButton = CustomButton("NEW DEPOSIT")
    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(800, 600)
        setLocationRelativeTo(null)
        layout = BorderLayout()

        topBar.layout = BoxLayout(topBar, BoxLayout.X_AXIS)
        topBar.preferredSize = Dimension(0,60)
        topBar.background = Color(82, 97, 147)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(customersBtn)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(academicBtn)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(aboutBtn)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(supportBtn)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(connectBtn)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(newDepositButton)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(Box.createRigidArea(Dimension(20, 0)))

        add(topBar, BorderLayout.NORTH)

        newDepositButton.addActionListener{
            val depositScreen = Deposit()
            depositScreen.isVisible = true
            isVisible = false
        }

        isVisible = true
    }
}
