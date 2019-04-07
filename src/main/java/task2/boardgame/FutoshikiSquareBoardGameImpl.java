package task2.boardgame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import task2.csp.Assigment;
import task2.csp.Domain;
import task2.csp.Variable;

public class FutoshikiSquareBoardGameImpl extends SquareSquareBoardGameImpl {

  private final Domain domain;
  /*
  Describe constraints between fields of board, where every array in first array dimension consist of 2 Variable objects
  where first one has to has lower value than second one
   */
  private final Variable[][] constraints;

  public FutoshikiSquareBoardGameImpl(
      int size, List<Assigment> initialAssigment, Variable[][] constraints) {
    super(size, initialAssigment);
    this.constraints = constraints;
    this.domain = new Domain(size);
  }

  @Override
  public boolean isAssigmentCorrect(Variable var, Integer value, List<Assigment> assigments) {
    // first check if this value is already used in row or column
    for (Assigment assigment : assigments) {
      Variable assigmentVariable = assigment.getVariable();
      if (value == assigment.getValue()
          && (assigmentVariable.getColumnIndex() == var.getColumnIndex()
              || assigmentVariable.getRowIndex() == var.getRowIndex())) {
        return false;
      }
    }

    // then check the constraints
    for (Variable[] relation : constraints) {
      Variable lower = relation[0];
      Variable greater = relation[1];

      for (Assigment assigment : assigments) {
        if (assigment.getVariable().equals(lower) && var.equals(greater)) {
          if (assigment.getValue() > value) {
            return false;
          }
        } else if (assigment.getVariable().equals(greater) && var.equals(lower)) {
          if (assigment.getValue() < value) {
            return false;
          }
        }
      }
    }
    return true;
  }

  @Override
  public List<Integer> getPotentialValues(Variable variable, List<Assigment> assigments) {
    List<Integer> result = new LinkedList<>();
    for (Integer value : domain.getDomainValues()) {
      if (isAssigmentCorrect(variable, value, assigments)) {
        result.add(value);
      }
    }
    return result;
  }

  @Override
  public Domain getDomain() {
    return domain;
  }

  @Override
  public Variable[][] getConstraints() {
    return constraints;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("FutoshikiSquareBoardGameImpl{ ");

    sb.append(" size: ").append(size);

    sb.append(",\n initial assigments: [");
    for (Assigment singleRow : initialAssigment) {
      sb.append(singleRow);
    }
    sb.append("]");

    sb.append(",\n constraints: [");
    for (Variable[] singleRel : constraints) {
      sb.append(Arrays.toString(singleRel));
    }
    sb.append("]");
    sb.append("}");

    return sb.toString();
  }
}
