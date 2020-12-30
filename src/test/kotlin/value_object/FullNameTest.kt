package value_object

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FullNameTest {
    @Test
    fun test_2_1() {
        val firstName = "john"
        val lastName = "smith"
        val fullName = FullName(firstName = firstName, lastName = lastName)
        assertEquals(firstName, fullName.firstName)
        assertEquals(lastName, fullName.lastName)
    }

    @Test
    fun test_2_2_3() {
        val firstName = "john"
        val lastName = "smith"
        val fullNameA = FullName(firstName = firstName, lastName = lastName)
        val fullNameB = FullName(firstName = firstName, lastName = lastName)
        assertEquals(fullNameA, fullNameB)
    }
}