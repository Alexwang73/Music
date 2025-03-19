import java.util.ArrayList;

public class Game {
    //instance variables
    ArrayList spaces;
    boolean win = true;

    //methods
    public void playGame() {
        //while the game is ongoing, print the tiles & guess the song
        while(!win) {
            System.out.println(spaces);
            System.out.println("-----------------------------------");
            System.out.println("GUESS THE SONG:");
            //add stuff here
            System.out.println("-----------------------------------");
        }
    }

    //helpers (if needed)
}
