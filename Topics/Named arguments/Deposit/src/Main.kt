import kotlin.math.pow

fun compoundInterest(
    amount: Double = 1000.0,
    percent: Int = 5,
    years: Int = 10,
): Double {
    return amount * (1.0 + percent.toDouble() / 100.0).pow(years.toDouble())
}

fun main() {
    val property = readln()
    val value = readln().toInt()
    val total = when (property) {
        "amount" -> compoundInterest(amount = value.toDouble())
        "percent" -> compoundInterest(percent = value)
        else -> compoundInterest(years = value)
    }
    println(total.toInt())
}