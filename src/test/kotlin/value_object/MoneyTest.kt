package value_object

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertFailsWith

internal class MoneyTest {
    @Test
    fun testAdd() {
        val money = Money(BigDecimal(100), "JPY")
        val expected = Money(BigDecimal(150), "JPY")
        assertEquals(expected, money.add(Money(BigDecimal(50), "JPY")))
        assertEquals(expected, money + Money(BigDecimal(50), "JPY"))

        val exception = assertFailsWith<IllegalArgumentException> { money.add(Money(BigDecimal(50), "USD")) }
        assertEquals("通貨単位が異なります (this: JPY, arg: USD)", exception.message)
    }
}