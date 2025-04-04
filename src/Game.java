import java.util.Scanner;

public class Game {
    private Player player;
    private int[][] board;
    private Scanner scanner = new Scanner(System.in);

    public Game(int[][] board, String name) {
        this.board = board;
        this.player = new Player(name, board);
    }

    public void playGame() {
        boolean win = false;

        while (!win) {
            printBoard();
            System.out.println("Move (WASD): ");
            String key = scanner.nextLine().toLowerCase();

            if (key.equals("w")) player.moveUp();
            else if (key.equals("s")) player.moveDown();
            else if (key.equals("a")) player.moveLeft();
            else if (key.equals("d")) player.moveRight();
            else System.out.println("Invalid input!");

            if (board[player.getCurrentRow()][player.getCurrentCol()] == 3) {
                printBoard();
                System.out.println("You LOST");
                win = true;
            }

            // Win condition (reaching position with a 4)
            if (board[player.getCurrentRow()][player.getCurrentCol()] == 4) {
                printBoard();
                System.out.println("Congratulations! You won!");
                win = true;
            }
        }
    }

    private void printBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (x == player.getCurrentRow() && y == player.getCurrentCol()) {
                    System.out.print("|🎸|");  // Player represented by guitar emoji
                } else if (board[x][y] == 1) {
                    System.out.print("|⬜|"); // White path
                } else {
                    System.out.print("|⬛|"); // Walls
                }
            }
            System.out.println();
        }
    }

    public int getCurR() {
        return player.getCurrentRow();
    }

    public int getCurC() {
        return player.getCurrentCol();
    }
}
