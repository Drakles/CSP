package task2;

import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.solver.BackTracking;
import task2.csp.solver.strategy.MinimumRemainingValuesHeuristic;
import task2.loader.Loader;

import java.util.LinkedList;
import java.util.List;


public class App {
    public static void main(String[] args) {

        SquareBoardGame futoshikiBoardGame = Loader.scanFutoshikiBoard("resources/test_futo_7_0.txt");
        System.out.println(futoshikiBoardGame);

        long time = System.currentTimeMillis();
        BackTracking backTracking = new BackTracking(VariableUtils.getVariables(futoshikiBoardGame),
                new MinimumRemainingValuesHeuristic(), futoshikiBoardGame);

        List<Assigment> initialAssigmentCopy = new LinkedList<>(futoshikiBoardGame.getInitialAssigment());

        backTracking.perform(initialAssigmentCopy, VariableUtils.getVariables(futoshikiBoardGame), 0);

        System.out.println("time: " + (System.currentTimeMillis() - time));
        System.out.println(initialAssigmentCopy);


//        without flyweight factory 79184
//        with 78058
    }
}
