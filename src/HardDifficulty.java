public class HardDifficulty extends Difficulty {

    public HardDifficulty(int movement) {
        super(movement);
    }

    @Override
    public int getMovement() {
        return super.getMovement() - (int) (Math.random() * (5) + 1);
    }


    @Override
    public int getReward(boolean correct) {
        if (correct) {
            return 3 + (int)(Math.random() * 2);
        } else {
            return 1;
        }
    }
}
