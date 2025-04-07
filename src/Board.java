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
                {0, 0, 0, 0, 1, 3, 1, 1},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 0},
                {5, 0, 0, 0, 1, 1, 1, 1}
        };
        board2 = new int[][] {
                {1, 1, 1, 0, 0, 0, 0, 5},
                {1, 0, 1, 0, 2, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 3, 1, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 4}
        };
        board3 = new int[][] {
                {2, 0, 1, 1, 1, 1, 1, 4},
                {1, 0, 0, 0, 0, 0, 3, 0},
                {1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 0, 5, 0, 1, 0},
                {1, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}
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

}

