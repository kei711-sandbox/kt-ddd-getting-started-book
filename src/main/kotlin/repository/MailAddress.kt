package repository

data class MailAddress(val value: String) {
    override fun toString(): String = this.value
}
