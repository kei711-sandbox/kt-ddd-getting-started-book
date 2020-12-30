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
}