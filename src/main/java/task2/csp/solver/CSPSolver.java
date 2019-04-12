package task2.csp.solver;

import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solution.Solution;
import task2.csp.solution.SolutionCollection;
import task2.csp.solver.heuristic.Heuristic;

public abstract class CSPSolver implements SolutionFinder {
  final Heuristic heuristic;
  final SquareBoardGame game;
  final SolutionCollection solutionCollection;

  CSPSolver(Heuristic heuristic, SquareBoardGame game, SolutionCollection solutionCollection) {
    this.heuristic = heuristic;
    this.game = game;
    this.solutionCollection = solutionCollection;
  }

  List<Integer> getPotentialValues(Variable var, List<Assigment> assigments) {
    return game.getPotentialValues(var, assigments);
  }

  void addSolution(List<Assigment> assigments, int level) {
    solutionCollection.addSollution(new Solution(assigments, level));
  }

  @Override
  public SolutionCollection getSolutionCollection() {
    return solutionCollection;
  }
}
