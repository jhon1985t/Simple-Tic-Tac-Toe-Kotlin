fun main() {
    // write your code here   
    val ticket = readln()
    
    // Suma de los primeros tres dígitos
    val firstHalfSum = ticket.substring(0, 3).sumOf { it.digitToInt() }
    // Suma de los últimos tres dígitos
    val secondHalfSum = ticket.substring(3, 6).sumOf { it.digitToInt() }
    
    // Comparación de las sumas y salida del resultado
    if (firstHalfSum == secondHalfSum) {
        println("Lucky")
    } else {
        println("Regular")
    }
}
