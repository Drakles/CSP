package task2.csp.solver.heuristic;

import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;

public class DegreeHeuristic implements Heuristic {

  @Override
  public Variable choose(
      List<Variable> variableList, List<Assigment> assigments, SquareBoardGame game) {
    // chose the one with the most constraints among remaining variables
    Variable chosen = null;

    if (!variableList.isEmpty()) {
      chosen = variableList.get(0);
      int constraintsNumber = game.numberOfOccurencesVariableInConstraints(chosen);
      for (Variable var : variableList) {
        int nextConstraintNumber = game.numberOfOccurencesVariableInConstraints(var);
        if (nextConstraintNumber > constraintsNumber) {
          constraintsNumber = nextConstraintNumber;
          chosen = var;
        }
      }
    }
    return chosen;
  }

  @Override
  public String toString() {
    return "DegreeHeuristic";
  }
}
