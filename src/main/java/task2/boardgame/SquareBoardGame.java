package task2.boardgame;

import java.util.List;
import task2.csp.Assigment;
import task2.csp.Domain;
import task2.csp.Variable;

public interface SquareBoardGame {

  int getSize();

  boolean isAssigmentCorrect(Variable var, Integer value, List<Assigment> assigments);

  boolean isLastAssigmentCorrect(List<Assigment> assigments);

  List<Integer> getPotentialValues(Variable variable, List<Assigment> assigments);

  Domain getDomain();

  List<Assigment> getInitialAssigment();

  String getConstraintsToString();

  int numberOfOccurencesVariableInConstraints(Variable var);

  boolean isOver(List<Assigment> assigments);

  String getName();
}
