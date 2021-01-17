package repository

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class RepositoryTest {
    @Test
    fun createUser() {
        testImpl(UserRepository(), "test1")
    }

    @Test
    fun createUserWithExposed() {
        testImpl(ExposedUserRepository(), "test2")
    }

    @Test
    fun createUserWithMock() {
        testImpl(InMemoryUserRepository(), "test3")
    }

    private fun testImpl(repo: IUserRepository, name: String) {
        val program = Program(repo)
        val user = program.createUser(name)
        assertEquals(name, user.name.value)

        val service = UserService(repo)
        assertTrue(service.exists(user))
    }
}
