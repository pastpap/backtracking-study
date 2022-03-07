package com.papinologie.sudoku;

import java.util.concurrent.ThreadLocalRandom;

public class IntegerBoardGenerator {
    public static int[][] generateRandomBoard() {

        int[][] board = generateEmptyBoard();
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for (int row = 0; row < 4; row++) {
            int numberOfFilledPositions = tlr.nextInt(0, 4);
            while (numberOfFilledPositions != 0) {
                fillPositionsOnRow(tlr, board, row);
                numberOfFilledPositions--;
            }
        }

        return board;
    }

    public static void fillPositionsOnRow(ThreadLocalRandom tlr, int[][] board, int row) {
        int positionToBeFilled = tlr.nextInt(0, 4);
        if (board[row][positionToBeFilled] == 0) {
            int randomValueForCell = tlr.nextInt(1, 5);
            if(SudokuPuzzle.isSafe(board,row,positionToBeFilled, randomValueForCell)){
                board[row][positionToBeFilled] = randomValueForCell;
            };
        }else{
            fillPositionsOnRow(tlr, board, row);
        }
    }

    public static int[][] generateEmptyBoard(){
        return new int[][]{
                {0, 0, 0, 0}
                , {0, 0, 0, 0 }
                , {0, 0, 0, 0 }
                , {0, 0, 0, 0}};
    }
}
