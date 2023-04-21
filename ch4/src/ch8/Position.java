package ch8;

public interface Position<E> {
    E getElement() throws IllegalStateException;
}
