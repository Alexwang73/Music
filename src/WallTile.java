public class WallTile extends BoardTile {
    public WallTile(String symbol) {
        super(symbol, 0);
    }

    @Override
    public String getSymbol() { return "|⬛|"; }
}

