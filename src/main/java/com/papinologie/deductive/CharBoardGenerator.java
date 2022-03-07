package com.papinologie.deductive;

import java.util.concurrent.ThreadLocalRandom;

public class CharBoardGenerator {
    public Character[][] generateRandomBoard() {

        DeductiveReasoningChars deductiveReasoningChars = new DeductiveReasoningChars();
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        for (int row = 1; row < 5; row++) {
            int numberOfFilledPositions = tlr.nextInt(0, 5);
            while (numberOfFilledPositions != 0) {
                fillPositionsOnRow(tlr, deductiveReasoningChars, row);
                numberOfFilledPositions--;
            }
        }

        return deductiveReasoningChars.getBoard();
    }

    private void fillPositionsOnRow(ThreadLocalRandom tlr, DeductiveReasoningChars deductiveReasoningChars, int row) {
        int positionToBeFilled = tlr.nextInt(1, 5);
        if (deductiveReasoningChars.getBoard()[row-1][positionToBeFilled-1] == '\0') {
            deductiveReasoningChars.addSymbol(row,positionToBeFilled, DeductiveReasoningChars.accepted[tlr.nextInt(0, 4)]);
        }else{
            fillPositionsOnRow(tlr, deductiveReasoningChars, row);
        }
    }
}
