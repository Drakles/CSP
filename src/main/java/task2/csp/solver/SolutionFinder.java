package task2.csp.solver;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import task2.csp.Assigment;
import task2.csp.Variable;
import task2.csp.solution.SolutionCollection;

public interface SolutionFinder {
  SolutionCollection run(List<Assigment> assigments, List<Variable> variables, AtomicInteger level);

  SolutionCollection getSolutionCollection();
}
