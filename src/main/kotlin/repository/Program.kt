package repository

class Program(val userRepository: IUserRepository) {
    fun createUser(userName: String) {
        val user = User(UserName(userName))
        val userService = UserService(userRepository)
        if (userService.exists(user)) {
            throw Exception("${userName}は既に存在しています")
        }

        userRepository.save(user)
    }
}
