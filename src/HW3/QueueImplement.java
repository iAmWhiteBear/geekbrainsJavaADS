package HW3;

public class QueueImplement<T> implements QueueInterface<T> {
    private final T[] data;
    private int size;

    private int head;
    private int tail;


    @SuppressWarnings("unchecked")
    public QueueImplement(int limit) {
        this.data = (T[]) new Object[limit];
        tail = -1;
    }


    @Override
    public boolean insert(T value) {
        if (isFull()) return false;
        if (tail == data.length - 1) tail = -1;
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) return null;
        if (head == data.length) head = 0;
        T value = data[head];
        data[head++] = null;
        size--;
        return value;
    }

    @Override
    public T peek() {
        return data[head];
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
    public boolean isFull() {
        return size==data.length;
    }
}
