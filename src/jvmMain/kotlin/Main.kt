import javax.swing.JFrame
fun main(args: Array<String>) {
    val frame = JFrame()
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    val login = Login()

    frame.contentPane.add(login)
    frame.pack()
    frame.setLocationRelativeTo(null)
    frame.isVisible = true
}
