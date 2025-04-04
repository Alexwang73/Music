public class Board {
    //instance variables
    private int[][] board1;
    private int[][] board2;
    private int[][] board3;


    public Board() {
        //0 = black spaces, 1 = white spaces

        board1 = new int[][] {
                {2, 1, 1, 1, 1, 1, 0, 4},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 0, 0, 4},
                {1, 1, 1, 1, 1, 0, 0, 4},
                {5, 0, 0, 0, 1, 1, 1, 1}
        };
        board2 = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
        board3 = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public int[][] getBoard1() {
        return board1;
    }

    public int[][] getBoard2() {
        return board2;
    }

    public int[][] getBoard3() {
        return board3;
    }

    public void printBoard(int[][] playBoard) {
        for (int x = 0; x < playBoard.length; x++) {
            for (int y = 0; y < playBoard[x].length; y++) {
                if (board1[x][y] == 3 || board2[x][y] == 3 || board3[x][y] == 3) {
                    System.out.print("|\uD83D\uDD25|");
                } else if (board1[x][y] == 2 || board2[x][y] == 2 || board3[x][y] == 2) {
                    System.out.print("|\uD83C\uDFC6|");
                } else if(board1[x][y] == 1 || board2[x][y] == 1 || board3[x][y] == 1) {
                    System.out.print("|⬜|");
                } else {
                    System.out.print("|⬛|");
                }
            }
            System.out.println();
        }
    }

    public int getTile(int[][] playBoard, Player play) {
        int[][] board = playBoard;
        return board[play.getCurrentRow()][play.getCurrentCol()];
    }

}

