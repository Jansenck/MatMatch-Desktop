package Classes

import java.awt.Color
import java.awt.Dimension
import javax.swing.JButton
class CustomButton(text: String) : JButton(text){
    init {
        border = CustomBorder(10)
        foreground = Color.WHITE
        preferredSize = Dimension(300, 40)

        background = if(text === "Login" || text === "Sign Up"){
            Color(127, 128, 175)
        } else {
            Color(82, 97, 147)
        }
    }
}