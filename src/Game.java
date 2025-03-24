import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int xLoc = 0;
    private int yLoc = 0;

    public void printBoard(String[][]playBoard) {
        for (int x = 0; x < playBoard.length; x++) {
            for (int y = 0; y < playBoard[x].length; y++) {
                System.out.print(playBoard[x][y]);
            }
            System.out.println();
        }
    }

    public void playGame(int[][] testBoard, String[][] playBoard) {
        Scanner scan = new Scanner(System.in);
        boolean win = false;
        while (!win) { //needs a win condition in the loop
            printBoard(playBoard);
            System.out.println("Please choose a space to move");
            String key = scan.nextLine();
            key = key.toLowerCase();
            if (key.equals("w")||key.equals("a")||key.equals("s")||key.equals("d")) {
                if (!isWhite(testBoard, key, xLoc, yLoc)) {
                    System.out.println("You cannot move there");
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
