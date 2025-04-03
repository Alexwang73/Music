public class Player {
    private String name;
    private int currentRow;
    private int currentCol;
    private int[][] board;

    public Player(String name, int[][] board) {
        this.name = name;
        this.board = board;
        this.currentRow = 0;
        this.currentCol = 0;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void moveLeft() {
        if (isValidMove(currentRow, currentCol - 1)) currentCol--;
    }

    public void moveRight() {
        if (isValidMove(currentRow, currentCol + 1)) currentCol++;
    }

    public void moveUp() {
        if (isValidMove(currentRow - 1, currentCol)) currentRow--;
    }

    public void moveDown() {
        if (isValidMove(currentRow + 1, currentCol)) currentRow++;
    }

    private boolean isValidMove(int newRow, int newCol) {
        if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
            return board[newRow][newCol] != 0; // Ensure not a wall (black space)
        }
        return false;
    }
}
