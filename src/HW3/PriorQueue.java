package HW3;

public class PriorQueue<T extends Comparable<? super T>> implements QueueInterface<T> {

    private final T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorQueue(int size) {
        this.data = (T[]) new Comparable[size];
    }

    @Override
    public boolean insert(T value) {
        if (isFull()) {
            return false;
        }

        int index;
        for (index = size() - 1; index >= 0; index--) {
            if (value.compareTo(data[index]) > 0) {
                data[index + 1] = data[index];
            } else {
                break;
            }
        }

        data[index + 1] = value;
        size++;
        return true;
    }

    @Override
    public T remove() {
        return isEmpty() ? null : data[--size];
    }

    @Override
    public T peek() {
        return isEmpty() ? null : data[size - 1];
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
        return size == data.length;
    }
}
