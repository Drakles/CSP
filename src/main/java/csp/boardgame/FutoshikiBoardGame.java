package csp.boardgame;

import java.util.Arrays;

public class FutoshikiBoardGame extends SquareBoardGame {

    private final int[][] relations;

    public FutoshikiBoardGame(int[][] board, int[][] relations) {
        super(board);
        this.relations = relations;
    }

    public int[][] getRelations() {
        return relations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("FutoshikiBoardGame{ ");

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
