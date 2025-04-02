public class Player {
    private String name;
    private int movementPoints;
    private int currentRow;
    private int currentCol;
    private int[][] board;

    public Player(String name, int movementPoints, int[][] board) {
        this.name = name;
        this.movementPoints = movementPoints;
        this.board = board;
        currentCol = 0;
        currentRow = 0;
    }

    public int getMovementPoints() {
        return movementPoints;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void moveLeft() {
        currentCol --;
        movementPoints--;
    }

    public void moveRight() {
        currentCol ++;
        movementPoints--;
    }

    public void moveUp() {
        currentRow ++;
        movementPoints--;
    }

    public void moveDown() {
        currentRow --;
        movementPoints--;
    }





}
