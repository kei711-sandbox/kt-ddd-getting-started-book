package entity

class User(name: String) {
    companion object {
        const val MIN_LENGTH = 3
    }

    lateinit var name: String
        private set

    init {
        changeName(name)
    }

    fun changeName(name: String) {
        require(name.length >= MIN_LENGTH) {
            "ユーザ名は${MIN_LENGTH}文字以上です。"
        }
        this.name = name
    }

}