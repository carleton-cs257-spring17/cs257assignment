package edu.carleton.lyuy;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * Created by yanhanlyu on 01/04/2017.
 */
class TTT3DMoverTest {
    // make TTT3DMover a private variable
    private TTT3DMover move;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        move = new TTT3DMover();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        // Nothing to do
    }

    @org.junit.jupiter.api.Test
    void winningMoves() {
        // We always set X to be the mover to make test easier
        // case1: no winning move for X;
        Set<TTT3DMove> emptySet = new HashSet<TTT3DMove>();
        String boardString1 = "XOXO ---- ---- ----"
                + "X-OO -X-- ---- ----"
                + "OX-- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board1 = new TTT3DBoard(boardString1, 'X');
        Set<TTT3DMove> winningMoves1 = new HashSet<TTT3DMove>(move.winningMoves(board1));
        assertEquals(emptySet, winningMoves1, "There shoud be no winning moves");

        // example 2;
        String boardString2 = "XXXO ---- ---- ----"
                + "X--- -O-O -O-- ----"
                + "O--- ---- ---- ----"
                + "X--- ---- ---- ----";
        TTT3DBoard board2 = new TTT3DBoard(boardString2);
        Set<TTT3DMove> winningMoves2 = new HashSet<TTT3DMove>(move.winningMoves(board2));
        assertEquals(emptySet, winningMoves2,"There should be no winning moves");
        // case2: 1 winning move for X;

        // a: winning move is on the same level with other 3 Xs
        Set<TTT3DMove> aSet = new HashSet<TTT3DMove>();
        String boardString3 = "XOOO X--- X--- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board3 = new TTT3DBoard(boardString2, 'X');
        TTT3DMove winningMove = new TTT3DMove(0, 0, 3, 'X');
        aSet.add(winningMove);
        Set<TTT3DMove> winningMovesA = new HashSet<TTT3DMove>(move.winningMoves(board3));
        assertEquals(aSet, winningMovesA,"There should be only 1 winning move");

        // b: winning move is not on the same level with other 3 X
        Set<TTT3DMove> bSet = new HashSet<TTT3DMove>();
        String boardString4 = "X--O O--- O--- ----"
                + "X--- ---- ---- ----"
                + "---- ---- ---- ----"
                + "X--- ---- ---- ----";
        TTT3DBoard board4 = new TTT3DBoard(boardString4, 'X');
        TTT3DMove winningMove1 = new TTT3DMove(0, 2, 0, 'X');
        bSet.add(winningMove1);
        Set<TTT3DMove> winningMovesB = new HashSet<TTT3DMove>(move.winningMoves(board4));
        assertEquals(bSet, winningMovesB,"There should be only 1 winning move");
        // case3: various winning moves for X;
        // c: winning moves are on the same level with the other 3 Xs;
        Set<TTT3DMove> cSet = new HashSet<TTT3DMove>();
        String boardString5 = "XX-X X--- -O-- X---"
                + "O--- ---- ---- ----"
                + "---- ---- -O-- ----"
                + "O--- ---- ---- -O--";
        TTT3DBoard board5 = new TTT3DBoard(boardString5, 'X');
        TTT3DMove winningMoveC1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove winningMoveC2 = new TTT3DMove(0, 3, 0, 'X');
        cSet.add(winningMoveC1);
        cSet.add(winningMoveC2);
        Set<TTT3DMove> winningMovesC = new HashSet<TTT3DMove>(move.winningMoves(board5));
        assertEquals(cSet, winningMovesC,"There should be 2 winning moves");
        // d: winning moves are not on the same level with the other 3 Xs;
        Set<TTT3DMove> dSet = new HashSet<TTT3DMove>();
        String boardString6 = "XO-- -O-- -OO- O---"
                + "X--- -X--- ---- ----"
                + "X--- ---- --X- ----"
                + "---- ---- ---- -----";
        TTT3DBoard board6 = new TTT3DBoard(boardString6, 'X');
        TTT3DMove winningMoveD1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove winningMoveD2 = new TTT3DMove(0, 3, 0, 'X');
        dSet.add(winningMoveD1);
        dSet.add(winningMoveD2);
        Set<TTT3DMove> winningMovesD = new HashSet<TTT3DMove>(move.winningMoves(board6));
        assertEquals(dSet, winningMovesD,"There should be 2 winning moves");

    }

    @org.junit.jupiter.api.Test
    void blockingMoves() {
        // We always set X to be the next mover to make test easier
        // case1: no blocking move for X;
        Set<TTT3DMove> emptySet = new HashSet<TTT3DMove>();
        String boardString1 = "OXOX ---- ---- ----"
                + "O-XX -O-- ---- ----"
                + "XO-- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board1 = new TTT3DBoard(boardString1, 'X');
        Set<TTT3DMove> blockingMoves1 = new HashSet<TTT3DMove>(move.blockingMoves(board1));
        assertEquals(emptySet, blockingMoves1,"There should be no blocking moves");

        String boardString2 = "OOOX ---- ---- ----"
                + "O--- -X-X -X-- ----"
                + "X--- ---- ---- ----"
                + "O--- ---- ---- ----";
        TTT3DBoard board2 = new TTT3DBoard(boardString2, 'X');
        Set<TTT3DMove> blockingMoves2 = new HashSet<TTT3DMove>(move.blockingMoves(board2));
        assertEquals(emptySet, blockingMoves2, "There should be no blocking moves");
        // case2: 1 blocking move for X;
        // a: blocking move is on the same level with other 3 Os
        Set<TTT3DMove> aSet = new HashSet<TTT3DMove>();
        String boardString3 = "OXXX O--- O--- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board3 = new TTT3DBoard(boardString2, 'X');
        TTT3DMove blockingMove = new TTT3DMove(0, 0, 3, 'X');
        aSet.add(blockingMove);
        Set<TTT3DMove> blockingMovesA = new HashSet<TTT3DMove>(move.blockingMoves(board3));
        assertEquals(aSet, blockingMovesA,"There should be only 1 blocking move");
        // b: blocking move is not on the same level with other 3 Os
        Set<TTT3DMove> bSet = new HashSet<TTT3DMove>();
        String boardString4 = "O--X X--- X--- ----"
                + "O--- ---- ---- ----"
                + "---- ---- ---- ----"
                + "O--- ---- ---- ----";
        TTT3DBoard board4 = new TTT3DBoard(boardString4, 'X');
        TTT3DMove blockingMoveb1 = new TTT3DMove(0, 2, 0, 'X');
        bSet.add(blockingMoveb1);
        Set<TTT3DMove> blockingMovesB = new HashSet<TTT3DMove>(move.blockingMoves(board4));
        assertEquals(bSet, blockingMovesB,"There should be only 1 blocking move");
        // case3: various blocking moves for X;
        // c: blocking moves are on the same level with the other 3 Os;
        Set<TTT3DMove> cSet = new HashSet<TTT3DMove>();
        String boardString5 = "OO-O O--- -X-- O---"
                + "X--- ---- ---- ----"
                + "---- ---- -X-- ----"
                + "X--- ---- ---- -X--";
        TTT3DBoard board5 = new TTT3DBoard(boardString5, 'X');
        TTT3DMove blockingMoveC1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove blockingMoveC2 = new TTT3DMove(0, 3, 0, 'X');
        cSet.add(blockingMoveC1);
        cSet.add(blockingMoveC2);
        Set<TTT3DMove> blockingMovesC = new HashSet<TTT3DMove>(move.blockingMoves(board5));
        assertEquals(cSet, blockingMovesC,"There should be 2 blocking move");
        // d: blocking moves are not on the same level with the other 3 Os;
        List<TTT3DMove> dSet = new ArrayList<TTT3DMove>();
        String boardString6 = "OX-- -X-- -XX- X---"
                + "O--- -O--- ---- ----"
                + "O--- ---- --O- ----"
                + "---- ---- ---- -----";
        TTT3DBoard board6 = new TTT3DBoard(boardString6, 'X');
        TTT3DMove blockingMoveD1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove blockingMoveD2 = new TTT3DMove(0, 3, 0, 'X');
        dSet.add(blockingMoveD1);
        dSet.add(blockingMoveD2);
        Set<TTT3DMove> blockingMovesD = new HashSet<TTT3DMove>(move.blockingMoves(board6));
        assertEquals(dSet, blockingMovesD,"There should be 2 blocking moves");

    }

    @org.junit.jupiter.api.Test
    void forcingMoves() {
    }

    @org.junit.jupiter.api.Test
    void bestMove() {
    }


}