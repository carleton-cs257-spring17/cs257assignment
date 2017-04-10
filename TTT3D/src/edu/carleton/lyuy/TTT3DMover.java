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
    private int winningLines[][];
    /**
     * It holds 76 winning lines for 4*4*4 3D tic tac toe game.
     *
     */
    public TTT3DMover() {
        winningLines = new int[76][4];
        //On the same level, horizontally form a line
        winningLines[0][0] = 0;
        winningLines[0][1] = 1;
        winningLines[0][2] = 2;
        winningLines[0][3] = 3;

        winningLines[1][0] = 4;
        winningLines[1][1] = 5;
        winningLines[1][2] = 6;
        winningLines[1][3] = 7;

        winningLines[2][0] = 8;
        winningLines[2][1] = 9;
        winningLines[2][3] = 10;
        winningLines[2][3] = 11;

        winningLines[3][0] = 12;
        winningLines[3][1] = 13;
        winningLines[3][3] = 14;
        winningLines[3][3] = 15;

        winningLines[2][0] = 16;
        winningLines[2][1] = 17;
        winningLines[2][2] = 18;
        winningLines[2][3] = 19;

        winningLines[3][0] = 20;
        winningLines[3][1] = 21;
        winningLines[3][2] = 22;
        winningLines[3][3] = 23;

        winningLines[6][0] = 24;
        winningLines[6][1] = 25;
        winningLines[6][2] = 26;
        winningLines[6][3] = 27;

        winningLines[7][0] = 28;
        winningLines[7][1] = 29;
        winningLines[7][2] = 30;
        winningLines[7][3] = 31;


        winningLines[8][0] = 32;
        winningLines[8][1] = 33;
        winningLines[8][2] = 34;
        winningLines[8][3] = 35;

        winningLines[9][0] = 36;
        winningLines[9][1] = 37;
        winningLines[9][2] = 38;
        winningLines[9][3] = 39;

        winningLines[10][0] = 40;
        winningLines[10][1] = 41;
        winningLines[10][2] = 42;
        winningLines[10][3] = 43;

        winningLines[11][0] = 44;
        winningLines[11][1] = 45;
        winningLines[11][2] = 46;
        winningLines[11][3] = 47;


        winningLines[12][0] = 48;
        winningLines[12][1] = 49;
        winningLines[12][2] = 50;
        winningLines[12][3] = 51;

        winningLines[13][0] = 52;
        winningLines[13][1] = 53;
        winningLines[13][2] = 54;
        winningLines[13][3] = 55;

        winningLines[14][0] = 56;
        winningLines[14][1] = 57;
        winningLines[14][2] = 58;
        winningLines[14][3] = 59;

        winningLines[15][0] = 60;
        winningLines[15][1] = 61;
        winningLines[15][2] = 62;
        winningLines[15][3] = 63;

        // on the same level, vertically form a line
        winningLines[16][0] = 0;
        winningLines[16][1] = 4;
        winningLines[16][2] = 8;
        winningLines[16][3] = 12;

        winningLines[17][0] = 1;
        winningLines[17][1] = 5;
        winningLines[17][2] = 9;
        winningLines[17][3] = 13;

        winningLines[18][0] = 2;
        winningLines[18][1] = 6;
        winningLines[18][2] = 10;
        winningLines[18][3] = 14;

        winningLines[19][0] = 3;
        winningLines[19][1] = 7;
        winningLines[19][2] = 11;
        winningLines[19][3] = 15;


        winningLines[20][0] = 16;
        winningLines[20][1] = 20;
        winningLines[20][2] = 24;
        winningLines[20][3] = 28;

        winningLines[21][0] = 17;
        winningLines[21][1] = 21;
        winningLines[21][2] = 25;
        winningLines[21][3] = 29;

        winningLines[22][0] = 18;
        winningLines[22][1] = 22;
        winningLines[22][2] = 26;
        winningLines[22][3] = 30;

        winningLines[23][0] = 19;
        winningLines[23][1] = 23;
        winningLines[23][2] = 27;
        winningLines[23][3] = 31;


        winningLines[24][0] = 32;
        winningLines[24][1] = 36;
        winningLines[24][2] = 40;
        winningLines[24][3] = 44;

        winningLines[25][0] = 33;
        winningLines[25][1] = 37;
        winningLines[25][2] = 41;
        winningLines[25][3] = 45;

        winningLines[26][0] = 34;
        winningLines[26][1] = 38;
        winningLines[26][2] = 42;
        winningLines[26][3] = 46;

        winningLines[27][0] = 35;
        winningLines[27][1] = 39;
        winningLines[27][2] = 43;
        winningLines[27][3] = 47;

        winningLines[28][0] = 48;
        winningLines[28][1] = 52;
        winningLines[28][2] = 56;
        winningLines[28][3] = 60;

        winningLines[29][0] = 49;
        winningLines[29][1] = 53;
        winningLines[29][2] = 57;
        winningLines[29][3] = 61;

        winningLines[30][0] = 50;
        winningLines[30][1] = 54;
        winningLines[30][2] = 58;
        winningLines[30][3] = 62;

        winningLines[31][0] = 51;
        winningLines[31][1] = 55;
        winningLines[31][2] = 59;
        winningLines[31][3] = 63;

        // on the same level, diaganolly form a line
        winningLines[32][0] = 0;
        winningLines[32][1] = 5;
        winningLines[32][2] = 10;
        winningLines[32][3] = 15;

        winningLines[33][0] = 16;
        winningLines[33][1] = 21;
        winningLines[33][2] = 26;
        winningLines[33][3] = 31;

        winningLines[34][0] = 32;
        winningLines[34][1] = 37;
        winningLines[34][2] = 42;
        winningLines[34][3] = 47;

        winningLines[35][0] = 48;
        winningLines[35][1] = 53;
        winningLines[35][2] = 58;
        winningLines[35][3] = 63;


        winningLines[36][0] = 3;
        winningLines[36][1] = 6;
        winningLines[36][2] = 9;
        winningLines[36][3] = 12;

        winningLines[37][0] = 19;
        winningLines[37][1] = 22;
        winningLines[37][2] = 25;
        winningLines[37][3] = 28;

        winningLines[38][0] = 35;
        winningLines[38][1] = 38;
        winningLines[38][2] = 41;
        winningLines[38][3] = 44;

        winningLines[39][0] = 51;
        winningLines[39][1] = 54;
        winningLines[39][2] = 57;
        winningLines[39][3] = 60;

        // Different level, same column & row, form vertically
        winningLines[40][0] = 3;
        winningLines[40][1] = 19;
        winningLines[40][2] = 35;
        winningLines[40][3] = 51;

        winningLines[41][0] = 7;
        winningLines[41][1] = 23;
        winningLines[41][2] = 39;
        winningLines[41][3] = 55;

        winningLines[42][0] = 11;
        winningLines[42][1] = 27;
        winningLines[42][2] = 43;
        winningLines[42][3] = 59;

        winningLines[43][0] = 15;
        winningLines[43][1] = 31;
        winningLines[43][2] = 47;
        winningLines[43][3] = 63;


        winningLines[44][0] = 2;
        winningLines[44][1] = 18;
        winningLines[44][2] = 34;
        winningLines[44][3] = 50;

        winningLines[45][0] = 6;
        winningLines[45][1] = 22;
        winningLines[45][2] = 38;
        winningLines[45][3] = 54;

        winningLines[46][0] = 10;
        winningLines[46][1] = 26;
        winningLines[46][2] = 42;
        winningLines[46][3] = 58;

        winningLines[47][0] = 14;
        winningLines[47][1] = 30;
        winningLines[47][2] = 46;
        winningLines[47][3] = 62;


        winningLines[48][0] = 1;
        winningLines[48][1] = 17;
        winningLines[48][2] = 33;
        winningLines[48][3] = 49;

        winningLines[49][0] = 5;
        winningLines[49][1] = 21;
        winningLines[49][2] = 37;
        winningLines[49][3] = 53;

        winningLines[50][0] = 9;
        winningLines[50][1] = 25;
        winningLines[50][2] = 41;
        winningLines[50][3] = 57;

        winningLines[51][0] = 13;
        winningLines[51][1] = 29;
        winningLines[51][2] = 45;
        winningLines[51][3] = 61;

        winningLines[52][0] = 0;
        winningLines[52][1] = 16;
        winningLines[52][2] = 32;
        winningLines[52][3] = 48;

        winningLines[53][0] = 4;
        winningLines[53][1] = 20;
        winningLines[53][2] = 36;
        winningLines[53][3] = 52;

        winningLines[54][0] = 8;
        winningLines[54][1] = 24;
        winningLines[54][2] = 40;
        winningLines[54][3] = 56;

        winningLines[55][0] = 12;
        winningLines[55][1] = 28;
        winningLines[55][2] = 44;
        winningLines[55][3] = 60;

        //Different level, same column, different row, form the line diagonally
        winningLines[56][0] = 15;
        winningLines[56][1] = 27;
        winningLines[56][2] = 39;
        winningLines[56][3] = 51;

        winningLines[57][0] = 14;
        winningLines[57][1] = 26;
        winningLines[57][2] = 38;
        winningLines[57][3] = 50;

        winningLines[58][0] = 13;
        winningLines[58][1] = 25;
        winningLines[58][2] = 37;
        winningLines[58][3] = 49;

        winningLines[59][0] = 12;
        winningLines[59][1] = 24;
        winningLines[59][2] = 36;
        winningLines[59][3] = 48;

        winningLines[60][0] = 3;
        winningLines[60][1] = 23;
        winningLines[60][2] = 43;
        winningLines[60][3] = 63;

        winningLines[61][0] = 2;
        winningLines[61][1] = 22;
        winningLines[61][2] = 42;
        winningLines[61][3] = 62;

        winningLines[62][0] = 1;
        winningLines[62][1] = 21;
        winningLines[62][2] = 41;
        winningLines[62][3] = 61;

        winningLines[63][0] = 0;
        winningLines[63][1] = 20;
        winningLines[63][2] = 40;
        winningLines[63][3] = 60;

        // Different level, same row, different column, form a line diagonally
        winningLines[64][0] = 12;
        winningLines[64][1] = 29;
        winningLines[64][2] = 46;
        winningLines[64][3] = 63;

        winningLines[65][0] = 8;
        winningLines[65][1] = 25;
        winningLines[65][2] = 42;
        winningLines[65][3] = 59;

        winningLines[66][0] = 4;
        winningLines[66][1] = 21;
        winningLines[66][2] = 38;
        winningLines[66][3] = 55;

        winningLines[67][0] = 0;
        winningLines[67][1] = 17;
        winningLines[67][2] = 34;
        winningLines[67][3] = 51;

        winningLines[68][0] = 3;
        winningLines[68][1] = 18;
        winningLines[68][2] = 33;
        winningLines[68][3] = 48;

        winningLines[69][0] = 7;
        winningLines[69][1] = 22;
        winningLines[69][2] = 37;
        winningLines[69][3] = 52;

        winningLines[70][0] = 11;
        winningLines[70][1] = 26;
        winningLines[70][2] = 41;
        winningLines[70][3] = 56;

        winningLines[71][0] = 15;
        winningLines[71][1] = 30;
        winningLines[71][2] = 45;
        winningLines[71][3] = 60;

        // From corner to corner, diagonally

        winningLines[72][0] = 0;
        winningLines[72][1] = 21;
        winningLines[72][2] = 42;
        winningLines[72][3] = 63;

        winningLines[73][0] = 3;
        winningLines[73][1] = 22;
        winningLines[73][2] = 41;
        winningLines[73][3] = 60;

        winningLines[74][0] = 12;
        winningLines[74][1] = 25;
        winningLines[74][2] = 38;
        winningLines[74][3] = 51;

        winningLines[75][0] = 15;
        winningLines[75][1] = 26;
        winningLines[75][2] = 37;
        winningLines[75][3] = 48;
    }

    /**
     * @param board a 3D tic-tac-toe board, including existing X and O positions
     *              as well as a marker for whose turn comes next
     * @return a (possibly empty) list of moves that the current player can take
     * to win the game in a single turn.
     */
    public List<TTT3DMove> winningMoves(TTT3DBoard board) {
        List<TTT3DMove> winningMoves = new ArrayList<TTT3DMove>();
        // search for 76 winning lines to check if there are already 3 my chess move in a combination.
        for (int i = 0; i < 76; i++){
            boolean empty = false;
            int indexEmpty = 0;
            int numTurn = 0;
            for (int j=0; j<4; j++){
                if (board.valueInSquare(this.winningLines[i][j]) == board.getWhoseTurn()){
                    numTurn++;
                } else if (board.valueInSquare(this.winningLines[i][j]) == board.EMPTY_SQUARE){
                    indexEmpty = this.winningLines[i][j];
                    empty = true;
                }
            }
            // If there are 3 X's or O's in one combination and there is still one position left
            // then the empty position is a winning move
            if (numTurn == 3 && empty == true){
                int position[] = board.positionForIndex(indexEmpty);
                TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                winningMoves.add(move);
            }
        }
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
        // search for 76 winning lines to check if there are already 3 my opponent's
        // chess move in a combination.
        for (int i = 0; i < 76; i++){
            boolean empty = false;
            int indexEmpty = 0;
            int numTurn = 0;
            for (int j=0; j<4; j++){
                if (board.valueInSquare(this.winningLines[i][j]) != board.getWhoseTurn()
                        && board.valueInSquare(this.winningLines[i][j]) != board.EMPTY_SQUARE){
                    numTurn++;
                } else if (board.valueInSquare(this.winningLines[i][j]) == board.EMPTY_SQUARE){
                    indexEmpty = this.winningLines[i][j];
                    empty = true;

                }
            }
            // If there are 3 my opponent's chess in one combination and there is still one position left
            // then the empty position is a winning move
            if (numTurn == 3 && empty == true){
                int position[] = board.positionForIndex(indexEmpty);
                TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                blockingMoves.add(move);
            }
        }
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
        // We search all the available positions in the board
        for (int i = 0; i < 64; i++){
            if (board.valueInSquare(i) == board.EMPTY_SQUARE){
                TTT3DBoard boardTemp = new TTT3DBoard(board);
                boardTemp.setWhoseTurn(board.getWhoseTurn());
                boardTemp.setValueInSquare(i, board.getWhoseTurn());
                //check whether we can have more than 2 winning moves if we put a chess in this position
                if (winningMoves(boardTemp).size() >= 2){
                    int position[] = board.positionForIndex(i);
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
        // Our general algorithm is that if we have winning moves available,
        // then we take the first winning move to be our move
        // Then we check the blocking moves and forcing moves
        if (!this.winningMoves(board).isEmpty()){
            return this.winningMoves(board).get(0);
        } else if (!this.blockingMoves(board).isEmpty()){
            return this.blockingMoves(board).get(0);
        } else if (!this.forcingMoves(board).isEmpty()){
            return this.forcingMoves(board).get(0);
            // If there is no winningMoves, blockingMoves and forcingMoves, then we
            // search if there exist 2 our chess moves in one winning combination.
            // If we have, then we return the first empty position in the winningline
        } else {
            for (int i = 0; i < 76; i++){
                boolean empty = false;
                int indexEmpty = 0;
                int numTurn = 0;
                for (int j=0; j<4; j++){
                    if (board.valueInSquare(this.winningLines[i][j]) == board.getWhoseTurn()){
                        numTurn++;
                    } else if (board.valueInSquare(this.winningLines[i][j]) == board.EMPTY_SQUARE){
                        indexEmpty = this.winningLines[i][j];
                        empty = true;

                    }
                }
                if (numTurn == 2 && empty == true){
                    int position[] = board.positionForIndex(indexEmpty);
                    TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                    return move;
                }
            }
            // If we still do not have best move, then we just randomly pick one
            for (int i = 0; i <64; i++){
                if (board.valueInSquare(i) == board.EMPTY_SQUARE){
                    int position[] = board.positionForIndex(i);
                    TTT3DMove move = new TTT3DMove(position[0], position[1], position[2],board.getWhoseTurn());
                    return move;
                }
            }
        }
        return null;
    }
}
