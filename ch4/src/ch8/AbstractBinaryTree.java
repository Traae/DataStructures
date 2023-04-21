package ch8;

import java.util.ArrayList;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
                                            implements BinaryTree<E> {
    // returns the position of p's sibling (or null if none)
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent==null) return null; // check if p is root
        if (p==left(parent))
            return right(parent);
        else
            return left(parent);
    }
    // returns the number of children of Position p
    public int numChildren(Position<E> p) {
        int count=0;
        if (left(p)!=null)
            count++;
        if (right(p)!=null)
            count++;
        return count;
    }
    // returns an iterable collection of the Positions of p's children
    public Iterable<Position<E>> children(Position<E> p) {
        ArrayList<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p)!=null)
            snapshot.add(left(p));
        if (right(p)!=null)
            snapshot.add(right(p));
        return snapshot;
    }
}
