package task2.boardgame;

import com.google.common.collect.Lists;
import java.util.*;
import java.util.stream.Collectors;
import task2.csp.Assigment;
import task2.csp.Variable;

public class SkyCrapper extends SquareSquareBoardGameImpl {

  private final Map<Variable, Integer> upConstraints;
  private final Map<Variable, Integer> downConstraints;
  private final Map<Variable, Integer> leftConstraints;
  private final Map<Variable, Integer> rightConstraints;

  public SkyCrapper(
      int size,
      Map<Variable, Integer> upperRow,
      Map<Variable, Integer> downRow,
      Map<Variable, Integer> leftColumn,
      Map<Variable, Integer> rightColumn) {
    super(size);
    this.upConstraints = upperRow;
    this.downConstraints = downRow;
    this.leftConstraints = leftColumn;
    this.rightConstraints = rightColumn;
  }

  @Override
  public boolean isAssigmentCorrect(Variable var, Integer value, List<Assigment> assigments) {
    if (var == null) {
      return false;
    }
    // first check if this value is already used in the same row or column
    for (Assigment assigment : assigments) {
      Variable assigmentVariable = assigment.getVariable();
      if (value == assigment.getValue()
          && (assigmentVariable.getColumnIndex() == var.getColumnIndex()
              || assigmentVariable.getRowIndex() == var.getRowIndex())) {
        return false;
      }
    }

    Assigment assigment = new Assigment(value, var);

    List<Assigment> potentialAssigments = new ArrayList<>(assigments.size() + 1);
    potentialAssigments.addAll(assigments);
    potentialAssigments.add(assigment);

    Collections.sort(potentialAssigments);

    // then check the constraints
    Map<Integer, List<Assigment>> assigmentByRow =
        potentialAssigments.stream()
            .collect(Collectors.groupingBy(a -> a.getVariable().getRowIndex()));

    for (Map.Entry<Integer, List<Assigment>> rowAssigmentsEntry : assigmentByRow.entrySet()) {

      if (rowAssigmentsEntry.getValue().size() == size) {
        if (isConstraintBroken(
            numberOfVisibleSkyCrappers(rowAssigmentsEntry.getValue()),
            leftConstraints.get(
                getVariableByRowAndColumn(0, rowAssigmentsEntry.getKey(), leftConstraints)))) {
          return false;
        }

        if (isConstraintBroken(
            numberOfVisibleSkyCrappers(Lists.reverse(rowAssigmentsEntry.getValue())),
            rightConstraints.get(
                getVariableByRowAndColumn(
                    size - 1, rowAssigmentsEntry.getKey(), rightConstraints)))) {
          return false;
        }
      }
    }

    Map<Integer, List<Assigment>> assigmentByColumn =
        potentialAssigments.stream()
            .collect(Collectors.groupingBy(a -> a.getVariable().getColumnIndex()));

    for (Map.Entry<Integer, List<Assigment>> columnAssigmentsEntry : assigmentByColumn.entrySet()) {

      if (columnAssigmentsEntry.getValue().size() == size) {
        if (isConstraintBroken(
            numberOfVisibleSkyCrappers(columnAssigmentsEntry.getValue()),
            upConstraints.get(
                getVariableByRowAndColumn(columnAssigmentsEntry.getKey(), 0, upConstraints)))) {
          return false;
        }

        if (isConstraintBroken(
            numberOfVisibleSkyCrappers(Lists.reverse(columnAssigmentsEntry.getValue())),
            downConstraints.get(
                getVariableByRowAndColumn(
                    columnAssigmentsEntry.getKey(), size - 1, downConstraints)))) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isConstraintBroken(Integer numberOfVisibleSkyCrappers, Integer constraint) {
    if (constraint != 0) {
      return !constraint.equals(numberOfVisibleSkyCrappers);
    }
    return false;
  }

  private Variable getVariableByRowAndColumn(
      Integer column, Integer row, Map<Variable, Integer> variableIntegerMap) {
    for (Variable varEntry : variableIntegerMap.keySet()) {
      if (varEntry.getRowIndex() == row && varEntry.getColumnIndex() == column) {
        return varEntry;
      }
    }
    return null;
  }

  private Integer numberOfVisibleSkyCrappers(List<Assigment> assigmentInLine) {
    int result = 0;
    if (!assigmentInLine.isEmpty()) {
      int currentHighest = assigmentInLine.get(0).getValue();
      result++;

      for (Assigment assigment : assigmentInLine) {
        if (assigment.getValue() > currentHighest) {
          currentHighest = assigment.getValue();
          result++;
        }
      }
    }
    return result;
  }

  @Override
  public boolean isLastAssigmentCorrect(List<Assigment> assigments) {
    boolean result = true;
    if (!assigments.isEmpty()) {
      Assigment lastAssigment = assigments.remove(assigments.size() - 1);
      result =
          isAssigmentCorrect(lastAssigment.getVariable(), lastAssigment.getValue(), assigments);
      assigments.add(lastAssigment);
    }
    return result;
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
  public List<Assigment> getInitialAssigment() {
    return new ArrayList<>();
  }

  @Override
  public String getConstraintsToString() {
    // TODO
    return null;
  }

  @Override
  public int numberOfOccurencesVariableInConstraints(Variable var) {
    return 4;
  }

  @Override
  public boolean isOver(List<Assigment> assigments) {
    return assigments.size() == size * size;
  }

  @Override
  public String getName() {
    return "SkyCrapper";
  }
}
