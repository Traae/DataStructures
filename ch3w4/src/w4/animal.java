

import java.util.Random;

public class animal {

    // instance variables
    private int animalValue;

    // constructors
    public animal() {
        // if no animal value is passed it, it will randomly generate one.
        Random newAnimalValue = new Random();
        animalValue = newAnimalValue.nextInt(3);

    }

    public void setAnimalValue(int newValue) {
        this.animalValue = newValue;
    }

    // getters
    public int getAnimalValue() { return animalValue;  }
    public String getType() {
        switch(animalValue) {
            case 0: return "null";
            case 1: return "Fish";
            case 2: return "Bear";
        }
        return null;
    }

    public int getMovement() {
        // create a random to determine the direction of movement 3 options
        Random upDownStickAround = new Random();
        int move = 0;
        // if the animal isn't null, then creat a move
        if (animalValue != 0) {
            move = upDownStickAround.nextInt(3);
            // next the value is modified by -1
            move = move - 1;
            // so, end results are:
            //  -1, 0, 1  to be implimented as
            // go up an index of the array, stay put, and go down, respectivley.
        }
        return move;
    }


}
