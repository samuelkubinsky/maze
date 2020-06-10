package io.frinx.maze;

public enum Node {

    START('S'),
    TARGET('X'),
    FREE('.'),
    BLOCKED('#');

    private final char c;

    Node(char c) {
        this.c = c;
    }

    public char getChar() {
        return c;
    }

}
