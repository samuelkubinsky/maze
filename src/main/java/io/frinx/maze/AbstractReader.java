package io.frinx.maze;

public abstract class AbstractReader {

    private Maze maze;

    public void findPath() {
        if (!maze.isGridRectangle()) {
            System.out.println("Maze is not rectangular grid");
            System.exit(2);
        }

        if (maze.containsInvalidChars()) {
            System.out.println("Maze map contains invalid characters");
            System.exit(3);
        }

        if (!maze.containsStartAndTarget()) {
            System.out.println("Maze map does not contain START 'S' or TARGET 'X'");
            System.exit(4);
        }

        if (maze.containsMoreStartsOrTargets()) {
            System.out.println("Maze map contains more STARTS 'S' or TARGETS 'X'");
            System.exit(5);
        }

        BfsSolver solver = new BfsSolver();
        System.out.println(solver.solve(maze));
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

}
