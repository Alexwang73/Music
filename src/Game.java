import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int xLoc;
    private int yLoc;
    private int[][] board;


    public Game(int[][] board) {
        xLoc = 0;
        yLoc = 0;
        this.board = board;
    }


    public void playGame(int[][] testBoard, String[][] playBoard) {
        Scanner scan = new Scanner(System.in);
        boolean win = false;
        boolean move = true;

        while (!win) { //needs a win condition in the loop
            //printBoard(playBoard); //printboard is in a separate class
            System.out.println("Please choose a space to move");
            String key = scan.nextLine();
            key = key.toLowerCase();
            while (move) {
                System.out.println("Please choose a space to move");
                if (key.equals("w") || key.equals("a") || key.equals("s") || key.equals("d")) {
                    if (!isWhite(testBoard, key, xLoc, yLoc)) {
                        System.out.println("You cannot move there");
                    }
                    move = false;
                }
            }
        }
    }

    // 0 is white
    // 1 is gray or black
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

}
