package task2.csp.solver.heuristic;

import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;

public class MinimumRemainingValuesHeuristic implements Heuristic {

  @Override
  public Variable choose(
      List<Variable> variableList, List<Assigment> assigments, SquareBoardGame game) {
    Variable chosen = null;
    if (!variableList.isEmpty()) {
      chosen = variableList.get(0);
      int minPotentialValues = game.getPotentialValues(chosen, assigments).size();
      for (Variable variable : variableList) {
        int nextPotentialValuesNumber = game.getPotentialValues(variable, assigments).size();
        if (nextPotentialValuesNumber < minPotentialValues) {
          chosen = variable;
          minPotentialValues = nextPotentialValuesNumber;
          if (nextPotentialValuesNumber == 1) {
            return chosen;
          }
        }
      }
    }
    return chosen;
  }

  @Override
  public String toString() {
    return "MinimumRemainingValuesHeuristic";
  }
}
