var idx = 0
var buffer = charArrayOf()

fun integer(): Int {
    var number = 0
    var sign = 1
    if (buffer[idx] == '-') {
        idx++
        sign = -1
    } else if (buffer[idx] == '+') {
        idx++
    }
    while (idx < buffer.size && buffer[idx] in '0'..'9') {
        number = number*10 + (buffer[idx] - '0')
        idx++
    }
    return number * sign
}

fun paren(): Int {
    if (buffer[idx] == '(') {
        idx++
        val result = addSub()
        idx++
        return result
    } else {
        return integer()
    }
}

fun mulDiv(): Int {
    var result = paren()
    while (idx < buffer.size && (buffer[idx] == '*' || buffer[idx] == '/' || buffer[idx] == '%')) {
        when (buffer[idx]) {
            '*' -> {
                idx++
                result *= paren()
            }
            '/' -> {
                idx++
                result /= paren()
            }
            '%' -> {
                idx++
                result %= paren()
            }
        }
    }
    return result
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

fun main() {
    val exitCommands = setOf("exit", "quit")
    while (true) {
        val input = readlnOrNull() ?: break
        if (input in exitCommands) break
        buffer = input.toCharArray()
        val result = addSub()
        println(result)
    }
}
