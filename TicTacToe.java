/*
Justin Gonzalez
CSC 331
Tic Tac Toe game
board file
 */

public class TicTacToe {
    static enum Vars {X, O, EMPTY}; // enums of X O AND EMPTY
    private static Vars[][] a = new Vars[3][3]; // 2d array for the board
    private String name; // name for the instances in the player file
    private String what; // mainly for the computer to set as X or O

    public TicTacToe(String name, String what){ // board constructor where we set every bucket to EMPTY enum
        this.name = name;
        this.what = what;

        for (int counter = 0; counter < a.length; counter++) {
            for (int column = 0; column < a[counter].length; column++) {
                a[counter][column] = Vars.EMPTY;
            }
        }
    }
//getters and setters down below

    public String getName(){
        return this.name;
    }

    public String getWhat(){
        return this.what;
    }

    public void setWhat(String new_what){
        this.what = new_what;
    }

    public void setName(String new_name){
        this.name = name;
    }


    public boolean hasTied() { // checks to see if the board is full
        boolean isTrue = true; // used to stop iterating through the array
        while (isTrue) {
            for (int counter = 0; counter < a.length; counter++) {
                for (int column = 0; column < a[counter].length; column++) { // going through the board
                    if (a[counter][column] == Vars.X || a[counter][column] == Vars.O){ // if the slots are X's or O's then we return True for a draw
                    }
                    else {
                        isTrue = false; // if there is still an EMPTY then we return false because the board isn't full yet

                    }
                }
            }
            return isTrue;
        }
        return isTrue;
    }

    public boolean hasWon(String x_o) { // checks to see winning conditions
        Vars what; // used to check the winning conditions if they're all the same type Such as 3 X's in a row
        if (x_o == "X"){
            what = Vars.X;
        }
        else {
            what = Vars.O;
        }

        if (a[0][0] == what && a[0][1] == what && a[0][2] == what || a[1][0] == what && a[1][1] == what // all possible horizontal winning conditions
               && a[1][2] == what || a[2][0] == what && a[2][1] == what && a[2][2] == what) {
            return true;
        }

        if (a[0][0] == what && a[1][0] == what && a[2][0] == what || a[0][1] == what && a[1][1] == // all possible vertical winning conditions
                what && a[2][1] == what || a[0][2] == what && a[1][2] == what && a[2][2] == what) {
            return true;
        }
        if (a[0][0] == what && a[1][1] == what && a[2][2] == what || a[0][2] == what && a[1][1] == // all possible diaganol winning conditions
                what && a[2][0] == what) {
            return true;
        }
        return false; // returns false if these conditions hasn't been met
    }

    public void add(int row, int column, String x_o)  throws YouCantPutThatThere { // used to add X's or O's to the board
        if (x_o == "X") { // x_o checks to see what instance is adding to the board either an X or O
            if (a[row][column] != Vars.EMPTY){ // throws the custom error if the spot the user picks isn't empty
                throw new YouCantPutThatThere("That spot is not empty!!");
            }
            else { // else puts the user input in the bucket
                a[row][column] = Vars.X;
            }
        }

        else {
            if (a[row][column] != Vars.EMPTY){ // throws the custom error if the spot the user picks isn't empty
                throw new YouCantPutThatThere("That spot is not empty!!");
            }
            else { // else puts the user input in the bucket
                a[row][column] = Vars.O;
            }
        }
    }

    public String display() { // display method
        String result = ""; // used to print out the board
        for (int counter = 0; counter < a.length; counter++) {
            for (int column = 0; column < a[counter].length; column++) {
                result = result + a[counter][column] + " ";  // goes through board row by row

            }
            result = result + "\n"; // places a new line after every row
        }
        return result; // return the string
    }


    public static void main(String[] args) { // main method

    }
}