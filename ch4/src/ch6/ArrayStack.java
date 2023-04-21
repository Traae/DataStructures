package ch6;

import java.lang.reflect.Array;

public class ArrayStack<E> implements Stack<E> {
    // instance variable
    public static int CAPACITY=1000; // default array capacity
    private E[] data;               // generic array for storage
    private int t = -1;             // index to the top of stack

    // constructors
    public ArrayStack() { this(CAPACITY);}
    public ArrayStack(int capacity) {
        data = (E[]) new Object[CAPACITY]; //(E[]) new Object[capacity];
    }

    // access methods
    public int size() { return t+1; }
    public boolean isEmpty() { return (t==-1); }
    public E top() {
        if (isEmpty()) {return null;}
        return data[t];
    }
    // update/ methods
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
        // t++;
    }
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t--] = null;
        // t--;
        return answer;
    }



    public static void main (String[] args) {
        ArrayStack<Integer> S = new ArrayStack<>();
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
