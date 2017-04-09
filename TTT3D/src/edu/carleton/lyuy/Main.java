package edu.carleton.lyuy;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) {
        TTT3DMover move = new TTT3DMover();

        Set<TTT3DMove> cSet = new HashSet<TTT3DMove>();
        String boardString3 = "X-X- OXX- O--- OO--"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board3 = new TTT3DBoard(boardString3, 'X');
        TTT3DMove forcingMove = new TTT3DMove(0, 2, 2, 'X');
        cSet.add(forcingMove);
        Set<TTT3DMove> forcingMovesC = new HashSet<TTT3DMove>(move.forcingMoves(board3));
        System.out.println(move.forcingMoves(board3).size());
        //assertEquals(cSet, forcingMovesC,"There should be only 1 forcing move in board3");

    }
}
