public class PathTile extends BoardTile {
    public PathTile(String symbol) {
        super(symbol, 1);
    }

    @Override
    public String getSymbol() { return "|⬜|"; }
}
