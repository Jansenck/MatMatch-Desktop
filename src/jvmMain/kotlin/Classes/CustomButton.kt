package Classes

import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.Insets
import javax.swing.JButton
import javax.swing.JPanel
class CustomButton(text: String) : JButton(text){
    init {
        border = CustomBorder(10)
        background = Color(82, 97, 147)
        foreground = Color.WHITE
        preferredSize = Dimension(300, 40)
    }
}