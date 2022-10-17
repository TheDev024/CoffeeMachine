enum class Rainbow {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

fun isRainbow(color: String) : Boolean {
    for (enum in Rainbow.values()) {
        if (color.uppercase() == enum.name) return true
    }
    return false
}

fun main() {
    // put your code here
    println(isRainbow(readln().uppercase()))
}