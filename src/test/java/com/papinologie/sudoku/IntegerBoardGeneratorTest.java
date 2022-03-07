package com.papinologie.sudoku;

import org.junit.Test;

public class IntegerBoardGeneratorTest {

    @Test
    public void generateRandomBoard() {
        int[][] randomBoard = IntegerBoardGenerator.generateRandomBoard();
        SudokuPuzzle.print(randomBoard);
    }

    @Test
    public void givenGeneratedRandomBoard_WhenSolvingPuzzle_TheSolvedPuzzleIsPrinted() {
        int[][] randomBoard = IntegerBoardGenerator.generateRandomBoard();
        SudokuPuzzle.print(randomBoard);
        System.out.println("~~~~~~~~~~~~");
        if (SudokuPuzzle.solvePuzzle(randomBoard)) {
            SudokuPuzzle.print(randomBoard);
        } else {
            System.out.println("Solution inexistent");
        }

    }


}