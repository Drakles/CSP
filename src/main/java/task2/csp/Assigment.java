package task2.csp;

import java.util.Objects;

public class Assigment implements Comparable<Assigment> {
  private final int value;
  private final Variable variable;

  Assigment(int value, Variable variable) {
    this.value = value;
    this.variable = variable;
  }

  public int getValue() {
    return value;
  }

  public Variable getVariable() {
    return variable;
  }

  @Override
  public String toString() {
    return "assigment{" + variable + " = " + value + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Assigment assigment = (Assigment) o;
    return value == assigment.value && Objects.equals(variable, assigment.variable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, variable);
  }

  @Override
  public int compareTo(Assigment o) {
    return variable.compareTo(o.getVariable());
  }
}
