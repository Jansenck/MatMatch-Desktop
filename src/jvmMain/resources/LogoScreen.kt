import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.io.StringWriter
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import org.jfree.graphics2d.svg.SVGGraphics2D
import org.jfree.graphics2d.svg.SVGUtils

class SvgScreen : JFrame("SVG") {

        init {
                val svgText = """
            <?xml version="1.0" encoding="UTF-8"?>
            <svg xmlns="http://www.w3.org/2000/svg" version="1.1" width="100" height="100">
                <rect x="10" y="10" width="80" height="80" fill="#FF0000" stroke="#000000" stroke-width="1"/>
            </svg>
        """.trimIndent()

                val svgG2D = SVGGraphics2D(100, 100)
                svgG2D.paint = Color.WHITE
                svgG2D.fillRect(0, 0, 100, 100)
                //SVGUtils.convertToGraphics2D(svgText, svgG2D)

                val svgPanel = JPanel(GridBagLayout())
                svgPanel.background = Color.WHITE
                val c = GridBagConstraints()
                c.gridx = 0
                c.gridy = 0
                svgPanel.add(JLabel(svgG2D.getSVGElement()), c)

                // Cria um JPanel com GridLayout 1x1 e adiciona o rótulo da imagem
                val centralPanel = JPanel(GridBagLayout())
                centralPanel.add(svgPanel)

                // Adiciona o JPanel central ao contentPane da janela
                contentPane.add(centralPanel)

                pack()
                setLocationRelativeTo(null)
                isVisible = true
        }
}
