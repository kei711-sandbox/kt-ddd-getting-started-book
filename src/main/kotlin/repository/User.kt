package repository

import java.util.UUID

data class User(val name: UserName) {
    var id: UserId
        private set

    init {
        this.id = UserId(UUID.randomUUID().toString())
    }

    constructor(id: UserId, name: UserName) : this(name) {
        this.id = id
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
