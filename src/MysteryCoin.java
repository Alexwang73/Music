public class MysteryCoin extends Coin {
    private int value;

    public MysteryCoin(int value) {
        super(value);
        value = 0;
    }

    private void randomValue() {
        value = (int) Math.random() * 100;
    }
}
