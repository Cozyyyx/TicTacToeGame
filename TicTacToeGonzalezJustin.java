/*
Justin Gonzalez
CSC 331
TIC TAC TOE GAME
Player file
 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.List;

public class TicTacToeGonzalezJustin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //takes user input
        boolean twoTrue = false; // boolean for 2 human players
        boolean PvC = false; // boolean for 1 player vs the computer
        String player_1 = ""; // empty strings for instance display names
        String player_2 = ""; // for instance display name
        TicTacToe computer = new TicTacToe("Computer", null); // computers instance takes name and X or O params

        System.out.println("Do you want to play against a computer? TYPE (y/n): ");
        String choice = input.next();

        if (choice.equalsIgnoreCase("n")) { // playing against another human player
            twoTrue = true; // set the bool true for human players

            System.out.println("What player do you want to be? TYPE (player1/player2): "); // choosing who wants to be what player (extra credit) and setting the instance strings
            String what = input.next();

            if (what.equalsIgnoreCase("player1")) {
                System.out.println("\n" + "Please enter a display name for Player 1: ");
                player_1 = input.next();

                System.out.println("\n" + "Please enter a display name for Player 2: ");
                player_2 = input.next();

            } else {
                System.out.println("\n" + "Please enter a display name for Player 2: ");
                player_2 = input.next();

                System.out.println("\n" + "Please enter a display name for Player 1: ");
                player_1 = input.next();
            }
        }

        if (choice.equalsIgnoreCase("y")) { // playing against the computer

            System.out.println("\n" + "What player do you want to be? TYPE (player1/player2): "); // chooses what player the human wants to be (extra credit)
            String what = input.next();

            if (what.equalsIgnoreCase("player1")) {
                System.out.println("\n" + "Please enter a display name for Player 1: ");
                player_1 = input.next();
                computer.setWhat("O"); // set the computer to "O" since they're player 2
                PvC = true; // true that a human is playing the computer
            } else {
                System.out.println("\n" + "Please enter a display name for Player 2: ");
                player_2 = input.next();
                computer.setWhat("X"); // set the computer to "X" since they're player 1
                PvC = true; // true that a human is playing the computer
            }

        }

        TicTacToe player1 = new TicTacToe(player_1, null); // player instances of the tic tac toe game
        TicTacToe player2 = new TicTacToe(player_2, null);

        while (twoTrue) { // runs when 2 human players are playing
            playerr_1(player1); // player 1's move

            if (player1.hasWon("X")) { // checks to see if player has won
                System.out.println(player1.getName() + " You won congrats!!");
                break;
            }
            if (player1.hasTied()) { // checks to see if game is tied
                System.out.println("Game is a draw!");
                break;
            }

            playerr_2(player2); // player 2's move

            if (player2.hasWon("O")) { // checks to see if player has won
                System.out.println(player2.getName() + " You won congrats!!");
                break;
            }

            if (player2.hasTied()) { // checks to see if game is tied
                System.out.println("Game is a draw!");
                break;
            }

        }

        while (PvC) { // runs when a player is playing the computer
            if (computer.getWhat().equals("X")) { // computers move if player is player2

                player_comp(computer);

                if (computer.hasWon("X")) { // checks for winning condition
                    System.out.println("The computer won, better luck next time!!");
                    break;
                }
                if (computer.hasTied()) { // checks for a tie
                    System.out.println("Game is a draw!");
                    break;
                }
            } else {
                playerr_1(player1); // if player is player 1

                if (player1.hasWon("X")) { //checks for winning condition
                    System.out.println(player1.getName() + " You won congrats!!");
                    break;
                }
                if (player1.hasTied()) { //checks for a tie
                    System.out.println("Game is a draw!");
                    break;
                }
            }

            if (computer.getWhat().equals("O")) { // if computer is player 2
                player_comp(computer);
                if (computer.hasWon("O")) { //checks for winning condition
                    System.out.println("The computer won, better luck next time!!");
                    break;
                }
                if (computer.hasTied()) { //checks for a tie
                    System.out.println("Game is a draw!");
                    break;
                }
            } else {
                playerr_2(player2); // if player is player2

                if (player2.hasWon("O")) { //checks for winning condition
                    System.out.println(player2.getName() + " You won congrats!!");
                    break;
                }

                if (player2.hasTied()) { //checks for a tie
                    System.out.println("Game is a draw!");
                    break;
                }
            }
        }
    }

        public static void playerr_1 (TicTacToe player1){ // method that takes user input and adds that too the tic tac toe board for player 1
            Scanner input1 = new Scanner(System.in);
            try {
                System.out.println("\n" + player1.getName() + " enter the row number to place an 'X': ");
                int player_row = input1.nextInt();

                System.out.println("\n" + player1.getName() + " enter the column number to place an 'X': ");
                int player_column = input1.nextInt();

                player1.add(player_row, player_column, "X"); // adds to the board
                System.out.println("\n" + player1.display()); // displays the board

            } catch (YouCantPutThatThere ex) { // error is when a player tries to put a value in a non empty spot
                System.err.print(ex);// error message
                playerr_1(player1); // re call method too repick a value that's empty
            }
        }

        public static void playerr_2 (TicTacToe player2){ // method that takes user input and adds that too the tic tac toe board for player 2
            Scanner input1 = new Scanner(System.in);
            try {
                System.out.println("\n" + player2.getName() + " enter the row number to place an 'O': ");
                int player2_row = input1.nextInt();

                System.out.println("\n" + player2.getName() + " enter the column number to place an 'O': ");
                int player2_column = input1.nextInt();

                player2.add(player2_row, player2_column, "O"); // adds to the board
                System.out.println("\n" + player2.display()); // displays the board

            } catch (YouCantPutThatThere ex) { // error is when a player tries to put a value in a non empty spot
                System.err.println(ex); // error message
                playerr_2(player2); // re call method too repick a value that's empty
            }
        }

        public static void player_comp(TicTacToe computer){ // computers method to add to the board
            List<Integer> comp_choice = Arrays.asList(0,1,2); // creates a list of possible values that's used on the board
            Random choose = new Random(); // chooses a random number from the list
            int value = comp_choice.get(choose.nextInt(comp_choice.size())); // first random number the "Row"
            int value1 = comp_choice.get(choose.nextInt(comp_choice.size())); // second random number the "Column"

            try {
                computer.add(value, value1, computer.getWhat()); //adds to the board
                System.out.println("\n" + computer.display()); // displays the board after the computer moves

            }

            catch (YouCantPutThatThere ex) { //catches the error when the bucket is not EMPTY
                System.err.println(ex); // error mssg
                player_comp(computer); // re call method to re pick a value that is empty!
            }
        }
    }


