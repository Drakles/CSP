package task2.csp;

public class Assigment {
    private final int value;
    private final Variable var;

    public Assigment(int value, Variable var) {
        this.value = value;
        this.var = var;
    }

    public int getValue() {
        return value;
    }

    public Variable getVar() {
        return var;
    }
}
