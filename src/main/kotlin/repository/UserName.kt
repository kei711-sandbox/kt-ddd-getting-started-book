package repository

data class UserName(val value: String) {
    companion object {
        const val MIN_LENGTH = 3
    }

    init {
        require(value.length >= MIN_LENGTH) {
            "ユーザ名は${MIN_LENGTH}文字以上です。"
        }
    }

    override fun toString(): String = this.value
}
