package com.papinologie.sudoku;

public class SudokuPuzzle {
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        if (checkForRowClash(board, row, num)) return false;
        if (checkForColumnClash(board, col, num)) return false;
        return !checkForBoxClash(board, row, col, num);
    }

    private static boolean checkForBoxClash(int[][] board, int row, int col, int num) {
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkForColumnClash(int[][] board, int col, int num) {
        for (int[] ints : board) {
            if (isPresentInColumn(col, num, ints)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPresentInColumn(int col, int num, int[] board) {
        return board[col] == num;
    }

    private static boolean checkForRowClash(int[][] board, int row, int num) {
        for (int d = 0; d < board.length; d++) {
            if (isPresentInRow(num, d, board[row])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPresentInRow(int num, int d, int[] board) {
        return board[d] == num;
    }

    public static boolean solvePuzzle(int[][] board) {
        int row = -1;
        int col = -1;
        boolean noEmptyCells = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    noEmptyCells = false;
                    break;
                }
            }
            if (!noEmptyCells) {
                break;
            }
        }
        if (noEmptyCells) {
            return true;
        }
        return backtrackRowByRow(board, row, col);
    }

    private static boolean backtrackRowByRow(int[][] board, int row, int col) {
        for (int num = 1; num <= board.length; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solvePuzzle(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int d = 0; d < board.length; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(board.length) == 0) {
                System.out.print("");
            }
        }
    }

    public static void main(String[] args) {
        testSudoku();
        testDeductiveReasoning();
    }

    private static void testSudoku() {
        int[][] board = new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0}, {5, 2, 0, 0, 0, 0, 0, 0, 0}, {0, 8, 7, 0, 0, 0, 0, 3, 1}, {0, 0, 3, 0, 1, 0, 0, 8, 0}, {9, 0, 0, 8, 6, 3, 0, 0, 5}, {0, 5, 0, 0, 9, 0, 6, 0, 0}, {1, 3, 0, 0, 0, 0, 2, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 7, 4}, {0, 0, 5, 2, 0, 6, 3, 0, 0}};

        if (solvePuzzle(board)) {
            print(board);
        } else {
            System.out.println("No solution");
        }
    }
    private static void testDeductiveReasoning() {
        int[][] board = new int[][]{
                {0, 0, 0, 0}
                , {0, 0, 0, 0 }
                , {4, 1, 0, 0 }
                , {0, 0, 0, 0}};

        if (solvePuzzle(board)) {
            print(board);
        } else {
            System.out.println("No solution");
        }
    }

}
