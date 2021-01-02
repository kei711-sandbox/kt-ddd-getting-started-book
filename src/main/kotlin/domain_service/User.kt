package domain_service

import java.util.UUID

class User(id: UserId, name: UserName) {
    lateinit var id: UserId
        private set

    lateinit var name: UserName
        private set

    constructor(name: UserName) {
        this.id = UserId(UUID.randomUUID().toString())
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
