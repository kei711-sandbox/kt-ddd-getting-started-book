package value_object

data class UserId(val value: String) {
    override fun toString(): String = this.value
}
