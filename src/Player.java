public class Player {
    private String name;
    private int movementPoints;
    private int currentRow;
    private int currentCol;

    public Player(String name, int movementPoints, int currentRow, int currentCol) {
        this.name = name;
        this.movementPoints = movementPoints;
        this.currentCol = currentRow;
        this.currentCol = currentCol;
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
