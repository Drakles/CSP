package task2.loader;

import static task2.csp.AssigmentFactory.createAssigment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import task2.boardgame.FutoshikiSquareBoardGameImpl;
import task2.csp.Assigment;
import task2.csp.Variable;

public class Loader {

  public static FutoshikiSquareBoardGameImpl scanFutoshikiBoard(String filePath) {
    FutoshikiSquareBoardGameImpl futoshikiBoardGame = null;
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
            new FutoshikiSquareBoardGameImpl(
                size, initialAssigments, Collections.unmodifiableList(relations));

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }
    return futoshikiBoardGame;
  }
}
