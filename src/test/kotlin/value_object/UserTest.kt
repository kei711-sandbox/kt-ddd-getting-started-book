package value_object

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UserTest {
    @Test
    fun test() {
        val userA = User(UserId("id"), UserName("name"))
        val userB = User(UserId("id"), UserName("name"))
        assertEquals("id", userA.id.toString())
        assertEquals("name", userA.name.toString())
        assertEquals(userA, userB)
    }
}