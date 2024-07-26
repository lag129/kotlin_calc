var idx = 0
val buffer = readln().toCharArray()

fun main() {
    val result = addSub()
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

fun addSub(): Int {
    var result = mulDiv()
    while (idx < buffer.size && (buffer[idx] == '+' || buffer[idx] == '-')) {
        when (buffer[idx]) {
            '+' -> {
                idx++
                result += mulDiv()
            }
            '-' -> {
                idx++
                result -= mulDiv()
            }
        }
    }
    return result
}

fun mulDiv(): Int {
    var result = integer()
    while (idx < buffer.size && (buffer[idx] == '*' || buffer[idx] == '/')) {
        when (buffer[idx]) {
            '*' -> {
                idx++
                result *= integer()
            }
            '/' -> {
                idx++
                result /= integer()
            }
        }
    }
    return result
}