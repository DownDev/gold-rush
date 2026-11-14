package edu.io;

import java.util.Objects;

public final class Board {
    public final int size;
    private final Token[][] grid;

    public Board(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Board size must be at least 1.");
        }

        this.size = size;
        this.grid = new Token[size][size];
        clean();
    }

    public Board() {
        this(8);
    }

    public void clean() {
        Token emptyToken = new Token("・");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = emptyToken;
            }
        }
    }

    private void validateCoordinates(int col, int row) {
        if (row < 0 || row >= size) {
            throw new IllegalArgumentException("Row must be less than size.");
        }
        if (col < 0 || col >= size) {
            throw new IllegalArgumentException("Column must be less than size.");
        }
    }

    public void placeToken(int col, int row, Token token) {
        validateCoordinates(col, row);

        Objects.requireNonNull(token, "Token cannot be null.");

        grid[row][col] = token;
    }

    public Token peekToken(int col, int row) {
        validateCoordinates(col, row);

        return grid[row][col];
    }

    public void display() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
    }
}
