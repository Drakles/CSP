package task2.boardgame;

import java.util.List;
import task2.csp.Assigment;
import task2.csp.Domain;

public abstract class SquareSquareBoardGameImpl implements SquareBoardGame {
  final int size;
  final List<Assigment> initialAssigment;
  final Domain domain;

  public SquareSquareBoardGameImpl(int size, List<Assigment> initialAssigment) {
    this.size = size;
    this.initialAssigment = initialAssigment;
    this.domain = new Domain(size);
  }

  @Override
  public List<Assigment> getInitialAssigment() {
    return initialAssigment;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "SquareSquareBoardGameImpl{"
        + "size="
        + size
        + ", initialAssigment="
        + initialAssigment
        + '}';
  }

  @Override
  public Domain getDomain() {
    return domain;
  }
}
