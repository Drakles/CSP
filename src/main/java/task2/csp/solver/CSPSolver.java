package task2.csp.solver;

import task2.csp.Assigment;
import task2.csp.Domain;
import task2.csp.Variable;
import task2.csp.solver.strategy.Heuristic;

import java.util.LinkedList;
import java.util.List;

public abstract class CSPSolver {
    final Domain domain;
    List<Assigment> assigments;
    List<Variable> variables;
    final Heuristic heuristic;

    public CSPSolver(Domain domain,List<Variable> variables, Heuristic heuristic) {
        this.domain = domain;
        this.heuristic = heuristic;
        this.variables = variables;
        this.assigments = new LinkedList<>();
    }

    public Domain getDomain() {
        return domain;
    }

    public List<Assigment> getAssigments() {
        return assigments;
    }

}
