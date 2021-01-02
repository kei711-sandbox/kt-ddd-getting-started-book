package value_object

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class FullNameTest {
    @Test
    fun test_2_1() {
        val firstName = Name("john")
        val lastName = Name("smith")
        val fullName = FullName(firstName = firstName, lastName = lastName)
        assertEquals(firstName, fullName.firstName)
        assertEquals(lastName, fullName.lastName)
    }

    @Test
    fun test_2_2_3() {
        val firstName = Name("john")
        val lastName = Name("smith")
        val fullNameA = FullName(firstName = firstName, lastName = lastName)
        val fullNameB = FullName(firstName = firstName, lastName = lastName)
        assertEquals(fullNameA, fullNameB)
    }

    @Test
    fun test_2_3() {
        val exception = assertFailsWith<IllegalArgumentException> { Name("あいうえお") }
        assertEquals("許可されていない文字が使われています。", exception.message)
    }
}
