package edu.carleton.lyuy;
import org.omg.CORBA.portable.ValueInputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.*;

/**
 * TTT3DMover's job is to analyze a TTT3DBoard and make choices about what move
 * a player should make next. A TT3DMover object could be used as a key component
 * of the "AI" player in a full-blown 3D tic-tac-toe application.
 * <p>
 * In phase 3 of this assignment, you'll implement the methods stubbed and
 * documented below. In phase 2 (which comes before phase 3, as you might guess),
 * you'll create a JUnit TTT3DMoverTest class with a suitably rich collection of
 * unit tests for the public methods below.
 *
 * @author Jeff Ondich, Yanhan Lyu, Lucy Wu
 * @version 30 March 2017
 */
public class TTT3DMover {
    private HashMap<Set<List<Integer>>, Integer> dict;
    public int combinations[][];
    /**
     * Because we currently have no implementation of TTT3DMover, a default
     * constructor should suffice.
     */
    public TTT3DMover() {
        dict = new HashMap <Set<List<Integer>>, Integer>();
        combinations = new int[76][4];

        //On the same level, horizontally form a line
        combinations[0][0] = 0;
        combinations[0][1] = 1;
        combinations[0][2] = 2;
        combinations[0][3] = 3;

        combinations[1][0] = 4;
        combinations[1][1] = 5;
        combinations[1][2] = 6;
        combinations[1][3] = 7;

        combinations[2][0] = 8;
        combinations[2][1] = 9;
        combinations[2][3] = 10;
        combinations[2][3] = 11;

        combinations[3][0] = 12;
        combinations[3][1] = 13;
        combinations[3][3] = 14;
        combinations[3][3] = 15;

        combinations[2][0] = 16;
        combinations[2][1] = 17;
        combinations[2][2] = 18;
        combinations[2][3] = 19;

        combinations[3][0] = 20;
        combinations[3][1] = 21;
        combinations[3][2] = 22;
        combinations[3][3] = 23;

        combinations[6][0] = 24;
        combinations[6][1] = 25;
        combinations[6][2] = 26;
        combinations[6][3] = 27;

        combinations[7][0] = 28;
        combinations[7][1] = 29;
        combinations[7][2] = 30;
        combinations[7][3] = 31;


        combinations[8][0] = 32;
        combinations[8][1] = 33;
        combinations[8][2] = 34;
        combinations[8][3] = 35;

        combinations[9][0] = 36;
        combinations[9][1] = 37;
        combinations[9][2] = 38;
        combinations[9][3] = 39;

        combinations[10][0] = 40;
        combinations[10][1] = 41;
        combinations[10][2] = 42;
        combinations[10][3] = 43;

        combinations[11][0] = 44;
        combinations[11][1] = 45;
        combinations[11][2] = 46;
        combinations[11][3] = 47;


        combinations[12][0] = 48;
        combinations[12][1] = 49;
        combinations[12][2] = 50;
        combinations[12][3] = 51;

        combinations[13][0] = 52;
        combinations[13][1] = 53;
        combinations[13][2] = 54;
        combinations[13][3] = 55;

        combinations[14][0] = 56;
        combinations[14][1] = 57;
        combinations[14][2] = 58;
        combinations[14][3] = 59;

        combinations[15][0] = 60;
        combinations[15][1] = 61;
        combinations[15][2] = 62;
        combinations[15][3] = 63;

        // on the same level, vertically form a line
        combinations[16][0] = 0;
        combinations[16][1] = 4;
        combinations[16][2] = 8;
        combinations[16][3] = 12;

        combinations[17][0] = 1;
        combinations[17][1] = 5;
        combinations[17][2] = 9;
        combinations[17][3] = 13;

        combinations[18][0] = 2;
        combinations[18][1] = 6;
        combinations[18][2] = 10;
        combinations[18][3] = 14;

        combinations[19][0] = 3;
        combinations[19][1] = 7;
        combinations[19][2] = 11;
        combinations[19][3] = 15;


        combinations[20][0] = 16;
        combinations[20][1] = 20;
        combinations[20][2] = 24;
        combinations[20][3] = 28;

        combinations[21][0] = 17;
        combinations[21][1] = 21;
        combinations[21][2] = 25;
        combinations[21][3] = 29;

        combinations[22][0] = 18;
        combinations[22][1] = 22;
        combinations[22][2] = 26;
        combinations[22][3] = 30;

        combinations[23][0] = 19;
        combinations[23][1] = 23;
        combinations[23][2] = 27;
        combinations[23][3] = 31;


        combinations[24][0] = 32;
        combinations[24][1] = 36;
        combinations[24][2] = 40;
        combinations[24][3] = 44;

        combinations[25][0] = 33;
        combinations[25][1] = 37;
        combinations[25][2] = 41;
        combinations[25][3] = 45;

        combinations[26][0] = 34;
        combinations[26][1] = 38;
        combinations[26][2] = 42;
        combinations[26][3] = 46;

        combinations[27][0] = 35;
        combinations[27][1] = 39;
        combinations[27][2] = 43;
        combinations[27][3] = 47;

        combinations[28][0] = 48;
        combinations[28][1] = 52;
        combinations[28][2] = 56;
        combinations[28][3] = 60;

        combinations[29][0] = 49;
        combinations[29][1] = 53;
        combinations[29][2] = 57;
        combinations[29][3] = 61;

        combinations[30][0] = 50;
        combinations[30][1] = 54;
        combinations[30][2] = 58;
        combinations[30][3] = 62;

        combinations[31][0] = 51;
        combinations[31][1] = 55;
        combinations[31][2] = 59;
        combinations[31][3] = 63;

        // on the same level, diaganolly form a line
        combinations[32][0] = 0;
        combinations[32][1] = 5;
        combinations[32][2] = 10;
        combinations[32][3] = 15;

        combinations[33][0] = 16;
        combinations[33][1] = 21;
        combinations[33][2] = 26;
        combinations[33][3] = 31;

        combinations[34][0] = 32;
        combinations[34][1] = 37;
        combinations[34][2] = 42;
        combinations[34][3] = 47;

        combinations[35][0] = 48;
        combinations[35][1] = 53;
        combinations[35][2] = 58;
        combinations[35][3] = 63;


        combinations[36][0] = 3;
        combinations[36][1] = 6;
        combinations[36][2] = 9;
        combinations[36][3] = 12;

        combinations[37][0] = 19;
        combinations[37][1] = 22;
        combinations[37][2] = 25;
        combinations[37][3] = 28;

        combinations[38][0] = 35;
        combinations[38][1] = 38;
        combinations[38][2] = 41;
        combinations[38][3] = 44;

        combinations[39][0] = 51;
        combinations[39][1] = 54;
        combinations[39][2] = 57;
        combinations[39][3] = 60;

        // Different level, same column & row

        combinations[40][0] = 51;
        combinations[40][1] = 35;
        combinations[40][2] = 19;
        combinations[40][3] = 3;

        combinations[41][0] = 55;
        combinations[41][1] = 39;
        combinations[41][2] = 23;
        combinations[41][3] = 7;

        combinations[42][0] = 59;
        combinations[42][1] = 43;
        combinations[42][2] = 27;
        combinations[42][3] = 11;

        combinations[43][0] = 63;
        combinations[43][1] = 47;
        combinations[43][2] = 31;
        combinations[43][3] = 15;


        combinations[44][0] = 50;
        combinations[44][1] = 34;
        combinations[44][2] = 18;
        combinations[44][3] = 2;

        combinations[45][0] = 54;
        combinations[45][1] = 38;
        combinations[45][2] = 22;
        combinations[45][3] = 6;

        combinations[46][0] = 58;
        combinations[46][1] = 42;
        combinations[46][2] = 26;
        combinations[46][3] = 10;

        combinations[47][0] = 62;
        combinations[47][1] = 46;
        combinations[47][2] = 30;
        combinations[47][3] = 14;


        combinations[48][0] = 49;
        combinations[48][1] = 33;
        combinations[48][2] = 17;
        combinations[48][3] = 1;

        combinations[49][0] = 53;
        combinations[49][1] = 37;
        combinations[49][2] = 21;
        combinations[49][3] = 5;

        combinations[50][0] = 57;
        combinations[50][1] = 41;
        combinations[50][2] = 25;
        combinations[50][3] = 9;

        combinations[51][0] = 61;
        combinations[51][1] = 45;
        combinations[51][2] = 29;
        combinations[51][3] = 13;

        combinations[52][0] = 48;
        combinations[52][1] = 32;
        combinations[52][2] = 16;
        combinations[52][3] = 0;

        combinations[53][0] = 52;
        combinations[53][1] = 36;
        combinations[53][2] = 20;
        combinations[53][3] = 4;

        combinations[54][0] = 56;
        combinations[54][1] = 40;
        combinations[54][2] = 24;
        combinations[54][3] = 8;

        combinations[55][0] = 60;
        combinations[55][1] = 44;
        combinations[55][2] = 28;
        combinations[55][3] = 12;

        //Different level, same column
        combinations[56][0] = 51;
        combinations[56][1] = 39;
        combinations[56][2] = 27;
        combinations[56][3] = 15;

        combinations[57][0] = 50;
        combinations[57][1] = 38;
        combinations[57][2] = 26;
        combinations[57][3] = 14;

        combinations[58][0] = 49;
        combinations[58][1] = 37;
        combinations[58][2] = 25;
        combinations[58][3] = 13;

        combinations[59][0] = 48;
        combinations[59][1] = 36;
        combinations[59][2] = 24;
        combinations[59][3] = 12;

        combinations[60][0] = 3;
        combinations[60][1] = 23;
        combinations[60][2] = 43;
        combinations[60][3] = 63;

        combinations[61][0] = 2;
        combinations[61][1] = 22;
        combinations[61][2] = 42;
        combinations[61][3] = 62;

        combinations[62][0] = 1;
        combinations[62][1] = 21;
        combinations[62][2] = 41;
        combinations[62][3] = 61;

        combinations[63][0] = 0;
        combinations[63][1] = 20;
        combinations[63][2] = 40;
        combinations[63][3] = 60;

        // Different level, same row
        combinations[64][0] = 63;
        combinations[64][1] = 46;
        combinations[64][2] = 29;
        combinations[64][3] = 12;

        combinations[65][0] = 59;
        combinations[65][1] = 42;
        combinations[65][2] = 25;
        combinations[65][3] = 8;

        combinations[66][0] = 55;
        combinations[66][1] = 38;
        combinations[66][2] = 21;
        combinations[66][3] = 4;

        combinations[67][0] = 51;
        combinations[67][1] = 34;
        combinations[67][2] = 17;
        combinations[67][3] = 0;

        combinations[68][0] = 15;
        combinations[68][1] = 30;
        combinations[68][2] = 45;
        combinations[68][3] = 60;

        combinations[69][0] = 11;
        combinations[69][1] = 26;
        combinations[69][2] = 41;
        combinations[69][3] = 56;

        combinations[70][0] = 7;
        combinations[70][1] = 22;
        combinations[70][2] = 37;
        combinations[70][3] = 52;

        combinations[71][0] = 3;
        combinations[71][1] = 18;
        combinations[71][2] = 33;
        combinations[71][3] = 48;

        // From corner to corner, diagonally

        combinations[72][0] = 0;
        combinations[72][1] = 21;
        combinations[72][2] = 42;
        combinations[72][3] = 63;

        combinations[73][0] = 3;
        combinations[73][1] = 22;
        combinations[73][2] = 41;
        combinations[73][3] = 60;

        combinations[74][0] = 12;
        combinations[74][1] = 25;
        combinations[74][2] = 38;
        combinations[74][3] = 51;

        combinations[75][0] = 15;
        combinations[75][1] = 26;
        combinations[75][2] = 37;
        combinations[75][3] = 48;
    }

