fun main(args: Array<String>) {
    val sum = calculation("Мир", 80000, 6500.0)
    println("Комиссия за перевод составит: $sum руб")
}

fun calculation(paymentSystem: String = "VK Pay", amountPrevious: Int = 0, amount: Double): Double {
    var commission = 0.0
    when (paymentSystem) {
        "MasterCard", "Maestro" -> commission = if (amountPrevious < 75_000) 0.0 else (amount * 0.006) + 20
        "Visa", "Мир" -> commission = if (amount * 0.075 < 35.0) 35.0 else amount * 0.075
        "VK Pay" -> 0.0
    }
    return commission
}