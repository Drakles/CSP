package task2.boardgame;

import java.util.Arrays;

public class FutoshikiSquareBoardGameImpl extends SquareSquareBoardGameImpl {

    private final int[][] relations;

    public FutoshikiSquareBoardGameImpl(int[][] board, int[][] relations) {
        super(board);
        this.relations = relations;
    }

    @Override
    public int[][] getConstraints() {
        return relations;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("FutoshikiSquareBoardGameImpl{ ");

        sb.append("board: [");
        for (int[] singleRow : board) {
            sb.append(Arrays.toString(singleRow));
        }
        sb.append("]");

        sb.append("\n relations: [");
        for (int[] singleRel : relations) {
            sb.append(Arrays.toString(singleRel));
        }
        sb.append("]");
        sb.append("}");

        return sb.toString();
    }
}
