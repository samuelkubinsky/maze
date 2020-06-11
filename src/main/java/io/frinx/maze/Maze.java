package io.frinx.maze;

public class Maze {

    private final char[][] grid;
    private final int rowCount;
    private final int columnCount;
    private final boolean[][] visited;
    private final Coordinate start;
    private final Coordinate target;

    public Maze(char[][] grid) {
        this.grid = grid;
        this.rowCount = grid.length;
        this.columnCount = grid[0].length;
        this.visited = new boolean[rowCount][columnCount];
        this.start = findCharInMaze(Node.START.getChar());
        this.target = findCharInMaze(Node.TARGET.getChar());
    }

    private Coordinate findCharInMaze(char character) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == character) {
                    return new Coordinate(row, column);
                }
            }
        }

        return null;
    }

    public Coordinate getStart() {
        return start;
    }

    public boolean ifNodeIs(Node node, int row, int column) {
        switch (node) {
            case START:
                return (start.getRow() == row) && (start.getColumn() == column);
            case TARGET:
                return (target.getRow() == row) && (target.getColumn() == column);
            case FREE:
                return grid[row][column] == Node.FREE.getChar();
            case BLOCKED:
                return grid[row][column] == Node.BLOCKED.getChar();
            default:
                return false;
        }
    }

    public boolean isVisited(int row, int column) {
        return visited[row][column];
    }

    public void setAsVisited(int row, int column) {
        visited[row][column] = true;
    }

    public boolean isLocationValid(int row, int column) {
        if ((row < 0 || row >= rowCount) || (column < 0 || column >= columnCount)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean containsStartAndTarget() {
        if ((start != null) && (target != null)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean containsInvalidChars() {
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                char current = grid[row][column];
                if ((current != Node.START.getChar()) &&
                    (current != Node.TARGET.getChar()) &&
                    (current != Node.FREE.getChar()) &&
                    (current != Node.BLOCKED.getChar())) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsMoreStartsOrTargets() {
        int starts = 0;
        int targets = 0;

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                char current = grid[row][column];

                if (current == Node.START.getChar()) {
                    starts++;
                } else if (current == Node.TARGET.getChar()) {
                    targets++;
                }
            }
        }

        if (starts > 1 || targets > 1) {
            return true;
        }

        return false;
    }

    public boolean isGridRectangle() {
        for (int row = 0; row < grid.length; row++) {
            if (grid[row].length != grid[0].length) {
                return false;
            }
        }

        return true;
    }

}
