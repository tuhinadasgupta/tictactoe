package com.mycompany.tictactoe;
import java.util.HashMap;
import java.util.Scanner;

/**
 * CLass containing the methods: getUserInput(), compareUserInput(), and printGuide()
 * The play() method is where most of the code is called for the project
 */
public class Player {
    /**
     * Method that runs the game until there's a winner or a stalemate
     * @param myBoard the game board from class Board
     */
    public void play(Board myBoard){
        int counter =0;
        int turnCount =0;
        // hash map to set values for each square
        HashMap hm = new HashMap();
        hm.put(1, "q");
        hm.put(2, "w");
        hm.put(3, "e");
        hm.put(4, "a");
        hm.put(5, "s");
        hm.put(6, "d");
        hm.put(7, "z");
        hm.put(8, "x");
        hm.put(9, "c");

        int iterate;
        int gamePlay =1;
        while (gamePlay==1)
        {
            printGuide();
            myBoard.printDisplay();
            String userInput = getUserInput(counter, hm);
            turnCount++;
            int location = compareUserInput(hm, userInput, counter);
            myBoard.setUserInput(location);
            for (iterate=0; iterate<3; iterate++) {
                if (myBoard.gameStatus(iterate) == 1) {
                    gamePlay--;
                    System.out.println("Game Over!");
                    if (turnCount % 2 == 0) {
                        System.out.println("Congrats on the victory Player 2!!");
                        break;
                    }
                    if (turnCount % 2 == 1) {
                        System.out.println("Congrats on the victory Player 1!!");
                        break;
                    }
                }
                if (myBoard.gameStatus(iterate) == 2) {
                    gamePlay--;
                    int trackerCount= 0;
                    // a check to see if the final move resulted in a win horizontally, vertically, or diagonally
                    for (iterate=0; iterate<3; iterate++)
                    {
                        boolean checkH =  myBoard.checkHorizontal(iterate);
                        boolean checkV = myBoard.checkVertical(iterate);
                        boolean checkD = myBoard.checkDiagonal();
                        if (checkH || checkV || checkD)
                        {
                            if (turnCount % 2 == 0) {
                                System.out.println("Congrats on the victory Player 2!!");
                                break;
                            }
                            if (turnCount % 2 == 1) {
                                System.out.println("Congrats on the victory Player 1!!");
                                break;
                            }
                        }
                        else if (!checkH && !checkV && !checkD)
                        {
                            trackerCount++;
                        }
                    }
                    // a stalemate has occurred
                    if (trackerCount==3) {
                        gamePlay--;
                        System.out.println("The game ends in a tie!");
                        break;
                    }
                }
                break;
                }
                counter++;
            }
        myBoard.printDisplay();
        }


    /**
     * Method that takes in valid user input
     * @param counter counter to determine if it's player 1 (x's) or player 2 (o's)
     * @param hm the hash map is used to verify that the input matches the value of one of the elements
     * @return valid String input
     */
    private String getUserInput(int counter, HashMap hm)
    {
        String persona ="";
        int playerNumber=0;
        if (counter%2 ==0)
        {
            playerNumber =1;
            persona = "X";
        }
        else if (counter%2 ==1)
        {
            playerNumber =2;
            persona = "O";
        }
        boolean inputValid = false;
        String input = "";
        int errorCounter=0;
        while (!inputValid) {
            Scanner sc = new Scanner(System.in);
            if (errorCounter >=1 ){
                System.out.println("Your input was not valid :( Please refer to the guide");
                printGuide();
            }
            System.out.println("Welcome player # " + playerNumber + " to this game of tic tac toe");
            System.out.println("Please enter the letter of the box you would like to place a(n) " + persona + " on");
            input = sc.next();
            for (int t = 1; t <= hm.size(); t++) {
                if (input.equals(hm.get(t))) {
                    inputValid = true;
                }
            }
            errorCounter++;
        }
        return input;
    }

    /**
     * Method that turns the String from user into a number depending on whether it was player 1 or player 2
     * @param hm hash map used to verify input
     * @param userInput the user's entered input
     * @param counter to verify if it's player 1 or player 2
     * @return an integer
     */
    private int compareUserInput(HashMap hm, String userInput, int counter)
    {
        int playerCoordinates=0;
        for (int i = 1; i <=hm.size(); i++) {
            if (counter%2 ==0) { //player 1
                if (userInput.equals(hm.get(i))){
                    playerCoordinates = 10 + i;
                 }
            }
            if (counter%2 ==1){
                if (userInput.equals(hm.get(i))){
                    playerCoordinates = 20 +i;
                }
            }
        }
        return playerCoordinates;
    }

    /**
     * A guide to help the user understand what letter corresponds to what location on the tic tac toe board
     */
    private void printGuide()
    {
        System.out.print("  q |   w   |   e");
        System.out.println();
        System.out.print("________________");
        System.out.println();
        System.out.print("  a |   s   |   d");
        System.out.println();
        System.out.print("________________");
        System.out.println();
        System.out.print("  z |   x   |   c");
        System.out.println();

    }
}
