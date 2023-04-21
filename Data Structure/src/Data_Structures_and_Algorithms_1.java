import java.util.Scanner;

public class Data_Structures_and_Algorithms_1 {
    public static void main(String[] args) {
        System.out.println("Hello Mother Fucker."); // basic "hellow world" statement for funsies.
    /*
        boolean boolName = true;
        char charName = 'A';
        int intName = 23;
        float floatName = 3.14F; // floats need an 'F' in the value

        Counter c; // declare my counter class
        c = new Counter(5); // construct it.
        c.increment(3);
        System.out.println("The value of count is: " + c.getcount());
        c.reset();
        System.out.println(c.getcount());
        Counter d = new Counter(10);
        System.out.println("The value of the D count is:" + d.getcount());
        Counter e = d;
        System.out.println("Values of e " + e.getcount() + "value of d " + d.getcount());
        e.increment();
        System.out.println("Values of e " + e.getcount() + "value of d " + d.getcount());
        e.increment(26);
        System.out.println("Values of e " + e.getcount() + "value of d " + d.getcount());

        // Arrays
        int[] primes = {2,3,5,7,11,13,17,19,23,29};   // declare an intialized the array 'primes"
        System.out.println(primes[0]);
        double[] measurments = new double[1000]; // declare and initialize a list of doubles at leght 1000, all 0's

        //enums
        Day today;
        today = Day.Thur;
        System.out.println(today);

     */
        double d1 = 3.99999999999999;
        int i1 = (int)(d1);   // truncate style conversion.
        System.out.println(d1);
        System.out.println(i1);
        float f1 = (float)i1;
        System.out.println(f1);
        if (d1 < i1)
            System.out.println("fuck");
        else
            System.out.println("No curlys");

        for ( int i=0; i<10; i++) {
            System.out.println(i);
        }

        int[] primes = {2,3,5,7,11,13,17,19,23,29};
        for (int nummy : primes) {
            System.out.print(nummy);
        }

        Scanner input = new Scanner (System.in);
        System.out.println("Enter an int: ");
        int babys = input.nextInt();
    }

    // enum
    public enum Day { mon, Tue, Wed, Thur, Fri , Sat, Sun};
}
