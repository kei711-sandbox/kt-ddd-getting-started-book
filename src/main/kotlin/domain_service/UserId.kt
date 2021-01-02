package domain_service

data class UserId(val value: String) {
    override fun toString(): String = this.value
}
