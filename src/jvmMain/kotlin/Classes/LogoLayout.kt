import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.Image
import java.io.File
import javax.imageio.ImageIO
import javax.swing.ImageIcon
import javax.swing.JPanel

class LogoImage() : JPanel(BorderLayout()) {
    private val maxWidth: Int = 150
    private val maxHeight: Int = 150
    private val imagePath: String = "assets/images/mat-dark.png"
    private val image: Image = ImageIO.read(File(imagePath)).getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH)
    private val imageIcon: ImageIcon = ImageIcon(image)
    private val imageLabel = object : JPanel() {
        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            g.drawImage(imageIcon.image, 0, 0, null)
        }
    }
    init {
        preferredSize = Dimension(maxWidth, maxHeight)
        background = Color.WHITE
        val centerPanel = JPanel(BorderLayout())
        add(centerPanel, BorderLayout.CENTER)
        centerPanel.add(imageLabel, BorderLayout.CENTER)
    }
}
