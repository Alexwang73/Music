public class EasyDifficulty extends Difficulty {

    public EasyDifficulty(int movement) {
        super(movement);
    }

    @Override
    public int getMovement() {
        return super.getMovement() + 3;
    }

    @Override
    public int getReward(boolean correct) {
        if (correct) {
            return 7;
        } else {
            return 2;
        }
    }
}
