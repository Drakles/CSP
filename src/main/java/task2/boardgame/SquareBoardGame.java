package task2.boardgame;

import java.util.Arrays;

public abstract class SquareBoardGame implements BoardGame{
    final int[][] board;

    public SquareBoardGame(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "SquareBoardGame{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
