import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.text.JTextComponent
class PasswordsMatch(private val field1: JTextComponent, private val field2: JTextComponent) : DocumentListener {

    private var match = false
    init {
        checkFields()
    }
    override fun insertUpdate(e: DocumentEvent?) {
        checkFields()
    }
    override fun removeUpdate(e: DocumentEvent?) {
        checkFields()
    }
    override fun changedUpdate(e: DocumentEvent?) {
        checkFields()
    }
    private fun checkFields() {
        match = passwordsMatch()
    }
    fun passwordsMatch(): Boolean {
        val password = field1.text.trim()
        val confirmPassword = field2.text.trim()

        return if (password.isNotEmpty() && confirmPassword.isNotEmpty()) {
            password == confirmPassword
        } else {
            false
        }
    }
    fun isMatch(): Boolean {
        return match
    }


}
