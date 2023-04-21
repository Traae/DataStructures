

public class SinglyLinkedList<E> {
    // nested node class
    private static class node<E> {

        private E element; // the element stored at this node/cell
        private node<E> next; // reference to next node
        // constructor
        public node(E e, node<E> n) {
            element = e;
            next = n;
        }
        // access methods
        public E getElement() { return element; }
        public node<E> getNext() {return next; }
        // update method
        public void setNext(node<E> n) { next = n; }
    }  // end of node class

    // instance varibale for list class
    private node<E> head = null; // head node of list or null if empty
    private node<E> tail = null; // same for tail node
    private int size = 0; // number of nodes
    //constructor
    public SinglyLinkedList() {}
    // access methods
    public int size() {return size; }
    public boolean isEmpty() { return size==0;}
    public E first() { // element of first node (head)
        if (isEmpty()) {return null;}
        return head.getElement();
    }
    public E last() {   // element of last node
        if (isEmpty()) {return null;}
        return tail.getElement();
    }
    // update
    public void addFirst(E e) {  // set new to the front
        head = new node<>(e, head);
        if (size==0) { tail = head; } // special case of just one node
        size++;
    }
    public void addLast(E e) {
        node<E> newest = new node<>(e, null); // our new tail
        if (isEmpty()) { head = newest;}
        else { tail.setNext(newest);} // point oold tail to new
        tail = newest; // new node becomes tail
        size++;
    }
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) { return null;}
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size==0) {tail = null;}
        return answer;
    }
    public String toString() {
        String out = "Singly Linked List: \n";
        out += "0 " + head.getElement() + "\n";
        node<E> nextnode;
        nextnode = head.getNext();
        for (int i=1; i<size; i++) {
            out += Integer.toString(i) + " " + nextnode.getElement() + "\n";
            nextnode = nextnode.getNext();
        }
        return out;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> names = new SinglyLinkedList<>();
        names.addLast("Cak");
        System.out.println(names);


        names.addLast("Kill");
        names.addLast("Nilh");
        names.addLast("Jile");
        System.out.print(names);


        names.addFirst("FuckkerExtreme");
        System.out.println(names.toString());


        names.removeFirst();
        System.out.println(names.toString());
    }
}
