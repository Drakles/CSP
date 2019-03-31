package task2.csp.solver;

import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solver.strategy.Heuristic;

import java.util.LinkedList;
import java.util.List;

public abstract class CSPSolver {
    List<Assigment> assigments;
    List<Variable> variables;
    final Heuristic heuristic;
    final SquareBoardGame game;

    public CSPSolver(List<Variable> variables, Heuristic heuristic, SquareBoardGame game) {
        this.heuristic = heuristic;
        this.variables = variables;
        this.game = game;
        this.assigments = new LinkedList<>();
    }

    public List<Assigment> getAssigments() {
        return assigments;
    }

}
