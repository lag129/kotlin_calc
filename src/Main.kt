var idx = 0
val buffer = readln().toCharArray()

fun main() {
    val left = integer()
    idx+=1
    val right = integer()
    val result = left + right
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