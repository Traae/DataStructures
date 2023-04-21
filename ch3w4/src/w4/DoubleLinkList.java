package w4;

public class DoubleLinkList<E> {
    // nested node class
    private static class node<E> {
        // a number for referencing the nodes index in the list
        private E element; // the element stored at this node/cell
        private DoubleLinkList.node<E> next; // reference to next node
        private DoubleLinkList.node<E> prior; // reference for the prior node
        // constructor
        public node(E e, DoubleLinkList.node<E> p, DoubleLinkList.node<E> n) {
            element = e;
            next = n;
            prior = p;
        }
        // access methods
        public E getElement() { return element; }
        public DoubleLinkList.node<E> getNext() {return next; }
        public DoubleLinkList.node<E> getPrior() {return prior;}

        // update method
        public void setNext(DoubleLinkList.node<E> n) { next = n; }
        public void setPrior(DoubleLinkList.node<E> p) {prior = p; }

    }  // end of node class

    // instance varibale for list class
    private DoubleLinkList.node<E> head; // head node of list or null if empty
    private DoubleLinkList.node<E> tail; // same for tail node
    private int size = 0; // number of nodes
    //constructor
    public DoubleLinkList() {
        head = new node<>(null, null, null);
        tail = new node<>(null, head, null);
        head.setNext(tail);
    }
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
        addBetween(e, head, head.getNext());
    }
        public void addLast(E e) {
        addBetween(e, tail.getPrior(), tail);
    }
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) { return null;}
        return remove(head.getNext());
    }
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(tail.getPrior());
    }
    private void addBetween(E e, node<E> predecessor, node<E> succerssor) {
        node<E> newest = new node<E>(e, predecessor, succerssor);
        predecessor.setNext(newest);
        succerssor.setPrior(newest);
        size++;
    }
    private E remove(node<E> node) {
        node<E> predecessor = node.getPrior();
        node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrior(predecessor);
        size--;
        return node.getElement();
        }



    public String toString() {
        String out = "Doubly Linked List: \n";
        out += "0 " + head.getElement() + "\n";
        DoubleLinkList.node<E> nextnode;
        nextnode = head.getNext();
        for (int i=1; i<size; i++) {
            out += Integer.toString(i) + " " + nextnode.getElement() + "\n";
            nextnode = nextnode.getNext();
        }
        return out;
    }



    // doublelinklist class
}
