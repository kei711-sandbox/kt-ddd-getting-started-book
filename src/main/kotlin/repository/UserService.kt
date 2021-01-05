package repository

class UserService(val userRepository: IUserRepository) {
    fun exists(user: User): Boolean {
        val found = userRepository.find(user.name)
        return found != null
    }
}
