package io.frinx.maze;

import java.util.LinkedList;
import java.util.Scanner;

public class StdInReader extends AbstractReader {

    private final Scanner scanner = new Scanner(System.in);
    private final LinkedList<String> strings = new LinkedList<>();
    private char[][] array;

    public StdInReader() {
        getInput();
        processInput();
        setMaze(new Maze(array));
        findPath();
    }

    private void getInput() {
        String line;

        while (!(line = scanner.nextLine()).isEmpty()) {
            strings.add(line);
        }
    }

    private void processInput() {
        int rowCount = strings.size();
        array = new char[rowCount][];

        for (int row = 0; row < rowCount; row++) {
            String line = strings.remove();
            array[row] = line.toCharArray();
        }
    }

}
