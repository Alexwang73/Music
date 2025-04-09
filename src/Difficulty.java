public class Difficulty {
    int movement;

    public Difficulty(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }

    public int getReward(boolean correct) {
        if (correct) {
            return 5;
        } else {
            return 3;
        }
    }

}
