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
    val signUpCustomButton = CustomButton("Sign Up").apply { isEnabled = false }
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
            val confirmPassword = confirmPassword.textField

            if (usernameField.text.isEmpty() || passwordField.text.isEmpty() || confirmPassword.text.isEmpty()) {
                if (usernameField.text.isEmpty()) {
                    usernameField.border = InvalidInput(1)
                    JOptionPane.showMessageDialog(this, "you need to enter an username")
                }

                if (passwordField.text.isEmpty()) {
                    passwordField.border = InvalidInput(1)
                    JOptionPane.showMessageDialog(this, "you need to enter a password")
                }

                if (passwordField.text.isEmpty()){
                    passwordField.border = InvalidInput(1)
                    JOptionPane.showMessageDialog(this, "you need to confirm password")
                }
            } else {
                signUpSuccessful = true
                dispose()
            }
        }

        val constraintsButton = GridBagConstraints()

        constraintsButton.gridx = 0
        constraintsButton.gridy = 6
        constraintsButton.insets = Insets(10, 10, 10, 10)
        constraintsButton.anchor = GridBagConstraints.CENTER
        constraintsButton.fill = GridBagConstraints.NONE
        formContainer.add(signUpCustomButton, constraintsButton)

        constraintsButton.gridx = 0
        constraintsButton.gridy = 7
        constraintsButton.insets = Insets(10, 10, 10, 10)
        constraintsButton.anchor = GridBagConstraints.CENTER
        constraintsButton.fill = GridBagConstraints.NONE
        formContainer.add(signInCustomButton, constraintsButton)

        val logoPanel = LogoImage()

        val centralPanel = JPanel(GridBagLayout())
        val formSignUpConstraints = GridBagConstraints()
        centralPanel.background = Color.WHITE

        formSignUpConstraints.gridx = 0
        formSignUpConstraints.gridy = 0
        formSignUpConstraints.weighty = 1.0
        formSignUpConstraints.anchor = GridBagConstraints.NORTH
        formSignUpConstraints.insets = Insets(40,10,10,10)
        constraintsButton.fill = GridBagConstraints.NONE
        centralPanel.add(logoPanel, formSignUpConstraints)

        formSignUpConstraints.gridx = 0
        formSignUpConstraints.gridy = 1
        formSignUpConstraints.weighty = 4.0
        formSignUpConstraints.anchor = GridBagConstraints.NORTH
        formSignUpConstraints.insets = Insets(10, 10, 10, 10)
        formSignUpConstraints.fill = GridBagConstraints.NONE
        centralPanel.add(formContainer, formSignUpConstraints)

        val centralConstraints = GridBagConstraints()
        centralConstraints.gridx = 0
        centralConstraints.gridy = 0
        centralConstraints.weightx = 1.0
        centralConstraints.weighty = 2.0
        centralConstraints.fill = GridBagConstraints.BOTH

        contentPane.layout = GridBagLayout()
        contentPane.add(centralPanel, centralConstraints)
        contentPane.minimumSize = Dimension(400, 700)

        val buttonDisabler = ButtonDisabler(signUpCustomButton, listOf(username.textField, password.textField, confirmPassword.textField))

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
