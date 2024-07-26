var idx = 0
val buffer = readln().toCharArray()

fun main() {
    val result = calc()
    println(result)
}

fun integer(): Int {
    var number = 0
    while (idx < buffer.size && buffer[idx] in '0'..'9') {
        number = number*10 + (buffer[idx] - '0')
        idx++
    }
    return number
}

fun calc(): Int {
    var result = integer()
    while (idx < buffer.size) {
        when (buffer[idx]) {
            '+' -> {
                idx++
                result += integer()
            }
            '-' -> {
                idx++
                result -= integer()
            }
        }
    }
    return result
}