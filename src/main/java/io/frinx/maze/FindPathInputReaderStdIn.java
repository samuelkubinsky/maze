package io.frinx.maze;

import java.util.LinkedList;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {

    private final Scanner scanner = new Scanner(System.in);
    private final LinkedList<String> strings = new LinkedList<>();
    private char[][] array;

    public FindPathInputReaderStdIn() {
        getInput();

        if (!isRectangularGrid(strings)) {
            System.out.println("Maze is not rectangular grid");
            System.exit(2);
        }

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

    private boolean isRectangularGrid(LinkedList<String> list) {
        int rowCount = list.size();
        int rowLength = list.getFirst().length();

        for (int row = 0; row < rowCount; row++) {
            if (list.get(row).length() != rowLength) {
                return false;
            }
        }

        return true;
    }

    private void processInput() {
        int rowCount = strings.size();
        int columnCount = strings.getFirst().length();
        array = new char[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            String line = strings.remove();
            for (int column = 0; column < columnCount; column++) {
                array[row][column] = line.charAt(column);
            }
        }
    }

}
