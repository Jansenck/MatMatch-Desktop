package Classes

import javax.swing.JOptionPane
import javax.swing.JTextField

class InputValidator(
    private val usernameField: JTextField,
    private val passwordField: JTextField,
    private val confirmPasswordField: JTextField
) {
    private val invalidInputStyle = InvalidInputStyle(1)

    fun validateSignUp(): Boolean {
        val invalidUserName = usernameField.text.isEmpty() || !NoSpacesValidator.validate(usernameField.text)
        val invalidPassword = passwordField.text.isEmpty()
        val invalidPasswordConfirmation = confirmPasswordField.text.isEmpty()

        if (invalidUserName) {

            showErrorMessage(usernameField, "You need to create a valid username")
        } else if (invalidPassword) {
            showErrorMessage(passwordField, "You need to create a valid password")
        } else if (invalidPasswordConfirmation) {
            showErrorMessage(confirmPasswordField, "Invalid password confirmation")
        } else if (!checkPasswordsMatch()) {
            passwordField.border = invalidInputStyle
            showErrorMessage(confirmPasswordField, "Passwords do not match")
        } else {
            return true
        }
        return false
    }

    fun validateLogin(): Boolean {
        val invalidUserName = usernameField.text.isEmpty() || !NoSpacesValidator.validate(usernameField.text)
        val invalidPassword = passwordField.text.isEmpty()

        if (invalidUserName) {
            showErrorMessage(usernameField, "Invalid username")
        } else if (invalidPassword) {
            showErrorMessage(passwordField, "Please enter your password")
        } else {
            return true
        }
        return false
    }

    private fun checkPasswordsMatch(): Boolean {
        return passwordField.text.trim() == confirmPasswordField.text.trim()
    }

    private fun showErrorMessage(field: JTextField, message: String) {
        field.border = invalidInputStyle
        JOptionPane.showMessageDialog(null, message)
    }
}
