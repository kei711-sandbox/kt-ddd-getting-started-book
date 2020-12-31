package value_object

import java.math.BigDecimal

data class Money(val amount: BigDecimal, val currency: String) {
    fun add(arg: Money): Money {
        require(currency == arg.currency) {
            "通貨単位が異なります (this: $currency, arg: ${arg.currency})"
        }
        return Money(amount + arg.amount, currency)
    }

    operator fun plus(increment: Money): Money {
        return add(increment)
    }
}