package io.frinx.maze;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {

    public FindPathInputReaderFile(String fileName) {
        try {
            File file = new File(fileName);
            Path path = file.toPath();

            char[][] array = Files.lines(path)
                    .map(String::toCharArray)
                    .toArray(char[][]::new);

            if (!isRectangularGrid(array)) {
                System.out.println("Maze is not rectangular grid");
                System.exit(2);
            }

            setMaze(new Maze(array));
            findPath();
        } catch (IOException exception) {
            System.out.println("Could not find file " + fileName);
            System.exit(1);
        }
    }

    private boolean isRectangularGrid(char[][] array) {
        int rowCount = array.length;
        int rowLength = array[0].length;

        for (int row = 0; row < rowCount; row++) {
            if (array[row].length != rowLength) {
                return false;
            }
        }

        return true;
    }

}
