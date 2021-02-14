package HW3;

public interface QueueInterface<T> {
    boolean insert(T value);

    T remove();

    T peek();

    int size();

    boolean isEmpty();

    boolean isFull();
}
