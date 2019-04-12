package task2.boardgame;

import java.util.List;
import task2.csp.Assigment;
import task2.csp.Variable;

public class SkyCrapper extends SquareSquareBoardGameImpl {

  public SkyCrapper(int size, List<Assigment> initialAssigment) {
    super(size, initialAssigment);
  }

  @Override
  public boolean isAssigmentCorrect(Variable var, Integer value, List<Assigment> assigments) {
    return false;
  }

  @Override
  public boolean isLastAssigmentCorrect(List<Assigment> assigments) {
    return false;
  }

  @Override
  public List<Integer> getPotentialValues(Variable variable, List<Assigment> assigments) {
    return null;
  }

  @Override
  public List<Variable[]> getConstraints() {
    return null;
  }

  @Override
  public boolean isOver(List<Assigment> assigments) {
    return false;
  }

  @Override
  public String getName() {
    return null;
  }
}
