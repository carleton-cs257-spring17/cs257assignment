package edu.carleton.lyuy;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by yanhanlyu on 01/04/2017.
 */
class TTT3DMoverTest {
    TTT3DMover move = new TTT3DMover();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        //What to do???
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        // What to do ????
    }

    @org.junit.jupiter.api.Test
    void winningMoves() {
        // We always set X to be the next mover to make test easier
        // case1: no winning move for X;
        List<TTT3DMove> emptyList = new ArrayList<TTT3DMove>();
        String boardString1 = "XOXO ---- ---- ----"
                + "X-OO -X-- ---- ----"
                + "OX-- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board1 = new TTT3DBoard(boardString1);
        assertArrayEquals("There should be no winning moves", emptyList, move.winningMoves(board1));

        String boardString2 = "XXXO ---- ---- ----"
                + "X--- -O-O -O-- ----"
                + "O--- ---- ---- ----"
                + "X--- ---- ---- ----";
        TTT3DBoard board2 = new TTT3DBoard(boardString2);
        assertArrayEquals("There should be no winning moves", emptyList, move.winningMoves(board2));
        // case2: 1 winning move for X;
        // a: winning move is on the same level with other 3 Xs
        List<TTT3DMove> aList = new ArrayList<TTT3DMove>();
        String boardString3 = "XOOO X--- X--- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board3 = new TTT3DBoard(boardString2);
        TTT3DMove winningMove = new TTT3DMove(0, 0, 3, 'X');
        aList.add(winningMove);
        assertArrayEquals("There should be only 1 winning move", aList, move.winningMoves(board3));
        // b: winning move is not on the same level with other 3 X
        List<TTT3DMove> bList = new ArrayList<TTT3DMove>();
        String boardString4 = "X--O O--- O--- ----"
                + "X--- ---- ---- ----"
                + "---- ---- ---- ----"
                + "X--- ---- ---- ----";
        TTT3DBoard board4 = new TTT3DBoard(boardString4);
        TTT3DMove winningMove1 = new TTT3DMove(0, 2, 0, 'X');
        aList.add(winningMove1);
        assertArrayEquals("There should be only 1 winning move", bList, move.winningMoves(board4));
        // case3: various winning moves for X;
        // c: winning moves are on the same level with the other 3 Xs;
        List<TTT3DMove> cList = new ArrayList<TTT3DMove>();
        String boardString5 = "XX-X X--- -O-- X---"
                + "O--- ---- ---- ----"
                + "---- ---- -O-- ----"
                + "O--- ---- ---- -O--";
        TTT3DBoard board5 = new TTT3DBoard(boardString5);
        TTT3DMove winningMoveC1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove winningMoveC2 = new TTT3DMove(0, 3, 0, 'X');
        cList.add(winningMoveC1);
        cList.add(winningMoveC2);
        assertArrayEquals("There should be only 2 winning moves", cList, move.winningMoves(board5));
        // d: winning moves are not on the same level with the other 3 Xs;
        List<TTT3DMove> dList = new ArrayList<TTT3DMove>();
        String boardString6 = "XO-- -O-- -OO- O---"
                + "X--- -X--- ---- ----"
                + "X--- ---- --X- ----"
                + "---- ---- ---- -----";
        TTT3DBoard board6 = new TTT3DBoard(boardString6);
        TTT3DMove winningMoveD1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove winningMoveD2 = new TTT3DMove(0, 3, 0, 'X');
        cList.add(winningMoveD1);
        cList.add(winningMoveD2);
        assertArrayEquals("There should be only 2 winning moves", dList, move.winningMoves(board6));

    }

    @org.junit.jupiter.api.Test
    void blockingMoves() {
        // We always set X to be the next mover to make test easier
        // case1: no blocking move for X;
        List<TTT3DMove> emptyList = new ArrayList<TTT3DMove>();
        String boardString1 = "OXOX ---- ---- ----"
                + "O-XX -O-- ---- ----"
                + "XO-- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board1 = new TTT3DBoard(boardString1);
        assertArrayEquals("There should be no blocking moves", emptyList, move.blockingMoves(board1));

        String boardString2 = "OOOX ---- ---- ----"
                + "O--- -X-X -X-- ----"
                + "X--- ---- ---- ----"
                + "O--- ---- ---- ----";
        TTT3DBoard board2 = new TTT3DBoard(boardString2);
        assertArrayEquals("There should be no blocking moves", emptyList, move.blockingMoves(board2));
        // case2: 1 blocking move for X;
        // a: blocking move is on the same level with other 3 Os
        List<TTT3DMove> aList = new ArrayList<TTT3DMove>();
        String boardString3 = "OXXX O--- O--- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----"
                + "---- ---- ---- ----";
        TTT3DBoard board3 = new TTT3DBoard(boardString2);
        TTT3DMove blockingMove = new TTT3DMove(0, 0, 3, 'X');
        aList.add(blockingMove);
        assertArrayEquals("There should be only 1 blocking move", aList, move.blockingMoves(board3));
        // b: blocking move is not on the same level with other 3 Os
        List<TTT3DMove> bList = new ArrayList<TTT3DMove>();
        String boardString4 = "O--X X--- X--- ----"
                + "O--- ---- ---- ----"
                + "---- ---- ---- ----"
                + "O--- ---- ---- ----";
        TTT3DBoard board4 = new TTT3DBoard(boardString4);
        TTT3DMove blockingMoveb1 = new TTT3DMove(0, 2, 0, 'X');
        aList.add(blockingMoveb1);
        assertArrayEquals("There should be only 1 blocking move", bList, move.blockingMoves(board4));
        // case3: various blocking moves for X;
        // c: blocking moves are on the same level with the other 3 Os;
        List<TTT3DMove> cList = new ArrayList<TTT3DMove>();
        String boardString5 = "OO-O O--- -X-- O---"
                + "X--- ---- ---- ----"
                + "---- ---- -X-- ----"
                + "X--- ---- ---- -X--";
        TTT3DBoard board5 = new TTT3DBoard(boardString5);
        TTT3DMove blockingMoveC1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove blockingMoveC2 = new TTT3DMove(0, 3, 0, 'X');
        cList.add(blockingMoveC1);
        cList.add(blockingMoveC2);
        assertArrayEquals("There should be 2 blocking moves", cList, move.blockingMoves(board5));
        // d: blocking moves are not on the same level with the other 3 Os;
        List<TTT3DMove> dList = new ArrayList<TTT3DMove>();
        String boardString6 = "OX-- -X-- -XX- X---"
                + "O--- -O--- ---- ----"
                + "O--- ---- --O- ----"
                + "---- ---- ---- -----";
        TTT3DBoard board6 = new TTT3DBoard(boardString6);
        TTT3DMove blockingMoveD1 = new TTT3DMove(0, 0, 2, 'X');
        TTT3DMove blockingMoveD2 = new TTT3DMove(0, 3, 0, 'X');
        dList.add(blockingMoveD1);
        dList.add(blockingMoveD2);
        assertArrayEquals("There should be 2 blocking moves", dList, move.blockingMoves(board6));

    }

    @org.junit.jupiter.api.Test
    void forcingMoves() {
    }

    @org.junit.jupiter.api.Test
    void bestMove() {
    }


}