package Classes

import Classes.InvalidInput
import javax.swing.JOptionPane
import javax.swing.JTextField

class SignupValidator(private val usernameField: JTextField, private val passwordField: JTextField, private val confirmPasswordField: JTextField) {

    private val invalidInput = InvalidInput(1)

    fun validateSignup(): Boolean {
        if (usernameField.text.isEmpty() || passwordField.text.isEmpty() || confirmPasswordField.text.isEmpty() || !checkPasswordsMatch()) {

            if (usernameField.text.isEmpty()) {
                usernameField.border = invalidInput
                JOptionPane.showMessageDialog(null, "You need to create an username")
            }

            if (passwordField.text.isEmpty()) {
                passwordField.border = invalidInput
                JOptionPane.showMessageDialog(null, "You need to create a password")
            }

            if (confirmPasswordField.text.isEmpty()) {
                confirmPasswordField.border = invalidInput
                JOptionPane.showMessageDialog(null, "You need to confirm password")
            }

            if (!checkPasswordsMatch()) {
                JOptionPane.showMessageDialog(null, "Passwords do not match")
            }

            return false
        } else {
            return true
        }
    }

    private fun checkPasswordsMatch(): Boolean {
        return passwordField.text.trim() == confirmPasswordField.text.trim()
    }
}