    /**
     * @param board a 3D tic-tac-toe board, including existing X and O positions
     *              as well as a marker for whose turn comes next
     * @return a (possibly empty) list of moves that the current player can take
     * to win the game in a single turn.
     */
    public List<TTT3DMove> winningMoves(TTT3DBoard board) {
        List<TTT3DMove> winningMoves = new ArrayList<TTT3DMove>();
        for (int i = 0; i < 76; i++){
            int sum = 0;
            boolean empty = false;
            int indexEmpty = 0;
            int numTurn = 0;
            for (int j=0; j<4; j++){
                if (board.valueInSquare(this.combinations[i][j]) == board.getWhoseTurn()){
                    numTurn++;
                } else if (board.valueInSquare(this.combinations[i][j]) == board.EMPTY_SQUARE){
                    indexEmpty = this.combinations[i][j];
                    empty = true;

                }
            }
            if (numTurn == 3 && empty == true){
                int position[] = board.positionForIndex(indexEmpty);
                TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                winningMoves.add(move);
                //System.out.print(position[0]+" "+position[1]+ " "+position[2]);
            }
        }
        //System.out.print(winningMoves.size());
        return winningMoves;
    }

    /**
     * @param board a 3D tic-tac-toe board, including existing X and O positions
     *              as well as a marker for whose turn comes next
     * @return a (possibly empty) list of moves that the non-current player could take
     * to win the game in a single turn. That is, these are positions where the current
     * player should play to avoid losing on the opponent's next turn.
     */
    public List<TTT3DMove> blockingMoves(TTT3DBoard board) {
        List<TTT3DMove> blockingMoves = new ArrayList<TTT3DMove>();
        for (int i = 0; i < 76; i++){
            int sum = 0;
            boolean empty = false;
            int indexEmpty = 0;
            int numTurn = 0;
            for (int j=0; j<4; j++){
                if (board.valueInSquare(this.combinations[i][j]) != board.getWhoseTurn()
                        && board.valueInSquare(this.combinations[i][j]) != board.EMPTY_SQUARE){
                    numTurn++;
                } else if (board.valueInSquare(this.combinations[i][j]) == board.EMPTY_SQUARE){
                    indexEmpty = this.combinations[i][j];
                    empty = true;

                }
            }
            if (numTurn == 3 && empty == true){
                int position[] = board.positionForIndex(indexEmpty);
                TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                blockingMoves.add(move);
                //System.out.print(position[0]+" "+position[1]+ " "+position[2]);
            }
        }
        //System.out.print(winningMoves.size());
        return blockingMoves;
    }

