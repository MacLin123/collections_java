package com.mycompany.list;

/**
 * Interface for working with linked lists
 * @param <E>
 */
public interface ILinkedList<E> extends Iterable<E> {
    void add(E element);
    void add(int index,E element);
    void clear();
    E get(int index);
    int indexOf(E element);
    E remove(int index);
    E set(int index, E element);
    int size();
    <T> T[] toArray(T[] a);
    String toString();
}
