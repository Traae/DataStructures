package Ch6;

public interface Stack<E> {
    // Accessor methods
    int size(); // Returns # elements in stack
    boolean isEmpty(); // True if stack is empty
    E top(); // Peek at, return, top (last) element but do not remove
    // Update methods
    E pop(); // Return and remove top (last) element
    void push(E e); // Add element to the (top/end of) stack
}
