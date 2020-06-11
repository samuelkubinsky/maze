package io.frinx.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BfsSolverTest {

    private char[][] solvableGrid = {
            {'.', '.', '.', '.', '.', '#', '.', '.', '.'},
            {'.', '.', '.', '#', '.', '.', 'X', '.', '.'},
            {'.', '.', '.', '#', '.', '.', '.', '.', '.'},
            {'.', 'S', '.', '.', '#', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
    };

    private char[][] unsolvableGrid = {
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', '#', '.', '.', '.'},
            {'.', '#', 'X', '#', '.', '.'},
            {'.', '.', '#', '.', '.', '.'},
            {'.', '.', '.', '.', 'S', '.'},
            {'.', '.', '.', '.', '.', '.'}
    };

    private Maze maze;
    private final BfsSolver solver = new BfsSolver();

    @Test
    void solveSolvable() {
        maze = new Maze(solvableGrid);
        assertEquals("u,u,u,r,r,r,d,r,r", solver.solve(maze));
    }

    @Test
    void solveUnsolvable() {
        maze = new Maze(unsolvableGrid);
        assertEquals("There is no available path", solver.solve(maze));
    }

}