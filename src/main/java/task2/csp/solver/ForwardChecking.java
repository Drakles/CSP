package task2.csp.solver;

import task2.boardgame.SquareBoardGame;
import task2.csp.solution.SolutionCollection;
import task2.csp.solver.heuristic.Heuristic;

public class ForwardChecking extends CSPSolver {

  public ForwardChecking(
      Heuristic heuristic, SquareBoardGame game, SolutionCollection solutionCollection) {
    super(heuristic, game, solutionCollection);
  }
}
