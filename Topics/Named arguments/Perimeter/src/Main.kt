import kotlin.math.hypot

fun perimeter(
    x1: Double,
    y1: Double,
    x2: Double,
    y2: Double,
    x3: Double,
    y3: Double,
    x4: Double = x1,
    y4: Double = y1,
): Double {
    val side1 = hypot(x2 - x1, y2 - y1)
    val side2 = hypot(x3 - x2, y3 - y2)
    val side3 = hypot(x4 - x3, y4 - y3)
    val side4 = hypot(x1 - x4, y1 - y4)
    return side1 + side2 + side3 + side4
}