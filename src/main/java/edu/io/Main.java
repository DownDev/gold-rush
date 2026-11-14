package edu.io;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        board.placeToken(2, 3, new Token("💰︎"));
        board.placeToken(0, 0, new Token("웃"));

        board.display();
    }
}
