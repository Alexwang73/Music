import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player;
    private int[][] board;
    private Scanner scanner = new Scanner(System.in);
    private boolean keys;
    private ArrayList<Song> songs;
    private int movementPoints;

    public Game(int[][] board, String name) {
        this.board = board;
        this.player = new Player(name, board);
        keys = false;
        songs = Song.load("src\\top_100_most_streamed_songs_on_spotify.csv");
        movementPoints = 3; // Start with 3 movement points
    }

    public void playGame() {
        boolean win = false;

        while (!win) {
            printBoard();
            System.out.println("Movement Points: " + movementPoints);
            System.out.println("Move (WASD) or G to guess a song for movement points: ");
            String key = scanner.nextLine().toLowerCase();

            if(key.equals("g")) {
                int randomSnippet = (int) (Math.random() * 100) + 1;
                String formatted = String.format("%03d", randomSnippet);
                File songFile = new File("src/snippets/snippet_" + formatted + ".wav");

                //get the corresponding song from the csv
                Song randomSong = songs.get(randomSnippet + 1);

                System.out.println("Playing random song snippet #" + randomSnippet);
                randomSong.playMusic(songFile);

                try {
                    System.out.println("Press Enter to stop the playback...");
                    System.in.read();
                } catch (Exception e) {
                    System.out.println(e);
                }

                System.out.print("Who is this artist?: ");
                String response = scanner.nextLine();

                boolean correct = randomSong.checkGuess(response);

                if (correct) {
                    System.out.println("Correct! You get 3 movement points.");
                    movementPoints += 3;
                } else {
                    System.out.println("Incorrect. You get 1 movement point for trying.");
                    movementPoints += 1;
                }
            }
            else if (key.equals("w") || key.equals("a") || key.equals("s") || key.equals("d")) {
                // Check if player has movement points
                if (movementPoints <= 0) {
                    System.out.println("You don't have any movement points! Guess a song to earn more.");
                    continue;
                }

                // Store original position in case we need to revert
                int originalRow = player.getCurrentRow();
                int originalCol = player.getCurrentCol();

                // Try to move
                if (key.equals("w")) {
                    player.moveUp();
                }
                else if (key.equals("s")) {
                    player.moveDown();
                }
                else if (key.equals("a")) {
                    player.moveLeft();
                }
                else if (key.equals("d")) {
                    player.moveRight();
                }

                // Decrement movement points only if move was successful
                if (originalRow != player.getCurrentRow() || originalCol != player.getCurrentCol()) {
                    movementPoints--;
                }
            }
            else {
                System.out.println("Invalid input! Please choose a different move");
                continue;
            }

            // Check for special tiles
            if (board[player.getCurrentRow()][player.getCurrentCol()] == 5) {
                printBoard();
                System.out.println("You picked up a key. Maybe it can unlock something?");
                keys = true;
            }
            if (board[player.getCurrentRow()][player.getCurrentCol()] == 3 && keys == false) {
                printBoard();
                System.out.println("I need a key to open this.");
                // Move player back to previous position
                if (key.equals("w")) player.moveDown();
                else if (key.equals("s")) player.moveUp();
                else if (key.equals("a")) player.moveRight();
                else if (key.equals("d")) player.moveLeft();
                // Refund the movement point since the move was invalid
                movementPoints++;
            }
            if (board[player.getCurrentRow()][player.getCurrentCol()] == 3 && keys == true) {
                printBoard();
                System.out.println("Nice! The key worked.");
            }

            // Win condition (reaching position with a 4)
            if (board[player.getCurrentRow()][player.getCurrentCol()] == 4) {
                printBoard();
                System.out.println("Congratulations! You won with " + movementPoints + " movement points remaining!");
                win = true;
            }
        }
    }

    private void printBoard() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (x == player.getCurrentRow() && y == player.getCurrentCol()) {
                    System.out.print("|🎸|");  // Player represented by guitar emoji
                } else if (board[x][y] == 1) {
                    System.out.print("|⬜|"); // White path
                } else if (board[x][y] == 4) {
                    System.out.print("|\uD83C\uDFC6|"); // Trophy
                } else if (board[x][y] == 3) {
                    System.out.print("|\uD83D\uDD12|"); // lock
                } else if (board[x][y] == 5) {
                    System.out.print("|\uD83D\uDD11|"); //key
                } else {
                    System.out.print("|⬛|"); // Walls
                }
            }
            System.out.println();
        }
    }

    public int getCurR() {
        return player.getCurrentRow();
    }

    public int getCurC() {
        return player.getCurrentCol();
    }

    public int getMovementPoints() {
        return movementPoints;
    }
}