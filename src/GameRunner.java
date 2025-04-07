public class GameRunner {
    public static void main(String[] args) {
        Board board = new Board();
        int[][] board3 = board.getBoard3();

        // Create the game with board1 and a test player name
        Game game = new Game(board3, "TestPlayer");

        // Run the game (will print the board and take input)
        game.playGame();

    }
}