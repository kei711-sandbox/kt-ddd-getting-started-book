package value_object

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class UserNameTest {

    @Test
    fun test() {
        assertEquals("abc", UserName("abc").value)
        val e = assertFailsWith<IllegalArgumentException> { UserName("ab") }
        assertEquals("ユーザ名は${UserName.MIN_LENGTH}文字以上です。", e.message)
    }
}
