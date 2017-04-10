package edu.carleton.lyuy;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String action = args[0];
        String file = args[1];
        TTT3DBoard board = new TTT3DBoard();
        TTT3DMover mover = new TTT3DMover();
        List<TTT3DMove> moveList = new ArrayList<TTT3DMove>();
        board.loadFromFile(file);
        if (action.equals("block")) {
            moveList = mover.blockingMoves(board);
            if (!moveList.isEmpty()) {
                board.setValueInSquare(moveList.get(0).level, moveList.get(0).row, moveList.get(0).column, '*');
            }
            board.printBoard();
        } else if (action.equals("win")) {
            moveList = mover.winningMoves(board);
            if (!moveList.isEmpty()) {
                board.setValueInSquare(moveList.get(0).level, moveList.get(0).row, moveList.get(0).column, '*');
            }
            board.printBoard();
        } else if (action.equals("force")) {
            moveList = mover.forcingMoves(board);
            if (!moveList.isEmpty()) {
                board.setValueInSquare(moveList.get(0).level, moveList.get(0).row, moveList.get(0).column, '*');
            }
            board.printBoard();
        }else if (action.equals("best")) {
            moveList.add(mover.bestMove(board));
            if (!moveList.isEmpty()) {
                board.setValueInSquare(moveList.get(0).level, moveList.get(0).row, moveList.get(0).column, '*');
            }
            board.printBoard();
        } else {
            System.out.print("Invalid action. No board printed");
        }


    }
}
