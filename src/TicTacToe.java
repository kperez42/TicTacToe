 // TicTacToe.java
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
    public void displayBoard() {
        System.out.println(" _______________________ ");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print("   " + board[i][j] + "   |");
            }
            System.out.println("\n|_______|_______|_______|");
        }
    }

    // Method to make a move
    public boolean makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    // Method to check the game's status
    public GameStatus checkStatus() {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return GameStatus.WIN;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return GameStatus.WIN;
            }
        }

        // Check diagonals for a win
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return GameStatus.WIN;
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return GameStatus.WIN;
        }

        // Check for a draw
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    isDraw = false;
                }
            }
        }
        if (isDraw) {
            return GameStatus.DRAW;
        }

        // Continue the game
        return GameStatus.CONTINUE;
    }

    // Method to switch players
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Main gameplay loop
    public void playGame() {
        while (status == GameStatus.CONTINUE) {
            displayBoard();
            System.out.println("Player " + currentPlayer + "'s turn.");
            int row, col;
            java.util.Scanner input = new java.util.Scanner(System.in);
            System.out.print("Enter row (0, 1, or 2): ");
            row = input.nextInt();
            System.out.print("Enter column (0, 1, or 2): ");
            col = input.nextInt();

            if (makeMove(row, col)) {
                status = checkStatus();
                if (status == GameStatus.CONTINUE) {
                    switchPlayer();
                }
            }
        }

        displayBoard();
        if (status == GameStatus.WIN) {
            System.out.println("Player " + currentPlayer + " wins!");
        } else if (status == GameStatus.DRAW) {
            System.out.println("It's a draw!");
        }
    }

    // Main method to start the game
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}

