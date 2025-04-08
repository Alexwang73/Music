public class BoardTile {
    private String symbol;
    private int type; // for example: 1 = path, 3 = lock, 4 = trophy, 5 = key, 0 = wall

    public BoardTile(String symbol, int type) {
        this.symbol = symbol;
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getType() {
        return type;
    }
}