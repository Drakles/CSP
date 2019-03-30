package csp.loader;

import csp.boardgame.FutoshikiBoardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Loader {

    public static FutoshikiBoardGame scanFutoshikiBoard(String filePath) {
        FutoshikiBoardGame futoshikiBoardGame = null;
        if (filePath != null) {
            File sourceFile = new File(filePath);
            try {
                Scanner sc = new Scanner(sourceFile);

                int size = sc.nextInt();

                System.out.println(sc.nextLine());

                int[][] board = new int[size][size];

                System.out.println(sc.nextLine());

                for (int i = 0; i < size; i++) {
                    String[] split = sc.nextLine().split(";");
                    for (int j = 0; j < split.length; j++) {
                        board[j][i] = Integer.valueOf(split[j]);
                    }
                }

                System.out.println(sc.nextLine());

                List<int[]> relations = new LinkedList<>();

                while (sc.hasNext()) {
                    int[] relation = new int[4];
                    int i = 0;
                    for (String coord : sc.nextLine().split(";")) {
                        int rowIndex = coord.charAt(0) - 65;
                        int columnIndex = Character.getNumericValue(coord.charAt(1)) - 1;

                        relation[i++] = columnIndex;
                        relation[i++] = rowIndex;
                    }
                    relations.add(relation);
                }

                int[][] converted = new int[relations.size()][4];
                Iterator<int[]> relIter = relations.iterator();

                for (int i = 0; i < converted.length; i++) {
                    converted[i] = relIter.next();
                }

                futoshikiBoardGame = new FutoshikiBoardGame(board, converted);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return futoshikiBoardGame;
    }
}

