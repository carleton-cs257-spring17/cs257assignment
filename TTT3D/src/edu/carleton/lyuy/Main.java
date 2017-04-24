package edu.carleton.lyuy;
import java.util.*;
/**
 * You can use comment line to choose actions and boards. The first argument is the action,
 * and the second is the board file.
 * @author Yanhan Lyu, Lucy Wu
 */
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
                for (int i =0; i < moveList.size(); i++){
                    board.setValueInSquare(moveList.get(i).level, moveList.get(i).row, moveList.get(i).column, '*');
                }
            }
            board.printBoard();
        } else if (action.equals("win")) {
            moveList = mover.winningMoves(board);
            if (!moveList.isEmpty()) {
                for (int i =0; i < moveList.size(); i++){
                    board.setValueInSquare(moveList.get(i).level, moveList.get(i).row, moveList.get(i).column, '*');
                }
            }
            board.printBoard();
        } else if (action.equals("force")) {
            moveList = mover.forcingMoves(board);
            if (!moveList.isEmpty()) {
                for (int i =0; i < moveList.size(); i++){
                    board.setValueInSquare(moveList.get(i).level, moveList.get(i).row, moveList.get(i).column, '*');
                }
            }
            board.printBoard();
        }else if (action.equals("best")) {
            moveList.add(mover.bestMove(board));
            if (!moveList.isEmpty()) {
                board.setValueInSquare(moveList.get(0).level, moveList.get(0).row, moveList.get(0).column, '*');
            }
            board.printBoard();
        } else {
            System.out.print("Invalid action. No board printed. Please type the action you want to take and the board file");
        }
    }
}
