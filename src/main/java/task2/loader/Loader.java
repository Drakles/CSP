package task2.loader;

import static task2.csp.AssigmentFactory.createAssigment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import task2.boardgame.Futoshiki;
import task2.boardgame.SkyCrapper;
import task2.csp.Assigment;
import task2.csp.Variable;

public class Loader {

  public static Futoshiki scanFutoshikiBoard(String filePath) {
    Futoshiki futoshikiBoardGame = null;
    if (filePath != null) {
      File sourceFile = new File(filePath);
      try {
        Scanner sc = new Scanner(sourceFile);

        int size = sc.nextInt();

        System.out.println(sc.nextLine());

        List<Assigment> initialAssigments = new LinkedList<>();

        System.out.println(sc.nextLine());

        for (int i = 0; i < size; i++) {
          String[] split = sc.nextLine().split(";");
          for (int j = 0; j < split.length; j++) {
            int value = Integer.valueOf(split[j]);
            if (value != 0) {
              initialAssigments.add(createAssigment(value, new Variable(j, i)));
            }
          }
        }

        System.out.println(sc.nextLine());

        List<Variable[]> relations = new LinkedList<>();

        while (sc.hasNext()) {
          Variable[] relation = new Variable[2];
          int i = 0;
          for (String coord : sc.nextLine().split(";")) {
            int rowIndex = coord.charAt(0) - 65;
            int columnIndex = Character.getNumericValue(coord.charAt(1)) - 1;

            Variable var = new Variable(columnIndex, rowIndex);
            relation[i++] = var;
          }
          relations.add(relation);
        }

        futoshikiBoardGame =
            new Futoshiki(size, initialAssigments, Collections.unmodifiableList(relations));

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return futoshikiBoardGame;
  }

  public static SkyCrapper scanSkyCrapper(String filePath) {
    SkyCrapper skyCrapper = null;

    if (filePath != null) {
      File sourceFile = new File(filePath);
      try {
        Scanner sc = new Scanner(sourceFile);

        int size = sc.nextInt();
        System.out.println(sc.nextLine());

        int row = 0;
        int column = 0;
        Map<Variable, Integer> upperRow = new LinkedHashMap<>();
        for (String numberOfVisibleSkyCrappers : sc.nextLine().split(";")) {
          if (Character.isLetter(numberOfVisibleSkyCrappers.charAt(0))) {
            continue;
          }
          Variable var = new Variable(column++, row);
          upperRow.put(var, Integer.valueOf(numberOfVisibleSkyCrappers));
        }

        row = size - 1;
        column = 0;
        Map<Variable, Integer> downRow = new LinkedHashMap<>();
        for (String numberOfVisibleSkyCrappers : sc.nextLine().split(";")) {
          if (Character.isLetter(numberOfVisibleSkyCrappers.charAt(0))) {
            continue;
          }
          Variable var = new Variable(column++, row);
          downRow.put(var, Integer.valueOf(numberOfVisibleSkyCrappers));
        }

        row = 0;
        column = 0;
        Map<Variable, Integer> leftColumn = new LinkedHashMap<>();
        for (String numberOfVisibleSkyCrappers : sc.nextLine().split(";")) {
          if (Character.isLetter(numberOfVisibleSkyCrappers.charAt(0))) {
            continue;
          }
          Variable var = new Variable(column, row++);
          leftColumn.put(var, Integer.valueOf(numberOfVisibleSkyCrappers));
        }

        row = 0;
        column = size - 1;
        Map<Variable, Integer> rightColumn = new LinkedHashMap<>();
        for (String numberOfVisibleSkyCrappers : sc.nextLine().split(";")) {
          if (Character.isLetter(numberOfVisibleSkyCrappers.charAt(0))) {
            continue;
          }
          Variable var = new Variable(column, row++);
          rightColumn.put(var, Integer.valueOf(numberOfVisibleSkyCrappers));
        }

        skyCrapper = new SkyCrapper(size, upperRow, downRow, leftColumn, rightColumn);

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }

    return skyCrapper;
  }
}
