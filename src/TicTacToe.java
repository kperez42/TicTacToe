// TicTacToe.java
// Group Project Participants :  Kevin Perez
public class TicTacToe {

    private char[][] board; // 3x3 game board
    private GameStatus status; // Enumeration for game state
    private char currentPlayer; // 'X' or 'O'

    // Enumeration for game status
    public enum GameStatus {
        WIN, DRAW, CONTINUE
    } 

    // Constructor to initialize the board
    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' '; // Empty space
            }
        }
        status = GameStatus.CONTINUE;
        currentPlayer = 'X'; // Player X starts
    }

    // Method to display the board
   
