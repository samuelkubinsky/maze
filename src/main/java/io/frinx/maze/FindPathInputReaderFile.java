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

            setMaze(new Maze(array));
            findPath();
        } catch (IOException exception) {
            System.out.println("Could not find file " + fileName);
        }
    }

}
