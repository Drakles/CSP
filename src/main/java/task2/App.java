package task2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import task2.boardgame.SquareBoardGame;
import task2.csp.Variable;
import task2.csp.solution.SolutionCollection;
import task2.csp.solver.ForwardChecking;
import task2.csp.solver.SolutionFinder;
import task2.csp.solver.heuristic.Heuristic;
import task2.csp.solver.heuristic.MinimumRemainingValuesHeuristic;
import task2.loader.Loader;
import task2.out.HTMLFileGenerator;

public class App {
  public static void main(String[] args) {

    String resourceFile = "test_sky_4_2";
    SquareBoardGame game = Loader.scanSkyCrapper("resources/" + resourceFile + ".txt");

    long time = System.currentTimeMillis();
    List<Variable> variables = VariableUtils.getVariables(game);
    Heuristic heuristic = new MinimumRemainingValuesHeuristic();

    SolutionFinder solutionFinder =
        new ForwardChecking(
            heuristic,
            game,
            new SolutionCollection(
                heuristic.toString(),
                ForwardChecking.class.getName(),
                game,
                "out/"
                    + resourceFile
                    + ForwardChecking.class.getName()
                    + "-"
                    + heuristic.getClass().getName()
                    + LocalDateTime.now()
                    + ".html"));

    solutionFinder.run(game.getInitialAssigment(), variables, new AtomicInteger(0));

    System.out.println("time: " + (System.currentTimeMillis() - time));

    HTMLFileGenerator.generateHtmlFile(solutionFinder.getSolutionCollection());
  }
}
