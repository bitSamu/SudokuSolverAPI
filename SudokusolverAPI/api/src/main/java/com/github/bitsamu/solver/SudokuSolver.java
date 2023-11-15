package com.github.bitsamu.solver;

public class SudokuSolver {

    public final int GRID_SIZE = 9;
    Integer[][] solvedBoard = new Integer[GRID_SIZE][GRID_SIZE];
    private boolean isInRow(Integer[][] board, int row, int number){
        for(int col = 0; col < GRID_SIZE; col++){
            if(board[row][col] == number){
                return true;
            }
        }
        return false;
    }

    private boolean isInCol(Integer[][] board, int col, int number){
        for(int row = 0; row < GRID_SIZE; row++){
            if(board[row][col] == number){
                return true;
            }
        }
        return false;
    }

    private boolean isInBox(Integer[][] board, int row, int col, int number){
        int localRow = row - row % 3;
        int localCol = col - col % 3;

        for(int i = localRow; i < localRow + 3; i++){
            for(int j = localCol; j < localCol + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCorrectPlacement(Integer[][] board, int row, int col, int number){
        return !isInCol(board, col, number) &&
                !isInRow(board, row, number) &&
                !isInBox(board, row, col, number);
    }

    public boolean solveBoard(Integer[][] board){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {
                        if (isCorrectPlacement(board, i, j, numberToTry)) {
                            board[i][j] = numberToTry;
                            if(solveBoard(board)){
                                return true;
                            }
                            else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        solvedBoard = board;
        return true;
    }

    public Integer[][] getSolvedBoard(){
        return solvedBoard;
    }

    public void displayBoard(Integer[][] board){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int j = 0; j < GRID_SIZE; j++){
                System.out.print(board[i][j] + " ");

                if((j + 1) % 3 == 0){
                    System.out.print("| ");
                }
            }
            System.out.println();

            if((i + 1) % 3 == 0){
                System.out.println("- - - + - - - + - - - +");
            }
        }
    }
}
