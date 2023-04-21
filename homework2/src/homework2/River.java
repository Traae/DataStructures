package homework2;

import java.util.Arrays;
import java.util.Scanner;

public class River {

    // instance variables for river object
    public int river_space = 320000;
    public animal[] riverOfAnimals = new animal[river_space];
    public int[] animalMoves = new int[river_space];
    public animal[] movingAnimals = new animal[river_space];
    public int turnCount;
    public int maxBears;

    // constructor for the river object
    public River(){
        turnCount = 0;
        maxBears = 1;
        // use a for loop to fill the river array with animal objects
        for (int count = 0; count < river_space; count++) {
            // create the primary river, and a 2nd river for managing movement
            riverOfAnimals[count] = new animal();
            movingAnimals[count] = new animal();
            // then rewrite the 2nd river to match the first.
            movingAnimals[count].setAnimalValue(riverOfAnimals[count].getAnimalValue());
        }
    }

    // generate moves
    public void makeMoves(){
        for (int fl1=0; fl1<river_space; fl1++) {
            // generate all hte animals moves
            animalMoves[fl1] = riverOfAnimals[fl1].getMovement();
        }
    }

    // reconcile the moves
    public void moveTheAnimals() {
        // make sure the ends don't move out of index
        if (animalMoves[0] == -1) { animalMoves[0]++; }
        if (animalMoves[river_space-1] == 1) { animalMoves[river_space-1]--;}
        for (int fl=0; fl<river_space; fl++) {
            // take current value of river of animals
            // and place it into the new postion of moving animals
            // by adding the value of animalmoves to movinganimals index
            movingAnimals[fl+animalMoves[fl]].setAnimalValue(riverOfAnimals[fl].getAnimalValue());
            // if the animal did move, it leaves a null behind
            if (animalMoves[fl] != 0) { movingAnimals[fl].setAnimalValue(0); }
        }
        for (int fl=0; fl<river_space; fl++) {
            if (movingAnimals[fl].getAnimalValue() > riverOfAnimals[fl].getAnimalValue()) {
                riverOfAnimals[fl].setAnimalValue(movingAnimals[fl].getAnimalValue());
            }
            else if (movingAnimals[fl].getAnimalValue() == riverOfAnimals[fl].getAnimalValue()) {
                for (int fl2=0; fl2<river_space; fl2++) {
                    if (riverOfAnimals[fl2].getAnimalValue() == 0) {
                        riverOfAnimals[fl2].setAnimalValue(movingAnimals[fl].getAnimalValue());
                        break;
                    }
                }
            }
        }

    }

    // check for all bears
    public int statscheck (){
        int bearCount = 0;
        int fishCount = 0;
        for (int fl=0; fl<river_space; fl++){
            if (riverOfAnimals[fl].getAnimalValue() == 2) { bearCount++; }
            if (riverOfAnimals[fl].getAnimalValue() == 1) { fishCount++; }
        }
        if ((fishCount < (river_space/50)) || (turnCount > river_space/50)){bearCount = bearCount + fishCount;}
        System.out.println("Turn: " + turnCount);
        System.out.println(bearCount + " Bears.");
        System.out.println(fishCount + " Fish");
        return bearCount;
    }

    // get maxbears
    public int getMaxBears(){return maxBears;}

    // a function for passing a turn
    public void passtime() {
        makeMoves();
        moveTheAnimals();
        turnCount++;
        maxBears = statscheck();
    }

    // main
    public static void main(String[] args) {
        // create a scanner for  uses later
        Scanner input = new Scanner(System.in);
        // create my river
        River myRiver = new River();

        //main menu
        System.out.println("Welcome to river sim.");
//        System.out.println("Enter the number of your choice");
//        System.out.println("1. Turn by Turn");
//        System.out.println("2. Automatic till Collapse");
//        int menuOption = input.nextInt();
        int menuOption = 2;
        int numTurns = 0;

        long startTime = System.currentTimeMillis();


        // I have no safety checks, be careful;
        while (menuOption == 1) {
            System.out.println("How many turns do you want to pass?");
            numTurns = input.nextInt();
            while (numTurns > 0) {
                myRiver.passtime();
                numTurns--;
                if (myRiver.getMaxBears() == myRiver.river_space ) {break;}
            }
            if (myRiver.getMaxBears() == myRiver.river_space) {break;}
        }
        while (menuOption == 2) {
            myRiver.passtime();
            if (myRiver.getMaxBears() == myRiver.river_space) {break;}
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time computation took: " + (endTime - startTime));
    }
}
