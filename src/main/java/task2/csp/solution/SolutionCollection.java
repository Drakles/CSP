package task2.csp.solution;

import java.util.LinkedList;
import java.util.List;
import task2.boardgame.SquareBoardGame;

public class SolutionCollection {
  private final List<Solution> sollutions;
  private final String heuristic;
  private final String solveMethod;
  private final SquareBoardGame game;
  private final String file;

  public SolutionCollection(
      String heuristic, String solveMethod, SquareBoardGame game, String file) {
    this.sollutions = new LinkedList<>();
    this.heuristic = heuristic;
    this.solveMethod = solveMethod;
    this.game = game;
    this.file = file;
  }

  public void addSollution(Solution solution) {
    sollutions.add(solution);
  }

  public List<Solution> getSollutions() {
    return sollutions;
  }

  public String getHeuristic() {
    return heuristic;
  }

  public String getSolveMethod() {
    return solveMethod;
  }

  public String getGameName() {
    return game.getName();
  }

  public String getConstraintsToString() {
    return game.getConstraintsToString();
  }

  public String getFile() {
    return file;
  }

  public int getTotalMoves() {
    return !sollutions.isEmpty() ? sollutions.get(sollutions.size() - 1).getMoves() : 0;
  }

  @Override
  public String toString() {
    return "SolutionCollection{"
        + "sollutions="
        + sollutions
        + ", heuristic='"
        + heuristic
        + '\''
        + ", solveMethod='"
        + solveMethod
        + '\''
        + ", game="
        + game
        + ", file='"
        + file
        + '\''
        + '}';
  }
}
