package io.frinx.maze;

public class Coordinate {

    private int row;
    private int column;
    private Coordinate parent;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
        this.parent = null;
    }

    public Coordinate(int row, int column, Coordinate parent) {
        this.row = row;
        this.column = column;
        this.parent = parent;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Coordinate getParent() {
        return parent;
    }

}