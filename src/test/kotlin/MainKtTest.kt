import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculationsVKLimited() {
        val paymentSystem = "VK Pay"
        val amountPrevious = 41_000
        val amount = 16_000.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(0.0, result, 0.1)
    }

    @Test
    fun calculationsVKPay() {
        val paymentSystem = "VK Pay"
        val amountPrevious = 11_000
        val amount = 6_000.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(0.0, result, 0.1)
    }

    @Test
    fun calculationsMasterCardLimited() {
        val paymentSystem = "MasterCard"
        val amountPrevious = 600_001
        val amount = 150_001.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(-1.0, result, 0.1)
    }

    @Test
    fun calculationsMasterCardNull() {
        val paymentSystem = "MasterCard"
        val amountPrevious = 74_999
        val amount = 15_001.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(0.0, result, 0.1)
    }

    @Test
    fun calculationsMasterCard() {
        val paymentSystem = "MasterCard"
        val amountPrevious = 75_001
        val amount = 15_001.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(110.006, result, 0.1)
    }

    @Test
    fun calculationsMaestrodNull() {
        val paymentSystem = "Maestro"
        val amountPrevious = 74_999
        val amount = 15_001.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(0.0, result, 0.1)
    }

    @Test
    fun calculationsMaestro() {
        val paymentSystem = "Maestro"
        val amountPrevious = 75_001
        val amount = 15_001.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(110.006, result, 0.1)
    }

    @Test
    fun calculationsVisa() {
        val paymentSystem = "Visa"
        val amountPrevious = 15_000
        val amount = 10_000.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(750.0, result, 0.1)
    }

    @Test
    fun calculationsMir() {
        val paymentSystem = "Мир"
        val amountPrevious = 15_000
        val amount = 10_000.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(750.0, result, 0.1)
    }

    @Test
    fun calculationsVisaLimited() {
        val paymentSystem = "Visa"
        val amountPrevious = 600_001
        val amount = 150_001.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(-1.0, result, 0.1)
    }

    @Test
    fun calculationsMirLimited() {
        val paymentSystem = "Мир"
        val amountPrevious = 600_001
        val amount = 150_001.00

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(-1.0, result, 0.1)
    }

    @Test
    fun calculationsVisaMin() {
        val paymentSystem = "Visa"
        val amountPrevious = 60_000
        val amount = 400.00
        val commission = amount * 0.075

        val result = calculations(paymentSystem, amountPrevious, amount)

        assertEquals(35.0, result, 0.1)
    }

}