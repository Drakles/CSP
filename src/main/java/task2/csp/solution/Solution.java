package task2.csp.solution;

import java.util.List;
import task2.csp.Assigment;

public class Solution {
  private final List<Assigment> assigments;
  private final int moves;

  public Solution(List<Assigment> assigments, int moves) {
    this.assigments = assigments;
    this.moves = moves;
  }

  public int getMoves() {
    return moves;
  }

  public List<Assigment> getAssigments() {
    return assigments;
  }
}
