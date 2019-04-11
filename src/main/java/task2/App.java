package task2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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

    String resourceFile = "futo_4x4_empty";
    SquareBoardGame futoshikiBoardGame =
        Loader.scanFutoshikiBoard("resources/" + resourceFile + ".txt");

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
                "out/" + resourceFile + LocalDateTime.now() + ".html"));

    backTracking.run(futoshikiBoardGame.getInitialAssigment(), variables, new AtomicInteger(0));

    System.out.println("time: " + (System.currentTimeMillis() - time));

    HTMLFileGenerator.generateHtmlFile(backTracking.getSolutionCollection());
  }
}
