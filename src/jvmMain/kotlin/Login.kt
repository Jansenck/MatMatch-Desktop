import Classes.CustomButton
import Classes.InputValidator
import Classes.LabeledTextFieldForms
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
class Login : JFrame("Login") {

    val formContainer = JPanel(GridBagLayout())
    val loginButton = CustomButton("Login").apply { isEnabled = false }
    val linkToSignUp = CustomButton("Create Account")
    val loginFrame = this
    var loginSuccessful = false
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        minimumSize = Dimension(500, 600)

        formContainer.minimumSize = Dimension(400, 400)
        formContainer.background = Color(255, 255, 255)

        val username = LabeledTextFieldForms(formContainer, "Username", 0 ,0)
        val password = LabeledTextFieldForms(formContainer, "Password", 0 ,2)

        val constraintsForm = GridBagConstraints()

        constraintsForm.gridx = 0
        constraintsForm.gridy = 4
        constraintsForm.insets = Insets(10, 10, 10, 10)
        constraintsForm.anchor = GridBagConstraints.LINE_START
        constraintsForm.fill = GridBagConstraints.HORIZONTAL
        formContainer.add(loginButton, constraintsForm)

        constraintsForm.gridx = 0
        constraintsForm.gridy = 5
        constraintsForm.insets = Insets(10, 10, 10, 10)
        constraintsForm.anchor = GridBagConstraints.CENTER
        constraintsForm.fill = GridBagConstraints.NONE
        formContainer.add(linkToSignUp, constraintsForm)

        val logoPanel = LogoImage()
        val centralPanel = JPanel(GridBagLayout())
        centralPanel.background = Color.WHITE

        val constraintsFormContainer = GridBagConstraints()
        constraintsFormContainer.gridx = 0
        constraintsFormContainer.gridy = 0
        constraintsFormContainer.weighty = 1.0
        constraintsFormContainer.anchor = GridBagConstraints.NORTH
        constraintsFormContainer.insets = Insets(40,10,10,10)
        constraintsFormContainer.fill = GridBagConstraints.NONE
        centralPanel.add(logoPanel, constraintsFormContainer)

        constraintsFormContainer.gridx = 0
        constraintsFormContainer.gridy = 1
        constraintsFormContainer.weighty = 3.0
        constraintsFormContainer.anchor = GridBagConstraints.NORTH
        constraintsFormContainer.insets = Insets(10, 10, 10, 10)
        constraintsFormContainer.fill = GridBagConstraints.NONE
        centralPanel.add(formContainer, constraintsFormContainer)

        val gbc = GridBagConstraints()
        gbc.gridx = 0
        gbc.gridy = 0
        gbc.weightx = 1.0
        gbc.weighty = 1.0
        gbc.fill = GridBagConstraints.BOTH

        contentPane.layout = GridBagLayout()
        contentPane.add(centralPanel, gbc)
        contentPane.minimumSize = Dimension(400, 300)

        val buttonDisabler = ButtonDisabler(loginButton, listOf(username.textField, password.textField))

        loginButton.addActionListener {
            val usernameField = username.textField
            val passwordField = password.textField
            val validLoginInputs = InputValidator(usernameField, passwordField, passwordField).validateLogin();

            if (validLoginInputs) {
                val homeScreen = Home()
                homeScreen.isVisible = true
                isVisible = false
            } else {
                JOptionPane.showMessageDialog(this, "Login error, please try again")
            }
        }

        linkToSignUp.addActionListener {
            val signUpScreen = SignUp()
            signUpScreen.isVisible = true
            isVisible = false
        }

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
        isVisible = true
    }
}
