package task2;

import task2.boardgame.SquareBoardGame;
import task2.csp.Variable;

import java.util.ArrayList;
import java.util.List;

public class VariableUtils {

    public static List<Variable> getVariables(SquareBoardGame squareBoardGame) {
        int boardLength = squareBoardGame.getSize();
        List<Variable> variables = new ArrayList<>(boardLength * boardLength);
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0; j < boardLength; j++) {
                variables.add(new Variable(j, i));
            }
        }
        return variables;
    }
}
