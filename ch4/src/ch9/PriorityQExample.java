package ch9;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQExample {
    public static  void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        // add to our diddy
        numbers.add(750);
        numbers.add(550);
        numbers.add(123);
        numbers.add(999);


        // remove items from our PQ numbers
        while (!numbers.isEmpty()) {
            System.out.println(numbers.remove());
        }

        // custom compare for string length instead of alphabetic
        Comparator<String> stringlenght = new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if ((s.length() - t1.length()) != 0) {
                    return (s.length() - t1.length());
                }
                else { return s.compareTo(t1); }
            }
        };
        // makes a new PQ for strings
        PriorityQueue<String> namePQ = new PriorityQueue<>(stringlenght);
        // enque
        namePQ.add("ass");
        namePQ.add("tities");
        namePQ.add("charming personality");
        namePQ.add("cute smile");
        namePQ.add("not an idiot");
        namePQ.add("demonic powers");

        while (!namePQ.isEmpty()) {
            System.out.println(namePQ.remove());
        }


        // PQ requires defined objects that either uses
        // the comparable infterface
        // or has a custome comparator


        PriorityQueue<employee> employeesPQ = new PriorityQueue<>();
        // add employees
        employeesPQ.add(new employee("Bob", 123));
        employeesPQ.add(new employee("Spam", 987));
        employeesPQ.add(new employee("Sam", 789));
        employeesPQ.add(new employee("Jack", 879));
        employeesPQ.add(new employee("Jill", 425));
        employeesPQ.add(new employee("Bro", 245));
        employeesPQ.add(new employee("Hoe", 542));
        employeesPQ.add(new employee("Joe", 321));
        employeesPQ.add(new employee("Bill", 231));
        while (!employeesPQ.isEmpty()) {
            System.out.println(employeesPQ.remove());
        }

    }
}
