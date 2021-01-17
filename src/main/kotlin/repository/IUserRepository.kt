package repository

interface IUserRepository {
    fun save(user: User)
    fun find(name: UserName): User?
    fun delete(user: User)
}
