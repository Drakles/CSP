package task2.csp.solver;

import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Domain;
import task2.csp.Variable;
import task2.csp.solver.strategy.Heuristic;

import java.util.List;

public class BackTracking extends CSPSolver {


    public BackTracking(List<Variable> variables, Heuristic heuristic, SquareBoardGame game) {
        super(variables, heuristic, game);
    }

    public Assigment perform(List<Assigment> assigments, List<Variable> variables) {
        if (variables.isEmpty()) {
            return null;
        }

        Variable var = heuristic.choose(variables, assigments, game);
        variables.remove(var);

        for (Integer value : game.getDomain().getDomainValues()) {
            if (game.isAssigmentCorrect(var, value, assigments)) {
                Assigment assigment = new Assigment(value, var);
                assigments.add(assigment);
                Assigment result = perform(assigments, variables);
                if (result != null) {
                    return result;
                }
                assigments.remove(assigment);
            }
        }
        return null;
    }
}
