public class LockTile extends BoardTile {
    public LockTile(String symbol) {
        super(symbol, 3);
    }

    @Override
    public String getSymbol() { return "|\uD83D\uDD12|"; }
}
