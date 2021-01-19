package application_service

import repository.IUserRepository
import repository.MailAddress
import repository.User
import repository.UserId
import repository.UserName
import repository.UserService

class UserApplicationService(private val userRepository: IUserRepository, private val userService: UserService) {
    fun register(name: String): User {
        val user = User(UserName(name))
        if (userService.exists(user)) {
            throw Exception("${name}は既に存在しています")
        }
        userRepository.save(user)
        return user
    }

    fun get(userId: String): UserData? {
        val targetId = UserId(userId)
        val user = userRepository.find(targetId) ?: return null
        return UserData(user)
    }

    fun update(command: UserUpdateCommand) {
        val targetId = UserId(command.id)
        val user = userRepository.find(targetId) ?: throw UserNotFoundException(targetId)

        val name = command.name
        if (name != null) {
            user.changeName(UserName(name))
            if (userService.exists(user)) {
                throw CanNotRegisterUserException(user, "ユーザーは既に存在しています。")
            }
        }

        val mailAddress = command.mailAddress
        if (mailAddress != null) {
            user.changeMailAddress(MailAddress(mailAddress))
        }

        userRepository.save(user)
    }

    fun delete(command: UserDeleteCommand) {
        val targetId = UserId(command.id)
        val user = userRepository.find(targetId) ?: throw UserNotFoundException(targetId)

        userRepository.delete(user)
    }
}

class UserNotFoundException(targetId: UserId) : Throwable()

class CanNotRegisterUserException(user: User, s: String) : Throwable()
