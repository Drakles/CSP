package task2.csp.solver;

import task2.boardgame.BoardGame;
import task2.csp.Domain;
import task2.csp.solver.strategy.Heuristic;

public class BackTracing extends CSPSolver {

    public BackTracing(Domain domain, BoardGame game, Heuristic heuristic) {
        super(domain, game, heuristic);
    }
}
