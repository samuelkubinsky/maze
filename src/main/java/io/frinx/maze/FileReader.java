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

            setMaze(new Maze(array));
            findPath();
        } catch (IOException exception) {
            System.out.println("Map file with name '" + fileName + "' was not found");
            System.exit(1);
        }
    }

}
