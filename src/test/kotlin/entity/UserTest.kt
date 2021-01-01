package entity

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class UserTest {
    @Test
    fun changeName() {
        val user = User("abc")
        assertEquals("abc", user.name)

        user.changeName("changed")
        assertEquals("changed", user.name)

        val e = assertFailsWith<IllegalArgumentException> { User("ab") }
        assertEquals("ユーザ名は${User.MIN_LENGTH}文字以上です。", e.message)
    }
}