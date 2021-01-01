package entity

class User(val id: UserId, name: String) {
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id == other.id) return true

        return false
    }

    override fun hashCode(): Int = id.hashCode()
}