public class EasyDifficulty extends Difficulty {

    public EasyDifficulty(int movement) {
        super(movement);
    }

    @Override
    public int getMovement() {
        return super.getMovement() + 3;
    }
}
