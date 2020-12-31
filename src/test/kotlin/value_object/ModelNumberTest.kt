package value_object

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ModelNumberTest {

    @Test
    fun testToString() {
        assertEquals("a-b-c", ModelNumber("a", "b", "c").toString())
    }
}