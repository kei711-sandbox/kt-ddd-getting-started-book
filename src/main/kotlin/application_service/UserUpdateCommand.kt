package application_service

data class UserUpdateCommand(val id: String, val name: String? = null, val mailAddress: String? = null)
