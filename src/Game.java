import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player;
    private BoardTile[][] board;
    private Scanner scanner = new Scanner(System.in);
    private boolean keys;
    private ArrayList<Song> songs;
    private int movementPoints;
    private Difficulty difficulty;
    private String level;

    public Game(int[][] intBoard, String name) {
        this.board = convertToTileBoard(intBoard);
        this.player = new Player(name, intBoard);
        keys = false;

        /*
        * Credit: https://www.youtube.com/watch?v=xU1neb9ycgE
        *
         */
        songs = Song.load("src\\top_100_most_streamed_songs_on_spotify.csv");
    }

    private void setDifficulty(String difficultyLevel) {
        if (difficultyLevel.equalsIgnoreCase("easy")) {
            difficulty = new EasyDifficulty(movementPoints);
        } else if (difficultyLevel.equalsIgnoreCase("hard")) {
            difficulty = new HardDifficulty(movementPoints);
        } else {
            difficulty = new Difficulty(movementPoints); // Normal difficulty
        }

        movementPoints = difficulty.getMovement();
    }


    public void playGame() {
        boolean win = false;
        System.out.print("What level do you want? (easy) (normal) (hard): ");
        String level = scanner.nextLine();
        setDifficulty(level);

        while (!win) {
            printBoard();
            System.out.println("Movement Points: " + movementPoints);
            System.out.println("Move (WASD) or G to guess a song for movement points: ");
            String key = scanner.nextLine().toLowerCase();

            if(key.equals("g")) {
                int randomSnippet = (int) (Math.random() * 100) + 1;
                /*
                * Credit: https://www.w3schools.com/java/ref_string_format.asp
                 */
                String formatted = String.format("%03d", randomSnippet);
                File songFile = new File("src/snippets/snippet_" + formatted + ".wav");

                //get the corresponding song from the csv
                Song randomSong = songs.get(randomSnippet + 1);

                System.out.println("Playing random song snippet #" + randomSnippet);
                System.out.println(randomSong.getName());
                System.out.println(randomSong.getArtist());
                randomSong.playMusic(songFile);

                System.out.println("press x to stop the playback: ");
                String stop = scanner.nextLine();

                if(stop.toLowerCase().equals("x")) {
                    randomSong.stopMusic();
                }

                System.out.print("Who is this artist?: ");
                String response = scanner.nextLine();

                boolean correct = randomSong.checkGuess(response);

                if (correct) {
                    int reward = difficulty.getReward(true);
                    System.out.println("Correct! You get " + reward + " movement points.");
                    movementPoints += reward;
                } else {
                    int reward = difficulty.getReward(false);
                    System.out.println("Incorrect. You get " + reward + " movement point(s) for trying.");
                    movementPoints += reward;
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
            int tileType = board[player.getCurrentRow()][player.getCurrentCol()].getType();

            if (tileType == 5) {
                printBoard();
                System.out.println("You picked up a key. Maybe it can unlock something?");
                keys = true;
            }

            if (tileType == 3 && !keys) {
                printBoard();
                System.out.println("I need a key to open this.");
                if (key.equals("w")) player.moveDown();
                else if (key.equals("s")) player.moveUp();
                else if (key.equals("a")) player.moveRight();
                else if (key.equals("d")) player.moveLeft();
                movementPoints++;
            }

            if (tileType == 3 && keys) {
                printBoard();
                System.out.println("Nice! The key worked.");
            }

            if (tileType == 4) {
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
                    System.out.print("|🎸|");
                } else {
                    System.out.print(board[x][y].getSymbol());
                }
            }
            System.out.println();
        }
    }

    public BoardTile[][] convertToTileBoard(int[][] intBoard) {
        int rows = intBoard.length;
        int cols = intBoard[0].length;
        BoardTile[][] tileBoard = new BoardTile[rows][cols];

        //Consulted online resources for the switch case
        Source:
        https://www.w3schools.com/java/java_switch.asp
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                switch (intBoard[x][y]) {
                    case 1: tileBoard[x][y] = new BoardTile("|⬜|", 1); break; // Path
                    case 3: tileBoard[x][y] = new BoardTile("|\uD83D\uDD12|", 3); break; // Lock 🔒
                    case 4: tileBoard[x][y] = new BoardTile("|\uD83C\uDFC6|", 4); break; // Trophy 🏆
                    case 5: tileBoard[x][y] = new BoardTile("|\uD83D\uDD11|", 5); break; // Key 🔑
                    default: tileBoard[x][y] = new BoardTile("|⬛|", 0); break; // Wall
                }
            }
        }

        return tileBoard;
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