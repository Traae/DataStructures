// Traae Bloxham
// Dr. Kerby
// Data Structures
// 3/5/2020


package ch7;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class homework5 {
    // instance variables
    int testNUM = 100000;
    private ArrayList<Integer> ALtester;
    private ArrayDeque<Integer> ADtesters;
    private LinkedList<Integer> LLtester;

    // constructor
    public homework5() {
        ALtester = new ArrayList<Integer>();
        ADtesters = new ArrayDeque<Integer>();
        LLtester = new LinkedList<Integer>();
    }

    // THe functions doing the stuff
    // linked list function
        // add to front  n=[100 000, 200 000, 400 000, 800 000]
        //add to back n=[1 000 000, 2 000 000, 4 000 000, 8 000 000]
        // add to middle n=[25 000, 50 000, 100 000, 200 000]
    public void LL() {
        // fill the tester a little
        LLtester.addFirst(1);
        LLtester.addFirst(1);
        LLtester.addFirst(1);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<testNUM; i++){
            // each one is adding the I variable, just because.
            LLtester.addFirst(i);

            // each of these functions has the add to front, back, middle in the same loop
            // but commented out. I just uncommented when needed.

            //LLtester.addLast(i);

            //int middle = LLtester.size() / 2;
            //LLtester.add(middle,i);

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time LL took: " + (endTime - startTime));
    }

    // array list function
        // add to front n=[100 000, 200 000, 400 000, 800 000]
        // add too back n=[1 000 000, 2 000 000, 4 000 000, 8 000 000]
        // add to middle n=[25 000, 50 000, 100 000, 200 000]
    public void AL() {
        // fill the tester a little
        ALtester.add(1);
        ALtester.add(1);
        ALtester.add(1);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<testNUM; i++){

            ALtester.add(i);

            //int last = ALtester.size() - 1;
            //ALtester.add(last, i);

            //int middle = ALtester.size() / 2;
            //ALtester.add(middle, i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time AL took: " + (endTime - startTime));
    }

    // array deque func
        // add to front n=[100 000, 200 000, 400 000, 800 000]
        // add to back n=[1 000 000, 2 000 000, 4 000 000, 8 000 000]
        // add to middle n/a
    public void AD() {
        // fill the tester a little
        ADtesters.addFirst(1);
        ADtesters.addFirst(1);
        ADtesters.addFirst(1);
        long startTime = System.currentTimeMillis();
        for (int i=0; i<testNUM; i++){

            ADtesters.addFirst(i);

            //ADtesters.addLast(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("time AD took: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        // main calls each function.
        // each is just a timed for loop of the operation for that structure
        // I jsut wanted to practice abstracting stand alone functions in java
        homework5 test = new homework5();
        test.LL();
        test.AD();
        test.AL();
    }
}
