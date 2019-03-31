package task2.csp.solver;

import task2.boardgame.BoardGame;
import task2.csp.Assigment;
import task2.csp.Domain;
import task2.csp.solver.strategy.Heuristic;

import java.util.LinkedList;
import java.util.List;

public abstract class CSPSolver {
    final Domain domain;
    List<Assigment> assigments;
    final BoardGame game;
    final Heuristic heuristic;

    public CSPSolver(Domain domain, BoardGame game, Heuristic heuristic) {
        this.domain = domain;
        this.game = game;
        this.heuristic = heuristic;
        this.assigments = new LinkedList<>();
    }

    public Domain getDomain() {
        return domain;
    }

    public List<Assigment> getAssigments() {
        return assigments;
    }

    public BoardGame getGame() {
        return game;
    }
}
