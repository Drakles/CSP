package task2.csp.solver.strategy;

import task2.csp.Variable;

import java.util.List;

public interface Heuristic {
    Variable choose(List<Variable> variableList);
}
