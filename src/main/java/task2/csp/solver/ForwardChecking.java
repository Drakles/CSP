package task2.csp.solver;

import task2.boardgame.SquareBoardGame;
import task2.csp.Variable;
import task2.csp.solver.strategy.Heuristic;

import java.util.List;

public class ForwardChecking extends CSPSolver {

    public ForwardChecking(List<Variable> variables, Heuristic heuristic, SquareBoardGame game) {
        super(variables, heuristic, game);
    }
}
