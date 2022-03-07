package com.papinologie.deductive;

import java.util.Arrays;

public class DeductiveReasoningChars {
    private static final int SIZE = 4;

    private Character[][] board = generateEmptyBoard();

    public static Character[] accepted = {'a', 'b', 'c', 'd'};

    public static Character[][] generateEmptyBoard() {
        Character[][] board =
                {
                        {'\0', '\0', '\0', '\0'}
                        , {'\0', '\0', '\0', '\0'}
                        , {'\0', '\0', '\0', '\0'}
                        , {'\0', '\0', '\0', '\0'}
                };
        return board;
    }

    public String addSymbol(int x, int y, char charToAdd) {
        checkAxisOutOfBounds(x, "X axis out of bounds");
        checkAxisOutOfBounds(y, "Y axis out of bounds");
        if (charValid(x, y, charToAdd)) {
            setBox(x, y, charToAdd);
            return "Char added";
        } else {
            return "Char invalid";
        }

    }

    private boolean charValid(int xPosition, int yPosition, char charToBeAdded) {
        if (isUnacceptedChar(charToBeAdded)) {
            return false;
        }
        for (int i = 0; i < SIZE; i++) {
            if (isCharAlreadyPresentInRow(xPosition, yPosition, charToBeAdded, i)
                    || isCharAlreadyPresentInCol(xPosition, yPosition, charToBeAdded, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnacceptedChar(char charToBeAdded) {
        return Arrays.stream(accepted).noneMatch(c -> c == charToBeAdded);
    }

    private boolean isCharAlreadyPresentInRow(int xPosition, int yPosition, char charToBeAdded, int i) {
        return i != xPosition - 1 && board[i][yPosition - 1] == charToBeAdded;
    }

    private boolean isCharAlreadyPresentInCol(int xPosition, int yPosition, char charToBeAdded, int i) {
        return i != yPosition - 1 && board[xPosition - 1][i] == charToBeAdded;
    }

    private void checkAxisOutOfBounds(int position, String message) {
        if (position < 1 || position > 4) {
            throw new RuntimeException(message);
        }
    }

    private void setBox(int xPosition, int yPosition, char charToBeAdded) {
        board[xPosition - 1][yPosition - 1] = charToBeAdded;
    }

    public void setBoard(Character[][] board) {
        this.board = board;
    }

    public Character[][] getBoard() {
        return board;
    }
}