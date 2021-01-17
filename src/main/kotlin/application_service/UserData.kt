package application_service

import repository.User

data class UserData(private val user: User) {
    val id: String = user.id.value
    val name: String = user.name.value
    val mailAddress: String = user.mailAddress.value
}
