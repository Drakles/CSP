package task2.csp.solver;

import task2.boardgame.SquareBoardGame;
import task2.csp.solver.strategy.Heuristic;

public abstract class CSPSolver {
  final Heuristic heuristic;
  final SquareBoardGame game;

  public CSPSolver(Heuristic heuristic, SquareBoardGame game) {
    this.heuristic = heuristic;
    this.game = game;
  }

  enum Result {
    SUCCESS,
    FAIL
  }
}
