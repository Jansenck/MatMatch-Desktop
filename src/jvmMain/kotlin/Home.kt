import javax.swing.*
import java.awt.*

class Home : JFrame("Home") {
    private val topBar = JPanel()
    private val customersBtn = JButton("CUSTOMERS")
    private val academicBtn = JButton("ACADEMIC")
    private val aboutBtn = JButton("ABOUT")
    private val supportBtn = JButton("SUPPORT")
    private val connectBtn = JButton("CONNECT")
    val depositBtn = JButton("DEPOSIT")

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        size = Dimension(800, 600)
        setLocationRelativeTo(null)
        layout = BorderLayout()

        customersBtn.isFocusPainted = false
        academicBtn.isFocusPainted = false
        aboutBtn.isFocusPainted = false
        supportBtn.isFocusPainted = false
        connectBtn.isFocusPainted = false
        depositBtn.isFocusPainted = false

        customersBtn.background = Color(0,0,0,0)
        academicBtn.background = Color(0,0,0,0)
        aboutBtn.background = Color(0,0,0,0)
        supportBtn.background = Color(0,0,0,0)
        connectBtn.background = Color(0,0,0,0)
        depositBtn.background = Color(0,0,0,0)

        customersBtn.isBorderPainted = false
        academicBtn.isBorderPainted = false
        aboutBtn.isBorderPainted = false
        supportBtn.isBorderPainted = false
        connectBtn.isBorderPainted = false
        depositBtn.isBorderPainted = false

        customersBtn.foreground = Color.WHITE
        academicBtn.foreground = Color.WHITE
        aboutBtn.foreground = Color.WHITE
        supportBtn.foreground = Color.WHITE
        connectBtn.foreground = Color.WHITE
        depositBtn.foreground = Color.WHITE

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
        topBar.add(depositBtn)
        topBar.add(Box.createHorizontalGlue())
        topBar.add(Box.createRigidArea(Dimension(20, 0)))

        add(topBar, BorderLayout.NORTH)

        depositBtn.addActionListener{
            val deposit = Deposit()
            dispose()
            deposit.isVisible = true
        }

        isVisible = true
    }
}
