package task2.csp.solver.heuristic;

import java.util.List;
import task2.boardgame.SquareBoardGame;
import task2.csp.Assigment;
import task2.csp.Variable;

public interface Heuristic {
  Variable choose(List<Variable> variableList, List<Assigment> assigments, SquareBoardGame game);
}
