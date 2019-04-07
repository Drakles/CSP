package task2;

import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Variable;
import task2.csp.solution.SolutionCollection;
import task2.csp.solver.BackTracking;
import task2.csp.solver.heuristic.Heuristic;
import task2.csp.solver.heuristic.MinimumRemainingValuesHeuristic;
import task2.loader.Loader;
import task2.out.HTMLFileGenerator;

public class App {
  public static void main(String[] args) {

    SquareBoardGame futoshikiBoardGame = Loader.scanFutoshikiBoard("resources/test_futo_4_0.txt");

    long time = System.currentTimeMillis();
    List<Variable> variables = VariableUtils.getVariables(futoshikiBoardGame);
    Heuristic heuristic = new MinimumRemainingValuesHeuristic();

    BackTracking backTracking =
        new BackTracking(
            heuristic,
            futoshikiBoardGame,
            new SolutionCollection(
                heuristic.toString(),
                BackTracking.class.getName(),
                futoshikiBoardGame,
                "out/futo_4_0.html"));

    backTracking.run(futoshikiBoardGame.getInitialAssigment(), variables, 0);

    System.out.println("time: " + (System.currentTimeMillis() - time));

    HTMLFileGenerator.generateHtmlFile(backTracking.getSolutionCollection());
  }
}
