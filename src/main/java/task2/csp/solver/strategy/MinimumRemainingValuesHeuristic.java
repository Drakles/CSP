package task2.csp.solver.strategy;

import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;

import java.util.List;

public class MinimumRemainingValuesHeuristic implements Heuristic {

    @Override
    public Variable choose(List<Variable> variableList, List<Assigment> assigments, SquareBoardGame game) {
        Variable chosen = null;
        if (!variableList.isEmpty()) {
            chosen = variableList.get(0);
            int minPotentialValues = game.getPotentialValues(chosen,assigments).size();
            for (Variable variable : variableList) {
                if (game.getPotentialValues(variable,assigments).size() < minPotentialValues) {
                    chosen = variable;
                }
            }
        }
        return chosen;
    }
}
