package application_service

import org.junit.jupiter.api.Test
import repository.InMemoryUserRepository
import repository.UserService
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class UserApplicationServiceTest {
    @Test
    internal fun testUpdateNameCommand() {
        val repo = InMemoryUserRepository()
        val service = UserApplicationService(repo, UserService(repo))
        val user = service.register("test")

        val updateNameCommand = UserUpdateCommand(user.id.value, "test1")
        service.update(updateNameCommand)
        val updatedUser = repo.find(user.id)
        assertNotNull(updatedUser)
        assertEquals("test1", updatedUser.name.value)

        repo.delete(user)
    }

    @Test
    internal fun testUpdateMailAddressCommand() {
        val repo = InMemoryUserRepository()
        val service = UserApplicationService(repo, UserService(repo))
        val user = service.register("test")

        val updateMailAddressCommand = UserUpdateCommand(user.id.value, mailAddress = "test@example.com")
        service.update(updateMailAddressCommand)
        val updatedUser = repo.find(user.id)
        assertNotNull(updatedUser)
        assertEquals("test@example.com", updatedUser.mailAddress.value)

        repo.delete(user)
    }
}
