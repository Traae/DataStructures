package ch8;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) { return numChildren(p)>0; }
    public boolean isExternal(Position<E> p) { return numChildren(p)==0; }
    public boolean isRoot(Position<E> p) { return p==root(); }
    public boolean isEmpty() { return size()==0; }

    // returns number of levels separating p from root (if p==root, depth=0)
    public int depth(Position<E> p) {
        if (isRoot(p)) return 0;
        else return ( 1 + depth(parent(p)) ); // recursively climb tree, adding 1 each time
    }
    // returns height of tree
    public int heightBad() { // works, but is quadratic worst-case time
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p))
                h = Math.max(h,depth(p));
        }
        return h;
    }
    // returns height of the subtree p
    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1+height(c)); // recursively descend tree, adding 1 each time
        }
        return h;
    }
}
