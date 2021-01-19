package repository

import java.util.UUID

class User(name: UserName, mailAddress: MailAddress = MailAddress("")) {
    var id: UserId
        private set

    var name: UserName = name
        private set

    var mailAddress: MailAddress = mailAddress
        private set

    init {
        this.id = UserId(UUID.randomUUID().toString())
    }

    constructor(id: UserId, name: UserName, mailAddress: MailAddress) : this(name, mailAddress) {
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

    fun changeName(name: UserName) {
        this.name = name
    }

    fun changeMailAddress(mailAddress: MailAddress) {
        this.mailAddress = mailAddress
    }
}
