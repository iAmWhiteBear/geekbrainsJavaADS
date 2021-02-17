package HW4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements LinkedListInterface<T>{
    protected int size;
    protected Node<T> firstElement;

    @Override
    public void insertFirst(T value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) return null;
        Node<T> removedElement = firstElement;
        firstElement = removedElement.next;
        removedElement.next = null;
        size--;
        return removedElement.item;
    }

    @Override
    public boolean remove(T value) {
        Node<T> current = firstElement;
        Node<T> previous = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(T value) {
        Node<T> current = firstElement;
        while(current!=null){
            if (current.next.equals(value)) return true;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void display() {
        Node<T> next = firstElement;
        while (next!=null) {
            System.out.println(next.item);
            next = next.next;
        }
    }

    @Override
    public T getFirst() {
        return firstElement.item;
    }


    /**
     *
     * ITERATOR
     */


    public Iterator<T> iterator(){
        return new MyIterator();
    }

    private class MyIterator implements MyIteratorInterface<T> {
        private Node<T> cursor;
        private Node<T> prev;

        public MyIterator() {
            this.cursor = MyLinkedList.this.firstElement;
        }

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T getCurrent() {
            return cursor.item;
        }

        @Override
        public void reset() {
             cursor = MyLinkedList.this.firstElement;
             prev = null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node<T> result = cursor;
            prev = cursor;
            cursor = result.next;
            return result.item;
        }

        @Override
        public void remove() {
            Node<T> next = cursor.next;
            MyLinkedList.this.remove(cursor.item);
            cursor = next;
        }

        @Override
        public void insertBefore(T value) {
            if (prev==null){
                MyLinkedList.this.insertFirst(value);
            } else{
                Node<T> before = new Node<>(value,prev.next);
                prev.next = before;
                prev = before;
            }

        }

        @Override
        public void insertAfter(T value) {
            if (cursor == null){
                prev.next = new Node<>(value, null);
            }else{
                cursor.next = new Node<>(value, cursor.next);
            }

        }

    }
}