package task2;

import java.util.LinkedList;
import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solver.BackTracking;
import task2.csp.solver.strategy.MinimumRemainingValuesHeuristic;
import task2.loader.Loader;
import task2.out.HTMLFileGenerator;

public class App {
  public static void main(String[] args) {

    SquareBoardGame futoshikiBoardGame = Loader.scanFutoshikiBoard("resources/test_futo_4_0.txt");

    long time = System.currentTimeMillis();
    List<Variable> variables = VariableUtils.getVariables(futoshikiBoardGame);

    BackTracking backTracking =
        new BackTracking(variables, new MinimumRemainingValuesHeuristic(), futoshikiBoardGame);

    List<Assigment> assigments = new LinkedList<>(futoshikiBoardGame.getInitialAssigment());

    backTracking.perform(assigments, variables, 0);

    System.out.println("time: " + (System.currentTimeMillis() - time));
    System.out.println(assigments);

    HTMLFileGenerator.generateHtmlFile(assigments, "out/futo_4_0.html", "futo_4_0");
  }
}
