public class HardDifficulty extends Difficulty {

    public HardDifficulty(int movement) {
        super(movement);
    }

    @Override
    public int getMovement() {
        return super.getMovement() - (int) (Math.random() * (5) + 1);
    }


}
