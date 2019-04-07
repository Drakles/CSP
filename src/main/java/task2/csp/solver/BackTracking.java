package task2.csp.solver;

import static task2.csp.AssigmentFactory.createAssigment;
import static task2.csp.solver.CSPSolver.Result.FAIL;
import static task2.csp.solver.CSPSolver.Result.SUCCESS;

import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solver.strategy.Heuristic;

public class BackTracking extends CSPSolver {

  private final int assigmentsLimit = game.getSize() * game.getSize();

  public BackTracking(Heuristic heuristic, SquareBoardGame game) {
    super(heuristic, game);
  }

  public Result run(List<Assigment> assigments, List<Variable> variables, int level) {
    if (assigments.size() == assigmentsLimit) {
      return SUCCESS;
    }

    Variable var = heuristic.choose(variables, assigments, game);
    variables.remove(var);

    for (Integer value : game.getPotentialValues(var, assigments)) {
      Assigment assigment = createAssigment(value, var);
      assigments.add(assigment);

      Result result = run(assigments, variables, ++level);
      if (result != FAIL) {
        return result;
      }

      assigments.remove(assigment);
    }
    variables.add(var);
    return FAIL;
  }
}
