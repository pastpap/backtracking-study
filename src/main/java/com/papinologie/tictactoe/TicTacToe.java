package com.papinologie.tictactoe;

public class TicTacToe {
    private static final int SIZE = 3;
    private char lastPlayer = '\0';
    private Character[][] board = {{'\0', '\0', '\0'},
            {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    public String play(int xPosition, int yPosition) throws RuntimeException {
        checkAxis(xPosition, "X axis out of bounds");
        checkAxis(yPosition, "y axis out of bounds");
        lastPlayer = nextPlayer();
        setBox(xPosition, yPosition, lastPlayer);
        if (isWin()) {
            return lastPlayer + " is the winner";
        } else if (isDraw()) {
            return "The result is draw";
        } else {
            return "No winner";
        }
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * SIZE;
        int firstDiagTotal = 0;
        int secondDiagTotal = 0;
        for (int i = 0; i < SIZE; i++) {
            firstDiagTotal += board[i][i];
            secondDiagTotal += board[i][SIZE - 1 - i];
            if (board[0][i] + board[1][i] + board[2][i]
                    == playerTotal) {
                return true;
            } else if (board[i][0] + board[i][1] + board[i][2] == playerTotal) {
                return true;
            }
        }
        if (firstDiagTotal == playerTotal || secondDiagTotal == playerTotal) {
            return true;
        }
        return false;
    }

    private boolean isDraw() {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                if (board[x][y] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    private void checkAxis(int position, String message) {
        if (position < 1 || position > 3) {
            throw new RuntimeException(message);
        }
    }

    private void setBox(int xPosition, int yPosition, char lastPlayer) {
        if (board[xPosition - 1][yPosition - 1] != '\0') {
            throw new RuntimeException("Position occupied! Try another one.");
        } else {
            board[xPosition - 1][yPosition - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}
