fun main(args: Array<String>) {
    val sum = calculations("Visa", 8000, 6500.0)

    if (sum === -1.0) {
        println("Превышен лимит операций")
    } else {
        println("Комиссия за перевод составит: $sum руб")
    }
}

fun calculations(paymentSystem: String = "VK Pay", amountPrevious: Int = 0, amount: Double): Double {
    var commission = 0.0
    when (paymentSystem) {
        "MasterCard", "Maestro", "Visa", "Мир" ->
            if (amountPrevious <= 600_000 && amount <= 150_000) {
                when (paymentSystem) {
                    "MasterCard", "Maestro" -> commission = if (amountPrevious < 75_000) 0.0 else (amount * 0.006) + 20
                    "Visa", "Мир" -> commission = if (amount * 0.075 < 35.0) 35.0 else amount * 0.075
                }
            } else commission = -1.0

        "VK Pay" -> if (amountPrevious <= 40_000 && amount <= 15_000) 0.0 else commission = -1.0
    }
    return commission
}
