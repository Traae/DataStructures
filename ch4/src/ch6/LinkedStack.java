package ch6;

import Ch.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
    // instance
    private Ch.SinglyLinkedList<E> list = new SinglyLinkedList<E>();


    // constructor
    public LinkedStack() { }

    // access
    public int size() { return list.size(); }
    public  boolean isEmpty() {return list.isEmpty(); }
    public E top() {return list.first();}

    // update
    public E pop() { return list.removeFirst();}
    public void push(E e) { list.addFirst(e);}

    public static void main(String[] args) {
        LinkedStack<Integer> S = new LinkedStack<>();
        S.push(5);
        S.push(9);
        System.out.println("Size: " + S.size());
        System.out.println("Top: " + S.pop());
        System.out.println("Empty? " + S.isEmpty());
        System.out.println("Top: " + S.pop());
        System.out.println("Empty? " + S.isEmpty());
        S.push(11);
        S.push(19);
    }
}
