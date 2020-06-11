package io.frinx.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractFindPathInputReader {

    private Maze maze;

    public void findPath() {
        if (!maze.containsStartAndTarget()) {
            System.out.println("Maze map does not contain START (S) or TARGET (X)");
            return;
        }

        if (maze.containsInvalidChars()) {
            System.out.println("Maze map contains invalid characters");
            return;
        }

        solve();
    }

    public void solve() {
        LinkedList<Coordinate> toVisit = new LinkedList<>();

        Coordinate start = maze.getStart();
        toVisit.add(start);

        while (!toVisit.isEmpty()) {
            Coordinate current = toVisit.remove();

            int row = current.getRow();
            int column = current.getColumn();
            System.out.println(row + " " + column);

            if (!maze.isLocationValid(row, column) || maze.isVisited(row, column)) {
                continue;
            }

            if (maze.isNode(Node.BLOCKED, row, column)) {
                continue;
            }

            if (maze.isNode(Node.TARGET, row, column)) {
                printSteps(current);
                return;
            }

            for (Direction direction: Direction.values()) {
                int newRow = row + direction.getDy();
                int newColumn = column + direction.getDx();
                Coordinate coordinate = new Coordinate(newRow, newColumn, current);
                toVisit.add(coordinate);
                maze.setAsVisited(row, column);
            }
        }
    }

    private List<Coordinate> backtrackPath(Coordinate target) {
        List<Coordinate> path = new ArrayList<>();

        Coordinate current = target;

        while (current != null) {
            path.add(current);
            current = current.getParent();
        }

        return path;
    }

    public void printSteps(Coordinate target) {
        List<Coordinate> path = backtrackPath(target);
        Collections.reverse(path);

        for (int index = 0; index < path.size() - 1; index++) {
            Coordinate current = path.get(index);
            Coordinate next = path.get(index + 1);

            if (index != 0) {
                System.out.print(",");
            }

            if (current.getRow() - 1 == next.getRow()) { // up
                System.out.print("u");
            } else if (current.getColumn() + 1 == next.getColumn()) { // right
                System.out.print("r");
            } else if (current.getRow() + 1 == next.getRow()) { // down
                System.out.print("d");
            } else { // left
                System.out.print("l");
            }
        }
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

}