    /**
     * @param board a 3D tic-tac-toe board, including existing X and O positions
     *              as well as a marker for whose turn comes next
     * @return a (possibly empty) list of moves that the current player could take
     * to force a win. A move is "forcing" if it results in at least two different
     * ways for the current player to win on the next move. In other words, after a
     * forcing move, the opponent will be forced to make two different blocking moves
     * in a single turn to avoid losing.
     */
    public List<TTT3DMove> forcingMoves(TTT3DBoard board) {
        List<TTT3DMove> forcingMoves = new ArrayList<TTT3DMove>();
        for (int i = 0; i < 64; i++){
            if (board.valueInSquare(i) == board.EMPTY_SQUARE){
                TTT3DBoard boardTemp = new TTT3DBoard(board);
                boardTemp.setWhoseTurn(board.getWhoseTurn());
                boardTemp.setValueInSquare(i, board.getWhoseTurn());
                //boardTemp.printBoard();
                if (winningMoves(boardTemp).size() >= 2){
                    //System.out.println(i);
                    int position[] = board.positionForIndex(i);
                    //System.out.println(i);
                    TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                    forcingMoves.add(move);
                }
            }
        }

        return forcingMoves;
    }

    /**
     * @param board a 3D tic-tac-toe board, including existing X and O positions
     *              as well as a marker for whose turn comes next
     * @return the move that this object determines would be the best choice for the
     * board's current player.
     */
    public TTT3DMove bestMove(TTT3DBoard board) {
        if (!this.winningMoves(board).isEmpty()){
            return this.winningMoves(board).get(0);
        } else if (!this.blockingMoves(board).isEmpty()){
            return this.blockingMoves(board).get(0);
        } else if (!this.forcingMoves(board).isEmpty()){
            return this.forcingMoves(board).get(0);
        } else {
            for (int i = 0; i < 76; i++){
                boolean empty = false;
                int indexEmpty = 0;
                int numTurn = 0;
                for (int j=0; j<4; j++){
                    if (board.valueInSquare(this.combinations[i][j]) == board.getWhoseTurn()){
                        numTurn++;
                    } else if (board.valueInSquare(this.combinations[i][j]) == board.EMPTY_SQUARE){
                        indexEmpty = this.combinations[i][j];
                        empty = true;

                    }
                }
                if (numTurn == 2 && empty == true){
                    int position[] = board.positionForIndex(indexEmpty);
                    TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                    return move;
                }
            }
            for (int i = 0; i <64; i++){
                if (board.valueInSquare(i) == board.EMPTY_SQUARE){
                    int position[] = board.positionForIndex(i);
                    TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                    return move;
                }
            }
        }
        System.out.print("No available positions, return null");
        return null;
    }
}
