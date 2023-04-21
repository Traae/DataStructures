package Ch6;

public class ArrayStack<E> implements Stack<E>{
    // Instance variables
    private static int CAPACITY=1000; // default array capacity
    private E[] data;               // generic array used for storage
    private int t = -1;               // index to the top (last) element of stack
    // Constructor
    public ArrayStack() { this(CAPACITY); }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity]; // Use this because of generics
    }
    // Access methods
    public int size() { return t+1; }
    public boolean isEmpty() { return (t==-1); }
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }
    // Update methods
    public void push(E e) throws IllegalStateException{
        if (size()==data.length) throw new IllegalStateException("Stack is full.");
        data[++t] = e;
    }
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t--] = null;
        //t--;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("I compiled.");
        // ArrayStack test
        ArrayStack<Integer> S = new ArrayStack<>();
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

        /*
        long t0 = System.currentTimeMillis();
        long t1;
        for (int i=0; i<100000; i++) {
            System.out.print('*');
        }
        System.out.println();
        t1 = System.currentTimeMillis();
        System.out.println("Computation time: " + (t1-t0));
        */

    }

}
