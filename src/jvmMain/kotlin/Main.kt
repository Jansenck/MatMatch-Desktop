
import java.awt.Color
import javax.swing.JFrame
import javax.swing.JOptionPane

fun main(args: Array<String>) {
    val frame = JFrame("Initial Screen")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    val login = Login()

    login.loginButton.addActionListener {
        val home = Home()
        if (login.loginSuccessful) {
            frame.contentPane.remove(login)
            frame.contentPane.add(home)
            frame.pack()
            frame.setLocationRelativeTo(null)

            home.depositBtn.addActionListener {
                home.depositBtn.background = Color.RED

                println("Botão DEPOSIT clicado") // Adiciona uma mensagem de log
                JOptionPane.showMessageDialog(home.depositBtn, "you need to enter an email")
                val deposit = Deposit()
                frame.contentPane.add(deposit)
                frame.contentPane.remove(home)
                frame.pack()
                frame.setLocationRelativeTo(null)
            }
        }
    }

    frame.contentPane.add(login)
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}
