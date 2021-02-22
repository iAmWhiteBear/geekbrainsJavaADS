package HW4;

import java.util.Iterator;

public interface LinkedListInterface<T> extends Iterable<T> {

    void insertFirst(T value);

    T removeFirst();

    boolean remove(T value);

    boolean contains(T value);

    int size();

    boolean isEmpty();

    void display();

    T getFirst();


    class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }

        public Node(T item, Node<T> next){
            this.next = next;
            this.item = item;
        }

    }
}
