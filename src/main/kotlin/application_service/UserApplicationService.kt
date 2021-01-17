package application_service

import repository.IUserRepository
import repository.User
import repository.UserId
import repository.UserName
import repository.UserService

class UserApplicationService(private val userRepository: IUserRepository, private val userService: UserService) {
    fun register(name: String) {
        val user = User(UserName(name))
        if (userService.exists(user)) {
            throw Exception("${name}は既に存在しています")
        }
        userRepository.save(user)
    }

    fun get(userId: String): UserData? {
        val targetId = UserId(userId)
        val user = userRepository.find(targetId) ?: return null
        return UserData(user)
    }
}
