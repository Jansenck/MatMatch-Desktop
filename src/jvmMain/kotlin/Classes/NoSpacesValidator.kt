package Classes
class NoSpacesValidator {
    companion object {
        private val regex = Regex("\\S+")
        fun validate(value: String): Boolean {
            return regex.matches(value)
        }
    }
}
