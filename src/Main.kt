var idx = 0
val buffer = readln().toCharArray()

fun main() {
    val number = integer()
    println(number)
}

fun integer(): Int {
    var number = 0
    while (idx < buffer.size && buffer[idx] in '0'..'9') {
        number = number*10 + (buffer[idx] - '0')
        idx++
    }
    return number
}