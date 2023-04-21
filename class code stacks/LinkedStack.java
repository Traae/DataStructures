package Ch6;

public class LinkedStack<E> implements Stack<E> {
    // Instance variables
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    // Constructors
    public LinkedStack() {}
    // Access methods
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public E top() { return list.first(); } // Assuming list is filled with addFirst()
                    // return list.last() if list is filled with addLast()
    // Update methods
    public void push(E e) { list.addFirst(e); }
    public E pop() { return list.removeFirst(); }

    public static void main(String[] args) {
        LinkedStack<Integer> S = new LinkedStack<>();
        S.push(5);
        S.push(9);
        System.out.println("Size: " + S.size());
        System.out.println("Top element: " + S.pop());
        System.out.println("Empty? " + S.isEmpty());
        System.out.println("Top element: " + S.pop());
        System.out.println("Empty? " + S.isEmpty());
        System.out.println("Top element: " + S.pop());
        S.push(11);
        S.push(19);
    }
}
