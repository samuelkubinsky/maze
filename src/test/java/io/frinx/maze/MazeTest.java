package io.frinx.maze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MazeTest {

    private char[][] notRectangularGrid = {
            {'.', '.', '.', '.', 'S', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'},
            {'.', 'X', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.'}
    };

    private char[][] invalidCharsGrid = {
            {'.', '.', '.', '.', '.', '.'},
            {'.', 'X', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', '@', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.'},
            {'.', 'S', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.'}
    };

    private char[][] noStartsGrid = {
            {'.', '.', '.'},
            {'.', '.', '#'},
            {'.', '.', '.'},
            {'.', '#', 'X'}
    };

    private char[][] moreTargetsGrid = {
            {'S', '.', '.'},
            {'.', '.', '#'},
            {'.', 'X', '.'},
            {'.', '#', 'X'}
    };

    private Maze maze;

    @Test
    void isGridRectangle() {
        maze = new Maze(notRectangularGrid);
        assertFalse(maze.isGridRectangle());
    }

    @Test
    void containsInvalidChars() {
        maze = new Maze(invalidCharsGrid);
        assertTrue(maze.containsInvalidChars());
    }

    @Test
    void containsStartAndTarget() {
        maze = new Maze(noStartsGrid);
        assertFalse(maze.containsStartAndTarget());
    }

    @Test
    void containsMoreStartsOrTargets() {
        maze = new Maze(moreTargetsGrid);
        assertTrue(maze.containsMoreStartsOrTargets());
    }

}
