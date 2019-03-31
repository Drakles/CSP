package task2.boardgame;

import java.util.Arrays;

public abstract class SquareSquareBoardGameImpl implements SquareBoardGame {
    final int[][] board;

    public SquareSquareBoardGameImpl(int[][] board) {
        this.board = board;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getBoardLength() {
        return board.length;
    }

    @Override
    public String toString() {
        return "SquareSquareBoardGameImpl{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
