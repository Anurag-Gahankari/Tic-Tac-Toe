package com.example.tictactoe.model;

public class Game {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public Game(){
        resetboard();
    }
    // Used to reset the board by placing "-" in every box
    public void resetboard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        currentPlayer = 'X';
    }

    //Checks for players not placing the marks outside the box and the player can make move
    public boolean makeMove(int row, int col){
            if(row < 0 || col < 0 || row >=3 || col >=3 || board[row][col] != '-'){
                return false;
            }
            board[row][col] = currentPlayer;
            return true;
    }

    // Changes the player
    public void switchPlayer(){
//        if(currentPlayer == 'X'){
//            currentPlayer = 'O';
//        }
        currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public String checkWinner(){
        for(int i=0;i<3;i++){
            //For Row
            if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return board[i][0] + " Wins";
            }
            //For Coloumn
            if(board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return board[0][i] + " Wins";
            }
        }
        ///for Diagonal
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return board[0][0] + " wins";
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2] + " wins";
        }

        //for Draw

        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    draw = false;
                }
            }
        }
        return draw ? "Draw" : "In Progress";
    }

}
