package task2.csp;

import java.util.Objects;

public class Assigment {
    private final int value;
    private final Variable var;

    Assigment(int value, Variable var) {
        this.value = value;
        this.var = var;
    }

    public int getValue() {
        return value;
    }

    public Variable getVariable() {
        return var;
    }

    @Override
    public String toString() {
        return "Assigment{" +
                "value=" + value +
                ", var=" + var +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assigment assigment = (Assigment) o;
        return value == assigment.value &&
                Objects.equals(var, assigment.var);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, var);
    }
}
