import java.awt.Color
import javax.swing.JButton
import javax.swing.event.DocumentEvent
import javax.swing.event.DocumentListener
import javax.swing.text.JTextComponent
class ButtonDisabler(private val button: JButton, private val components: List<JTextComponent>) : DocumentListener {

    init {
        button.isEnabled = false
        components.forEach { it.document.addDocumentListener(this) }
    }
    private fun checkFields() {
        val isEmpty = components.any { it.text.trim().isEmpty() }
        if(isEmpty){
            button.background = Color(127, 128, 175)
        } else {
            button.background = Color(82, 97, 147)
        }
        button.isEnabled = !isEmpty
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
}
