package repository

import org.junit.jupiter.api.Test
import kotlin.test.Ignore
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

internal class RepositoryTest {
    @Test
    @Ignore
    fun createUser() {
        val program = Program(UserRepository())
        program.createUser("test")
    }

    @Test
    fun createUserWithMock() {
        val repo = InMemoryUserRepository()
        val program = Program(repo)
        program.createUser("test")

        val user = repo.storage.values.first()
        assertNotNull("test", user.name.value)

        val service = UserService(repo)
        assertTrue(service.exists(user))
    }
}
