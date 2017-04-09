package edu.carleton.lyuy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String boardString1 = "XX-X X--- -O-- X---"
                + "O--- ---- ---- ----"
                + "---- ---- -O-- ----"
                + "O--- ---- ---- -O--";
        TTT3DBoard board1 = new TTT3DBoard(boardString1, 'X');
        //board1.printBoard();
        //System.out.print(board1.valueInSquare(3));
        TTT3DMover move = new TTT3DMover();

        System.out.print(move.winningMoves(board1).get(0));

    }
}
