import Classes.InvalidInput
import Classes.LabeledTextFieldForms
import Classes.CustomButton
import java.awt.*
import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.*
import javax.swing.JFrame
import javax.swing.JPanel
class SignUp : JFrame("SignUp") {
    val signUpCustomButton = CustomButton("Sign Up")
    val signInCustomButton = CustomButton("Have an Account? Sign In")
    var signUpSuccessful = false
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        minimumSize = Dimension(500, 700)

        val formContainer = JPanel(GridBagLayout())
        formContainer.minimumSize = Dimension(400, 400)
        formContainer.background = Color(255, 255, 255)

        val username = LabeledTextFieldForms(formContainer, "Username", 0 ,0)
        val password = LabeledTextFieldForms(formContainer, "Password", 0 ,2)
        val confirmPassword = LabeledTextFieldForms(formContainer, "Confirm Password", 0 ,4)

        signUpCustomButton.addActionListener {
            val usernameField = username.textField
            val passwordField = password.textField
            if (usernameField.text.isEmpty() || passwordField.text.isEmpty()) {
                if (usernameField.text.isEmpty()) {
                    usernameField.border = InvalidInput(1)
                    JOptionPane.showMessageDialog(this, "you need to enter an email")
                }

                if (passwordField.text.isEmpty()) {
                    passwordField.border = InvalidInput(1)
                    JOptionPane.showMessageDialog(this, "you need to enter a password")
                }
            } else {
                signUpSuccessful = true
                dispose()
            }
        }

        val constraints = GridBagConstraints()

        constraints.gridx = 0
        constraints.gridy = 6
        constraints.insets = Insets(10, 10, 10, 10)
        constraints.anchor = GridBagConstraints.CENTER
        constraints.fill = GridBagConstraints.NONE
        formContainer.add(signUpCustomButton, constraints)

        constraints.gridx = 0
        constraints.gridy = 7
        constraints.insets = Insets(10, 10, 10, 10)
        constraints.anchor = GridBagConstraints.CENTER
        constraints.fill = GridBagConstraints.NONE
        formContainer.add(signInCustomButton, constraints)

        val logoPanel = LogoImage()

        val centralPanel = JPanel(GridBagLayout())
        val container = GridBagConstraints()
        centralPanel.background = Color.WHITE

        container.gridx = 0
        container.gridy = 0
        container.weighty = 1.0
        container.anchor = GridBagConstraints.NORTH
        container.insets = Insets(40,10,10,10)
        centralPanel.add(logoPanel, container)

        container.gridx = 0
        container.gridy = 1
        container.weighty = 4.0
        container.anchor = GridBagConstraints.NORTH
        centralPanel.add(formContainer, container)

        val gbc = GridBagConstraints()
        gbc.gridx = 0
        gbc.gridy = 0
        gbc.weightx = 1.0
        gbc.weighty = 1.0
        gbc.fill = GridBagConstraints.BOTH

        contentPane.layout = GridBagLayout()
        contentPane.add(centralPanel, gbc)
        contentPane.minimumSize = Dimension(400, 700)

        addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent) {
                val width = centralPanel.size.width
                val height = centralPanel.size.height

                val resizeWindow: Boolean = (width > 650 || height > 550)
                isResizable = resizeWindow
            }
        })

        pack()
        setLocationRelativeTo(null)
        signUpCustomButton.isEnabled = true
        isVisible = true
    }
}
