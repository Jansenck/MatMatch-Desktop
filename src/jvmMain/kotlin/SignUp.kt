
import Classes.CustomButton
import Classes.InputValidator
import Classes.LabeledTextFieldForms
import Services.PostUser
import java.awt.*
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.JPanel
class SignUp : JFrame("SignUp") {
    val signUpCustomButton = CustomButton("Sign Up").apply { isEnabled = false }
    val signInCustomButton = CustomButton("Have an Account? Sign In")
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        minimumSize = Dimension(500, 700)

        val formContainer = JPanel(GridBagLayout())
        formContainer.minimumSize = Dimension(400, 400)
        formContainer.background = Color(255, 255, 255)

        val username = LabeledTextFieldForms(formContainer, "Username", 0 ,0)
        val password = LabeledTextFieldForms(formContainer, "Password", 0 ,2)
        val confirmPassword = LabeledTextFieldForms(formContainer, "Confirm Password", 0 ,4)

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
        val signUpValidator = InputValidator(username.textField,password.textField, confirmPassword.textField);
        val checkPasswordsMatch = PasswordsMatch(password.textField, confirmPassword.textField).isMatch();

        signUpCustomButton.addActionListener {

            if(signUpValidator.validateSignUp()){
                try {
                    PostUser().execute(username.textField.text.toString(), password.textField.text.toString())
                    JOptionPane.showMessageDialog(this, "Congratulations! Your account has been created successfully.")
                    val loginScreen = Login()
                    loginScreen.isVisible = true
                    isVisible = false
                } catch (e: IllegalStateException) {
                    JOptionPane.showMessageDialog(this, "Login error, please try again.")
                }
            }
        }

        signInCustomButton.addActionListener {
            val loginScreen = Login()
            loginScreen.isVisible = true
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
