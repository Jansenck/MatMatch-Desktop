import java.awt.*
import javax.swing.*
import java.io.File
import javax.imageio.ImageIO

import java.awt.Color
import java.awt.Dimension
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.border.*

class CustomBorder(private val height: Int) : AbstractBorder() {

    override fun paintBorder(c: Component, g: Graphics, x: Int, y: Int, width: Int, height: Int) {
        val g2 = g as Graphics2D
        g2.color = Color(82, 97, 147)
        g2.drawRoundRect(x, y, width - 1, height - 1, 10, 3)
    }

    override fun getBorderInsets(c: Component): Insets {
        return Insets(height, 10, height, 10)
    }
}

class InvalidInput(private val border: Int) : AbstractBorder() {
    override fun paintBorder(c: Component, g: Graphics, x: Int, y: Int, width: Int, height: Int) {
        val g2 = g as Graphics2D
        g2.color = Color.RED
        g2.stroke = BasicStroke(border.toFloat())
        g2.drawRoundRect(x, y, width - 1, height - 1, 10, 10)
    }

    override fun getBorderInsets(c: Component): Insets {
        return Insets(border, border, border, border)
    }
}

class Login : JFrame("Login") {

    val loginButton = JButton("Login")
    var loginSuccessful = false

    init {

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        minimumSize = Dimension(500, 600)

        val usernameLabel = JLabel("Username:")
        val usernameField = JTextField(20)
        usernameField.border = CustomBorder(10)
        usernameField.preferredSize = Dimension(0, 40)

        val passwordLabel = JLabel("Password:")
        val passwordField = JPasswordField(20)
        passwordField.border = CustomBorder(10)
        passwordField.preferredSize = Dimension(0, 40)

        loginButton.border = CustomBorder(10)
        loginButton.background = Color(82, 97, 147)
        loginButton.foreground = Color.WHITE
        loginButton.preferredSize = Dimension(300,40)

        loginButton.addActionListener {
            val username = usernameField.text
            val password = String(passwordField.password)

            // TODO: Verificar as credenciais do usuário

            if (username.isEmpty() || password.isEmpty()) {
                if (username.isEmpty()) {
                    usernameField.border = InvalidInput(1)
                    JOptionPane.showMessageDialog(this, "you need to enter an email")
                }

                if (password.isEmpty()) {
                    passwordField.border = InvalidInput(1)
                    JOptionPane.showMessageDialog(this, "you need to enter an password")
                }
            } else {
                loginSuccessful = true
                dispose()
            }
        }

        val formContainer = JPanel(GridBagLayout())
        formContainer.minimumSize = Dimension(400, 400)
        formContainer.background = Color(255, 255, 255)
        val c = GridBagConstraints()

        c.gridx = 0
        c.gridy = 0
        c.insets = Insets(10, 10, 10, 10)
        c.anchor = GridBagConstraints.LINE_START
        c.fill = GridBagConstraints.HORIZONTAL
        formContainer.add(usernameLabel, c)

        c.gridx = 0
        c.gridy = 1
        formContainer.add(usernameField, c)

        c.gridx = 0
        c.gridy = 2
        formContainer.add(passwordLabel, c)

        c.gridx = 0
        c.gridy = 3
        formContainer.add(passwordField, c)

        c.gridx = 0
        c.gridy = 4
        c.anchor = GridBagConstraints.CENTER
        c.fill = GridBagConstraints.NONE
        formContainer.add(loginButton, c)

        val imageFile = File("/home/driven/Downloads/mat-dark.png")

        val originalImage: Image = ImageIO.read(imageFile)

        val maxWidth = (formContainer.preferredSize.width* 0.7).toInt()
        val maxHeight = (formContainer.preferredSize.height * 0.7).toInt()
        val maxSize = Dimension(maxWidth, maxHeight)

        val scaledImage = originalImage.getScaledInstance(maxWidth, maxHeight, Image.SCALE_SMOOTH)

        val imageLabel = JLabel(ImageIcon(scaledImage))
        imageLabel.preferredSize = maxSize

        val imagePanel = JPanel(BorderLayout())
        imagePanel.add(imageLabel, BorderLayout.CENTER)
        imagePanel.background = Color(255, 255, 255)

        val centralPanel = JPanel(GridBagLayout())
        val container = GridBagConstraints()
        centralPanel.background = Color.WHITE

        container.gridx = 0
        container.gridy = 0
        container.weighty = 1.0
        container.anchor = GridBagConstraints.NORTH
        centralPanel.add(imagePanel, container)

        container.gridx = 0
        container.gridy = 1
        container.weighty = 3.0
        container.anchor = GridBagConstraints.NORTH
        centralPanel.add(formContainer, container)


        val gbc = GridBagConstraints()
        gbc.gridx = 0
        gbc.gridy = 0
        gbc.weightx = 1.0
        gbc.weighty = 1.0
        gbc.fill = GridBagConstraints.BOTH

        contentPane.layout = GridBagLayout()
        contentPane.add(centralPanel, gbc)
        contentPane.minimumSize = Dimension(400, 300)

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
