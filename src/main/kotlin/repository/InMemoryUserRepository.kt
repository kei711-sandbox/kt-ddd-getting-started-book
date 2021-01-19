package repository

class InMemoryUserRepository(defaultValues: MutableMap<UserId, User> = mutableMapOf()) : IUserRepository {
    var storage: MutableMap<UserId, User> = defaultValues

    override fun save(user: User) {
        storage[user.id] = User(user.id, user.name, user.mailAddress)
    }

    override fun find(id: UserId): User? = storage.getOrDefault(id, null)?.let { User(it.id, it.name, it.mailAddress) }

    override fun find(name: UserName): User? = storage.values.firstOrNull { it.name == name }?.let { User(it.id, it.name, it.mailAddress) }

    override fun delete(user: User) {
        storage.remove(user.id)
    }
}
