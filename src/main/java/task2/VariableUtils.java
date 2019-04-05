package task2;

import java.util.ArrayList;
import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;

public class VariableUtils {

  public static List<Variable> getVariables(SquareBoardGame squareBoardGame) {
    int boardLength = squareBoardGame.getSize();
    List<Variable> variables = new ArrayList<>(boardLength * boardLength);
    List<Assigment> initialAssigments = squareBoardGame.getInitialAssigment();
    for (int i = 0; i < boardLength; i++) {
      for (int j = 0; j < boardLength; j++) {
        int finalJ = j;
        int finalI = i;
        if (initialAssigments.stream()
            .noneMatch(a -> a.getVariable().isCoordEquals(finalJ, finalI))) {
          variables.add(new Variable(j, i));
        }
      }
    }
    return variables;
  }
}
