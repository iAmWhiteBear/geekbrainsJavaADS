package HW3;

public interface StackInterface<T> {
    void push(T value);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

    boolean isFull();

    void display();
}
