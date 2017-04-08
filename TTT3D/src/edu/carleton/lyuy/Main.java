package edu.carleton.lyuy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String boardString1 = "XOXO XOXO OXOX OXOX"
                + "OXOX OXOX XOXO XOXO"
                + "OXOX OXOX XOXO XOXO"
                + "XOXO OXXO OXOX X--O";
        TTT3DBoard board1 = new TTT3DBoard(boardString1, 'X');
        board1.printBoard();
    }
}
