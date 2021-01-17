package repository

class InMemoryUserRepository(defaultValues: MutableMap<UserId, User> = mutableMapOf()) : IUserRepository {
    var storage: MutableMap<UserId, User> = defaultValues

    override fun save(user: User) {
        storage[user.id] = user.copy()
    }

    override fun find(name: UserName): User? = storage.values.firstOrNull { it.name == name }

    override fun delete(user: User) {
        storage.remove(user.id)
    }
}
