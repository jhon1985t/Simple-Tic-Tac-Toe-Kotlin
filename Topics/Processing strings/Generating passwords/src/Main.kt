fun main() {
    val (A, B, C, N) = readln().split(" ").map { it.toInt() }
    val passwordBuilder = StringBuilder(N)

    // Characters sets
    val upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz"
    val digits = "0123456789"

    // Trackers for the last index used for each character type
    var lastUpperIndex = 0
    var lastLowerIndex = 0
    var lastDigitIndex = 0

    // Add characters ensuring no consecutive repeats
    var totalCount = 0
    while (totalCount < N) {
        if (totalCount < A) {
            passwordBuilder.append(upperCaseLetters[lastUpperIndex++ % upperCaseLetters.length])
        } else if (totalCount < A + B) {
            passwordBuilder.append(lowerCaseLetters[lastLowerIndex++ % lowerCaseLetters.length])
        } else if (totalCount < A + B + C) {
            passwordBuilder.append(digits[lastDigitIndex++ % digits.length])
        } else {
            // Fill the rest with alternating characters from different sets
            when (totalCount % 3) {
                0 -> passwordBuilder.append(upperCaseLetters[lastUpperIndex++ % upperCaseLetters.length])
                1 -> passwordBuilder.append(lowerCaseLetters[lastLowerIndex++ % lowerCaseLetters.length])
                2 -> passwordBuilder.append(digits[lastDigitIndex++ % digits.length])
            }
        }
        totalCount++

        // Ensure no consecutive identical characters
        if (passwordBuilder.length > 1 && passwordBuilder.last() == passwordBuilder[passwordBuilder.lastIndex - 1]) {
            passwordBuilder.setLength(passwordBuilder.length - 1) // Remove last char
            totalCount-- // Decrement count to maintain correct number of characters
        }
    }

    println(passwordBuilder.toString())
}
