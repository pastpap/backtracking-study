package com.papinologie.deductive;

import org.junit.Before;
import org.junit.Test;

public class CharBoardGeneratorTest {
    private DeductiveReasoningChars deductiveReasoningChars;
    private CharBoardGenerator charBoardGenerator;

    @Before
    public void before() throws Exception {
        deductiveReasoningChars = new DeductiveReasoningChars();
        charBoardGenerator = new CharBoardGenerator();
    }

    @Test
    public void print5RandomBoard() {
        Character[][] randomBoard = charBoardGenerator.generateRandomBoard();
        printBoard(randomBoard);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        randomBoard = charBoardGenerator.generateRandomBoard();
        printBoard(randomBoard);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        randomBoard = charBoardGenerator.generateRandomBoard();
        printBoard(randomBoard);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        randomBoard = charBoardGenerator.generateRandomBoard();
        printBoard(randomBoard);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        randomBoard = charBoardGenerator.generateRandomBoard();
        printBoard(randomBoard);
    }

    private void printBoard(Character[][] randomBoard) {
        for (int i = 0; i < 4; i++) {
            String row = "";
            for (int j = 0; j < 4; j++) {
                row += "| " + randomBoard[i][j] + " |";
            }
            System.out.println(row);
        }
    }
}