package task2.csp.solver;

import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solver.strategy.Heuristic;

import java.util.List;

import static task2.csp.AssigmentFactory.createAssigment;

public class BackTracking extends CSPSolver {

    private static final int SUCCES = 1;
    private static final int FAIL = 0;

    public BackTracking(List<Variable> variables, Heuristic heuristic, SquareBoardGame game) {
        super(variables, heuristic, game);
    }

    public int perform(List<Assigment> assigments, List<Variable> variables, int level) {
        if (assigments.size() == game.getSize() * game.getSize()) {
            return SUCCES;
        }

        Variable var = heuristic.choose(variables, assigments, game);
        variables.remove(var);

        for (Integer value : game.getPotentialValues(var, assigments)) {
            Assigment assigment = createAssigment(value, var);
            assigments.add(assigment);
            int result = perform(assigments, variables, ++level);
            if (result != FAIL) {
                return result;
            }
            assigments.remove(assigment);
        }
        variables.add(var);
        return FAIL;
    }
}
