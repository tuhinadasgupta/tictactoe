package com.mycompany.tictactoe;

/**
 * Class containing the setUserInput() method, gameStatus() method, and various boolean checking methods()
 */
public class Board {
    private int[][] board;

    /**
     * Constructor for the class creates a 2D array of size [3][3]
     */
    public Board(){
        board = new int[3][3];
    }

    /**
     * Sets the user input into the board accordingly
     * @param location integer to determine location of strike and whether it's player 1 or player 2
     */
    public void setUserInput( int location) {
        if (location >= 11 && location <= 19) {
            location = location - 10; // player 1
            if (location >= 1 && location <= 3) {
                board[0][location - 1] = 1;
            }
            if (location >= 4 && location <= 6) {
                board[1][location - 4] = 1;
            }
            if (location >= 7 && location <= 9) {
                board[2][location - 7] = 1;
            }
        }
        if (location >= 21 && location <= 29) {
            location = location -20; //player 2
            if (location >= 1 && location <= 3) {
               board[0][location - 1] = 100;
               }
            if (location >= 4 && location <= 6) {
               board[1][location - 4] = 100;
               }
            if (location >= 7 && location <= 9) {
             board[2][location - 7] = 100;
             }
        }
    }

    /**
     * Method to check if a stalemate has occurred
     * @return boolean to check if stalemate has occurred
     */
    private boolean checkStalemate()
    {
        boolean checkStalemate = false;
        int counter =0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3;j++) {
                if (board[i][j] !=0) {
                    counter++;
                }
            }
        }
        if (counter ==9)
        {
            checkStalemate = true;
        }
        return checkStalemate;
    }

    /**
     * Method to check if a horizontal 3 in a row has occurred
     * @param iterate int that makes the row of the array iterate
     * @return boolean check if horizontal win
     */
    public boolean checkHorizontal(int iterate)
    {
        // i needs to iterate i=0,1,2
        // for one row 00,01,02
        boolean checkHorizontal = false;
           int sum =0;
               for (int j = 0; j < 3; j++) {
                   sum += board[iterate][j];
               }
           if (sum == 3) { //p1 3 in a row
               checkHorizontal = true;
           }
           if (sum == 300) { // p2 3 in a row
               checkHorizontal = true;
           }
        return checkHorizontal;
    }

    /**
     * Method to check if a vertical 3 in a row has occurred
     * @param iterate int that makes the column of the array iterate
     * @return boolean check if vertical win
     */
    public boolean checkVertical (int iterate)
    {
        // l needs to iterate 0,1,2
        // for one column 00 10 20
        boolean checkVertical = false;
        int sum =0;
            for (int m =0; m<3; m++) {
            sum += board[m][iterate];
            }

        if (sum == 3){  //p1 3 in a column
            checkVertical = true;
        }
        if (sum==300) { //p2 3 in a column
            checkVertical = true;
        }
        return checkVertical;
    }

    /**
     * Method to check if diagonal 3 in a row has occurred
     * @return boolean check if diagonal win
     */
    public boolean checkDiagonal()
    {
        boolean checkDiagonal = false;
        int sum1 = board[0][0] + board[1][1] + board[2][2];
        int sum2 = board[2][0] + board[1][1] + board[0][2];
        if (sum1 == 300 || sum2==300) {
            checkDiagonal =true; //player 2 won
        }
        if (sum1 == 3 || sum2 ==3){
            checkDiagonal = true; //player 1 won
        }
        return checkDiagonal;
    }

    /**
     * Method to check if the game has a winner (and should end) or not
     * @param iterate int that makes the row/column of the array iterate
     * @return an int that tells you if the game is over or not
     */
    public int gameStatus(int iterate)
    {
        int statusUpdate =0;
        if (checkHorizontal(iterate) ||checkVertical(iterate) || checkDiagonal() ){
            statusUpdate =1;
        }
        if (checkStalemate() && (!checkVertical(iterate) && !checkVertical(iterate) && !checkDiagonal())){
            statusUpdate =2;
        }
        return statusUpdate;
    }

    /**
     * Method to print the updated board
     */
    public void printDisplay()
    {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++){
                if (board[i][j] == 1){
                    System.out.print(" X ");
                    System.out.print("\t");
                }
                if (board[i][j]==100){
                    System.out.print(" O ");
                    System.out.print("\t");
                }
                if (board[i][j] == 0) {
                    System.out.print(" - ");
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
