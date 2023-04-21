package ch6;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
public class DequeExample {
    public static void main(String[] args) {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        LinkedList<Integer> LL = new LinkedList<>();
        AD.addFirst(1);
        AD.addFirst(2);
        AD.addFirst(3);
        AD.addFirst(4);
        AD.addLast(5);
        AD.addLast(3);
        AD.addLast(34);
        System.out.println(AD.toString());
        System.out.println(AD.removeFirst());
        System.out.println(AD.removeLast());
        System.out.println(AD.toString());
        System.out.println(AD.toString());
        System.out.println(AD.toString());
        System.out.println(AD.toString());
        System.out.println(AD.toString());

    }
}
