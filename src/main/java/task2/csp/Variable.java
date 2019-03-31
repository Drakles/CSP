package task2.csp;

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
}
