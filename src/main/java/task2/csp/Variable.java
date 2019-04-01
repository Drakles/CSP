package task2.csp;

import java.util.Objects;

public class Variable {
    private final int columnIndex;
    private final int rowIndex;

    public Variable(int columnIndex, int rowIndex) {
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public boolean isCoordEquals(int columnIndex,int rowIndex){
        return this.columnIndex == columnIndex && this.rowIndex == rowIndex;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "columnIndex=" + columnIndex +
                ", rowIndex=" + rowIndex +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return columnIndex == variable.columnIndex &&
                rowIndex == variable.rowIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnIndex, rowIndex);
    }
}
