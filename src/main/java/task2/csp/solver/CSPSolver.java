package task2.csp.solver;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solution.Solution;
import task2.csp.solution.SolutionCollection;
import task2.csp.solver.heuristic.Heuristic;

public abstract class CSPSolver {
  final Heuristic heuristic;
  final SquareBoardGame game;
  private final Map<Variable, Integer> usedAssigments;
  final SolutionCollection solutionCollection;

  CSPSolver(Heuristic heuristic, SquareBoardGame game, SolutionCollection solutionCollection) {
    this.heuristic = heuristic;
    this.game = game;
    this.solutionCollection = solutionCollection;
    usedAssigments = new ConcurrentHashMap<>();
  }

  List<Integer> getPotentialValues(Variable var, List<Assigment> assigments) {
    return game.getPotentialValues(var, assigments)
        .parallelStream()
        .filter(v -> !(usedAssigments.containsKey(var) && usedAssigments.get(var).equals(v)))
        .collect(Collectors.toList());
  }

  void addSolution(List<Assigment> assigments, int level) {
    solutionCollection.addSollution(new Solution(assigments, level));
    assigments
        .parallelStream()
        .forEach(a -> usedAssigments.putIfAbsent(a.getVariable(), a.getValue()));
  }

  public SolutionCollection getSolutionCollection() {
    return solutionCollection;
  }
}
