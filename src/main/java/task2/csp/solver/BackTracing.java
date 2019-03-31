package task2.csp.solver;

import task2.csp.Domain;
import task2.csp.Variable;
import task2.csp.solver.strategy.Heuristic;

import java.util.List;

public class BackTracing extends CSPSolver {


    public BackTracing(Domain domain, List<Variable> variables, Heuristic heuristic) {
        super(domain, variables, heuristic);
    }

    public void perform() {
        Variable var = heuristic.choose(variables);

        for (Integer value : domain.getDomainValues()) {

        }
    }
}
