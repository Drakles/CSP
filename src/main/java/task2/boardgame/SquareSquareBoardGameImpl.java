package task2.boardgame;

import task2.csp.Domain;

public abstract class SquareSquareBoardGameImpl implements SquareBoardGame {
  final int size;
  final Domain domain;

  public SquareSquareBoardGameImpl(int size) {
    this.size = size;
    this.domain = new Domain(size);
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public String toString() {
    return "SquareSquareBoardGameImpl{" + "size=" + size + '}';
  }

  @Override
  public Domain getDomain() {
    return domain;
  }
}
