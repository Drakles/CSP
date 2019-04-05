package task2.boardgame;

import java.util.List;
import task2.csp.Assigment;

public abstract class SquareSquareBoardGameImpl implements SquareBoardGame {
  final int size;
  final List<Assigment> initialAssigment;

  public SquareSquareBoardGameImpl(int size, List<Assigment> initialAssigment) {
    this.size = size;
    this.initialAssigment = initialAssigment;
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
}
