package io.frinx.maze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BfsSolver {

    public String solve(Maze maze) {
        LinkedList<Coordinate> toVisit = new LinkedList<>();

        Coordinate start = maze.getStart();
        toVisit.add(start);

        while (!toVisit.isEmpty()) {
            Coordinate current = toVisit.remove();

            int row = current.getRow();
            int column = current.getColumn();

            if (!maze.isLocationValid(row, column) || maze.isVisited(row, column)) {
                continue;
            }

            if (maze.ifNodeIs(Node.BLOCKED, row, column)) {
                continue;
            }

            if (maze.ifNodeIs(Node.TARGET, row, column)) {
                List<Coordinate> path = backtrackPath(current);
                Collections.reverse(path);
                return getSteps(path);
            }

            for (Direction direction: Direction.values()) {
                int newRow = row + direction.getDy();
                int newColumn = column + direction.getDx();
                Coordinate coordinate = new Coordinate(newRow, newColumn, current);
                toVisit.add(coordinate);
                maze.setAsVisited(row, column);
            }
        }

        return "There is no available path";
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

    public String getSteps(List<Coordinate> path) {
        StringBuilder sb = new StringBuilder();

        for (int index = 0; index < path.size() - 1; index++) {
            Coordinate current = path.get(index);
            Coordinate next = path.get(index + 1);

            if (index != 0) {
                sb.append(",");
            }

            if (current.getRow() - 1 == next.getRow()) { // up
                sb.append("u");
            } else if (current.getColumn() + 1 == next.getColumn()) { // right
                sb.append("r");
            } else if (current.getRow() + 1 == next.getRow()) { // down
                sb.append("d");
            } else { // left
                sb.append("l");
            }
        }

        return sb.toString();
    }

}
