package repository

import org.junit.jupiter.api.Test
import kotlin.test.Ignore

internal class RepositoryTest {
    @Test
    @Ignore
    fun createUser() {
        val program = Program(UserRepository())
        program.createUser("test")
    }
}
