fun main() {
    val buffer = readln().toCharArray()
    var number = 0
    var i = 0
    while (i < buffer.size && buffer[i] in '0'..'9') {
        number = number*10 + (buffer[i] - '0')
        i++
    }
    println(number)
}