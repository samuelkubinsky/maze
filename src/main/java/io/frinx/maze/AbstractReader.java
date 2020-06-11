package io.frinx.maze;

public abstract class AbstractReader {

    private Maze maze;

    public void findPath() {
        if (maze.containsInvalidChars()) {
            System.out.println("Maze map contains invalid characters");
            System.exit(3);
        }

        if (!maze.containsStartAndTarget()) {
            System.out.println("Maze map does not contain START (S) or TARGET (X)");
            System.exit(4);
        }

        BfsSolver solver = new BfsSolver();
        Coordinate target = solver.solve(maze);

        if (target != null) {
            solver.printSteps(target);
        } else {
            System.out.println("There is no available path");
            System.exit(5);
        }
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

}
