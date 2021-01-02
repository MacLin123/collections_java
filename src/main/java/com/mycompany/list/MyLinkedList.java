package com.mycompany.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Singly linked list Implementation
 *
 * @param <E>
 */
public class MyLinkedList<E> implements ILinkedList<E> {
    private static class Node<E> {
        E element;
        Node<E> nextNode;

        Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(element, node.element);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIter();
    }

    class MyLinkedListIter implements Iterator<E> {
        private Node<E> lastReturned;
        private Node<E> next;
        private int nextIndex;

        MyLinkedListIter() {
            next = first;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.nextNode;
            nextIndex++;
            return lastReturned.element;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                Arrays.toString(toArray()) +
                '}';
    }

    @Override
    public void add(E element) {
        if (isEmpty()) {
            first = last = new Node<>(element, null);
        } else {
            last.nextNode = new Node<>(element, null);
            last = last.nextNode;
        }
        size++;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void add(int index, E element) {
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
        } else {
            Node<E> cur = first;
            Node<E> prev = null;
            for (int i = 0; i < index; i++) {
                if (i == (index - 1)) {
                    prev = cur;
                }
                cur = cur.nextNode;
            }
            if (prev != null) {
                prev.nextNode = new Node<>(element, cur);
            } else {
                first = new Node<>(element, cur);
            }
            size++;
        }
    }

    @Override
    public void clear() {
        for (Node<E> node = first; node != null; ) {
            Node<E> next = node.nextNode;
            node.nextNode = null;
            node.element = null;
            node = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        E result = null;
        for (E elem : this) {
            if (i == index) {
                result = elem;
                break;
            }
            i++;
        }
        return result;
    }

    @Override
    public int indexOf(E element) {
        Node<E> cur = first;
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (cur.element.equals(element)) {
                result = i;
                break;
            }
            cur = cur.nextNode;
        }
        return result;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> cur = first;
        Node<E> prev = null;
        Node<E> next;
        for (int i = 0; i < index; i++) {
            if (i == (index - 1)) {
                prev = cur;
            }
            cur = cur.nextNode;
        }
        next = cur.nextNode;
        if (prev != null) {
            prev.nextNode = next;
        } else {
            first = next;
        }
        if (isEmpty()) {
            first = last = null;
        }
        if (index == (size - 1)) {
            last = prev;
        }

        cur.nextNode = null;
        size--;
        return cur.element;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> cur = first;
        for (int i = 0; i < index; i++) {
            cur = cur.nextNode;
        }
        cur.element = element;
        return cur.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        E[] result = (E[]) new Object[size];
        int i = 0;
        for (E elem : this) {
            result[i++] = elem;
        }
        return result;
    }
}
