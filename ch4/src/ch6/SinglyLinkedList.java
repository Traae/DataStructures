package Ch;

public class SinglyLinkedList<E> {
    // Nested Node class
    private static class Node<E> {
        // Instance variables
        private E element; // the element stored at this node/cell
        private Node<E> next; // reference to next node/cell
        // Constructor
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }
        // Access methods
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        // Update method
        public void setNext(Node<E> n) { next = n; }
    } // end of nested Node class

    // Instance variables for SinglyLinkedList
    private Node<E> head = null; // head node of list (or null if empty)
    private Node<E> tail = null; // tail node of list (or null if empty)
    private int size = 0; // number of nodes in the list
    // Constructor
    public SinglyLinkedList() {} // construct an initially empty list
    // Access methods
    public int size() { return size; }
    public boolean isEmpty() { return size==0; }
    public E first() { // return element of first node (head)
        if (isEmpty()) return null;
        return head.getElement();
    }
    public E last() { // return element of last node (tail)
        if (isEmpty()) return null;
        return tail.getElement();
    }
    // Update methods
    public void addFirst(E e) { // add element e to the front of the list
        head = new Node<>(e, head);
        if (size==0) {
            tail = head; // special case of just one node
        }
        size++;
    }
    public void addLast(E e) { // add element e to the end of the list
        Node<E> newest = new Node<>(e, null); // our new tail
        if (isEmpty()) {
            head = newest; // special case of just one node
        }
        else {
            tail.setNext(newest); // point old tail to new tail
        }
        tail = newest; // new node becomes tail
        size++;
    }
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size==0) {
            tail = null; // special case of one node (before removing first)
        }
        return answer;
    }
    public String toString() {
        String out = "Singly Linked List: \n";
        out += "0 " + head.getElement() + "\n";
        Node<E> nextnode;
        nextnode = head.getNext();
        for (int i=1; i<this.size; i++) {
            out += Integer.toString(i) + " " + nextnode.getElement() + "\n";
            nextnode = nextnode.getNext();
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("I compiled.");
        SinglyLinkedList<String> names = new SinglyLinkedList<>();
        System.out.println(names.size());
        names.addLast("Leslie");
        System.out.println(names.size());
        names.addLast("Eric");
        names.addLast("Emily");
        System.out.println(names);

        names.addFirst("Joseph");
        System.out.println(names);

        names.removeFirst();
        System.out.println(names);
    }
}


