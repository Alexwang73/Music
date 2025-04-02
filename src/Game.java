import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int xLoc;
    private int yLoc;
    private int[][] board;
    private int moves;
    private Scanner scanner = new Scanner(System.in);
    private Player player;
    private String name;


    public Game(int[][] board, String name) {
        xLoc = 0;
        yLoc = 0;
        this.board = board;
        moves = 0;
        this.name = name;
        player = new Player(name, moves, board);
    }


    public void playGame(int[][] testBoard, String[][] playBoard) {
        Scanner scan = new Scanner(System.in);
        boolean win = false;
        boolean move = true;
        int totalPlayerMoves = 0; // measures how many times the player has moved in a turn

        while (!win) { //needs a win condition in the loop
            //printBoard(playBoard); //printboard is in a separate class
            System.out.println("Please choose a space to move");
            String key = scan.nextLine();
            key = key.toLowerCase();
            while (move && totalPlayerMoves < totalPlayerMoves) {
                System.out.println("Please choose a space to move");
                if (key.equals("w") || key.equals("a") || key.equals("s") || key.equals("d")) {
                    if (!isWhite(testBoard, key, xLoc, yLoc)) {
                        System.out.println("You cannot move there");
                    } else if (key.equals("w")) {
                        player.moveUp();
                    } else if (key.equals(("s"))) {
                        player.moveDown();
                    } else if (key.equals("a")) {
                        player.moveLeft();
                    } else if (key.equals("d")) {
                        player.moveRight();
                    }
                    move = false;
                }
            }
        }
    }

    // 0 is white
    // 1 is gray or black
    //this might not be necessary
    public boolean isWhite(int[][] testBoard, String key, int x, int y) {
        boolean isWhite = false;
        if (key.equals("w")) {
            if (x+1<testBoard.length && x+1>0) {
                if (testBoard[x+1][y]==0) {
                    isWhite=true;
                    xLoc++;
                }
            }
        }
        if (key.equals("a")) {
            if (y-1<testBoard.length && y-1>0) {
                if (testBoard[x][y-1]==0) {
                    isWhite=true;
                    yLoc--;
                }
            }
        }
        if (key.equals("s")) {
            if (x-1>testBoard.length && x-1>0) {
                if (testBoard[x-1][y]==0) {
                    isWhite=true;
                    xLoc--;
                }
            }
        }
        if (key.equals("d")) {
            if (y+1<testBoard.length && y+1>0) {
                if (testBoard[x][y+1]==0) {
                    isWhite=true;
                    yLoc++;
                }
            }
        }
        return isWhite;
    }


    private void generateChoices() {
        ArrayList<Song> options = new ArrayList<>();
        int random = ((int) (Math.random() * 99)) + 1;
        String correctArtist = ""; //placeholder, I'll replace this logic with actually determining the correct artist
        //read from the file

        System.out.println("This song is by, Enter Choice (1-4): ");
        int choice = scanner.nextInt();
        scanner.nextLine();


        if(options.get(choice).getArtist().equals(correctArtist)) {
            moves ++;
        }

    }
}
