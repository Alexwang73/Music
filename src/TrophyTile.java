public class TrophyTile extends BoardTile {
    public TrophyTile(String symbol) {
        super(symbol, 4);
    }

    @Override
    public String getSymbol() { return "|\uD83C\uDFC6|"; }
}
