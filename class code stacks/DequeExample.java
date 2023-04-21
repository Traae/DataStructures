package Ch6;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class DequeExample {
    public static void main(String[] args) {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        LinkedList<Integer> LL = new LinkedList<>();
        AD.addFirst(1);
        AD.addFirst(2);
        AD.addFirst(3);
        AD.addFirst(1);
        AD.addFirst(4);
        AD.addFirst(1);
        System.out.println(AD);
        AD.removeLastOccurrence(1);
        System.out.println(AD);
    }
}
