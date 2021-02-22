package HW4;

import HW3.QueueInterface;

public class LinkedListQueue<T> implements QueueInterface<T> {
    private final TwoSidedMyLinkedList<T> list;

    public LinkedListQueue() {
        this.list = new TwoSidedMyLinkedList<>();
    }

    @Override
    public boolean insert(T value) {
        list.insertFirst(value);
        return true;
    }

    @Override
    public T remove() {
        return list.removeLast();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
