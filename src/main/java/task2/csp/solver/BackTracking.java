package task2.csp.solver;

import static task2.csp.AssigmentFactory.createAssigment;

import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solution.SolutionCollection;
import task2.csp.solver.heuristic.Heuristic;

public class BackTracking extends CSPSolver {

  public BackTracking(
      Heuristic heuristic, SquareBoardGame game, SolutionCollection solutionCollection) {
    super(heuristic, game, solutionCollection);
  }

  public SolutionCollection run(List<Assigment> assigments, List<Variable> variables, int level) {
    if (game.isOver(assigments)) {
      addSolution(assigments, level);
      return this.solutionCollection;
    }

    Variable var = heuristic.choose(variables, assigments, game);
    variables.remove(var);

    for (Integer value : getPotentialValues(var, assigments)) {
      Assigment assigment = createAssigment(value, var);
      assigments.add(assigment);

      run(assigments, variables, ++level);
      assigments.remove(assigment);
    }
    variables.add(var);
    return null;
  }
}
