package com.mycompany.tictactoe;

/**
 * Class is the class containing the main for the project
 */
public class TestTicTacToe {
    public static void main(String[] args)
    {
        Board myBoard = new Board();
        Player myPlayer = new Player();
        myPlayer.play(myBoard);
    }


}

