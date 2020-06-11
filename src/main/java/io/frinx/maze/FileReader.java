package io.frinx.maze;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader extends AbstractReader {

    public FileReader(String fileName) {
        try {
            File file = new File(fileName);
            Path path = file.toPath();

            char[][] array = Files.lines(path)
                    .map(String::toCharArray)
                    .toArray(char[][]::new);

            if (!isGridRectangle(array)) {
                System.out.println("Maze is not rectangular grid");
                System.exit(2);
            }

            setMaze(new Maze(array));
            findPath();
        } catch (IOException exception) {
            System.out.println("Map file with name '" + fileName + "' was not found");
            System.exit(1);
        }
    }

    private boolean isGridRectangle(char[][] array) {
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
