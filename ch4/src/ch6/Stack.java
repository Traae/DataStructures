package ch6;

public interface Stack<E> {
    // accessor methods
    int size(); // returns # of elements
    boolean isEmpty(); // true is stack is empty
    E top(); // Peek at, return, top/last element, not remove
    //update methods
    E pop(); // return ans remove the top elements
    void push(E e); // add element
}
