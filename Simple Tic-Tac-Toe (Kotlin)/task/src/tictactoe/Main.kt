package tictactoe

fun main() {
    var board = MutableList(3) { MutableList(3) { ' ' } }
    var currentPlayer = 'X'
    var movesCount = 0
    var gameEnded = false

    while (!gameEnded) {
        printBoard(board)
        var (row, col) = getUserInput(board)
        board[row][col] = currentPlayer
        movesCount++

        if (checkWin(board, currentPlayer)) {
            printBoard(board)
            println("$currentPlayer wins")
            gameEnded = true
        } else if (movesCount == 9) {
            printBoard(board)
            println("Draw")
            gameEnded = true
        }

        currentPlayer = if (currentPlayer == 'X') 'O' else 'X'
    }
}

fun getUserInput(board: MutableList<MutableList<Char>>): Pair<Int, Int> {
    while (true) {
        println("Enter the coordinates: ")
        val input = readln().split(" ")

        try {
            val row = input[0].toInt() - 1
            val col = input[1].toInt() - 1

            if (row !in 0..2 || col !in 0..2) {
                println("Coordinates should be from 1 to 3!")
            } else if (board[row][col] != ' ') {
                println("This cell is occupied! Choose another one!")
            } else {
                return Pair(row, col)
            }
        } catch (e: Exception) {
            println("You should enter numbers!")
        }
    }
}

fun printBoard(board: List<List<Char>>) {
    println("---------")
    for (row in board) {
        println("| ${row.joinToString(" ")} |")
    }
    println("---------")
}

fun checkWin(board: List<List<Char>>, player: Char): Boolean {
    for (i in 0..2) {
        if (board[i].all { it == player } || board.all { it[i] == player }) return true
    }
    if ((0..2).all { i -> board[i][i] == player } || (0..2).all { i -> board[i][2 - i] == player }) return true
    return false
}
