package task2.boardgame;

import task2.csp.Assigment;
import task2.csp.Domain;
import task2.csp.Variable;

import java.util.Collection;
import java.util.List;

public interface SquareBoardGame {

    int getSize();

    boolean isAssigmentCorrect(Variable var, Integer value, List<Assigment> assigments);

    List<Integer> getPotentialValues(Variable variable,List<Assigment> assigments);

    Domain getDomain();

    List<Assigment> getInitialAssigment();
}
