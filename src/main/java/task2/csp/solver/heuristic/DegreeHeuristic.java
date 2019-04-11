package task2.csp.solver.heuristic;

import java.util.Comparator;
import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;

public class DegreeHeuristic implements Heuristic {

  @Override
  public Variable choose(
      List<Variable> variableList, List<Assigment> assigments, SquareBoardGame game) {
    // chose the one with the most constraints among remaining variables
//    return variableList
//        .parallelStream()
//        .max(Comparator.comparingInt(v -> numberOfOccurences(v, game.getConstraints())))
//        .orElse(null);
    return null;
  }

//  private int numberOfOccurences(Variable chosen, List<Variable[]> constraints) {
//    return (int)
//        constraints
//            .parallelStream()
//            .filter(constraint -> chosen.equals(constraint[0]) || chosen.equals(constraint[1]))
//            .count();
//  }

  @Override
  public String toString() {
    return "DegreeHeuristic";
  }
}
