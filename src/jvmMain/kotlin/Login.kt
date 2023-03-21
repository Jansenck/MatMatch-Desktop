import Classes.InvalidInput
import Classes.CustomButton
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
    val loginButton = CustomButton("Login")
    val linkToSignUp = CustomButton("Create Account")
    val loginFrame = this
    var loginSuccessful = false
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        minimumSize = Dimension(500, 600)

        formContainer.minimumSize = Dimension(400, 400)
        formContainer.background = Color(255, 255, 255)

        val username = LabeledTextFieldForms(formContainer, "Username", 0 ,0)
        val password = LabeledTextFieldForms(formContainer, "Username", 0 ,2)

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
        val constraintsFormContainer = GridBagConstraints()
        centralPanel.background = Color.WHITE

        constraintsFormContainer.gridx = 0
        constraintsFormContainer.gridy = 0
        constraintsFormContainer.weighty = 1.0
        constraintsFormContainer.insets = Insets(40,10,10,10)
        constraintsFormContainer.anchor = GridBagConstraints.NORTH
        centralPanel.add(logoPanel, constraintsFormContainer)

        constraintsFormContainer.gridx = 0
        constraintsFormContainer.gridy = 1
        constraintsFormContainer.weighty = 3.0
        constraintsFormContainer.anchor = GridBagConstraints.NORTH
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

        loginButton.addActionListener {
            val usernameField = username.textField
            val passwordField = password.textField

            // TODO: Verificar as credenciais do usuário

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
                loginSuccessful = true
                dispose()
            }
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
        loginButton.isEnabled = true
        isVisible = true
    }
}
