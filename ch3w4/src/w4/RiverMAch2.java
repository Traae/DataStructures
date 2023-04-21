package w4;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class RiverMAch2 {

    public DoubleLinkList<animal> riverAniDLL = new DoubleLinkList<>();
    public DoubleLinkList<animal> movingAni = new DoubleLinkList<>();
    public int riverSize;
    // constructor for the river object
    public RiverMAch2() {
        // hard code the river size
        riverSize = 320000;
        // use a for loop to fill the river array with animal objects
        for (int count = 0; count < riverSize; count++) {
            // create the primary river, and a 2nd river for managing movement
            animal newAnimal = new animal();
            riverAniDLL.addFirst(newAnimal);
            movingAni.addFirst(newAnimal);
        }
    }

    // main
    public static void main(String[] args) {

        // create a scanner for  uses later
        Scanner input = new Scanner(System.in);
        // create my river
        RiverMAch2 myRiver = new RiverMAch2();
        //main menu
        System.out.println("Welcome to river sim.");
        long startTime = System.currentTimeMillis();
        boolean quit = false;
        while (quit == false) {

                // create my counts and flags
                int fishCount = 0;
                int bearCount = 0;
                boolean fishFlag = false;
                boolean bearFlag = false;
                // create a new animal, and shift the list up by one.
                animal moveIt = new animal();
                myRiver.movingAni.removeFirst();
                myRiver.movingAni.addLast(moveIt);

                for (int i = 0; i < myRiver.riverSize; i++) {
                        // create an animal to take
                        animal riverAni;
                        animal movAni;
                        // take take the front from each
                        riverAni = myRiver.riverAniDLL.removeFirst();
                        movAni = myRiver.movingAni.removeFirst();
                        // check it's type and add to count
                        if (riverAni.getAnimalValue() == 1) { fishCount++; }
                        else if (riverAni.getAnimalValue() == 2) { bearCount++;}
                        // create a move variable

                        // check it's value against its current value
                        if (movAni.getAnimalValue() > riverAni.getAnimalValue()) {
                            riverAni.setAnimalValue(movAni.getAnimalValue());
                        }
                        // if there the same, it creates a new one by setting a flag
                        else if (movAni.getAnimalValue() == riverAni.getAnimalValue()) {
                            if (riverAni.getAnimalValue() == 1) { fishFlag = true; }
                            else if (riverAni.getAnimalValue() == 2){ bearFlag = true; }
                        }

                        // when there is an empty space, fill it in with flagged animal
                        if (riverAni.getAnimalValue() == 0) {
                            if (fishFlag == true) {
                                riverAni.setAnimalValue(1);
                                fishFlag = false;
                            } else if (bearFlag == true) {
                                riverAni.setAnimalValue(2);
                                bearFlag = false;
                            }
                        }
                        myRiver.riverAniDLL.addLast(riverAni);
                        myRiver.movingAni.addLast(movAni);
                }
            if (fishCount < myRiver.riverSize/50) { bearCount = bearCount + fishCount;}
            System.out.println("Fish in the river: " + fishCount);
            System.out.println("Bear's in the River: " + bearCount);

            if (bearCount >= myRiver.riverSize) {
                System.out.println("ALL BEARS!");
                quit = true;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time computation took: " + (endTime - startTime));
    }
}