package entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

internal class UserTest {
    @Test
    fun changeName() {
        val user = User(UserId("id"), "abc")
        assertEquals("abc", user.name)

        user.changeName("changed")
        assertEquals("changed", user.name)

        val e = assertFailsWith<IllegalArgumentException> { User(UserId("id"), "ab") }
        assertEquals("ユーザ名は${User.MIN_LENGTH}文字以上です。", e.message)
    }

    @Test
    fun testEquals() {
        val userA = User(UserId("id1"), "abc")
        val userB = User(UserId("id1"), "abcd")
        assertEquals(userA, userB)

        val userC = User(UserId("id2"), "abc")
        assertNotEquals(userA, userC)
    }
}
