package HW3;

public class StackImplement<T> implements StackInterface<T> {
    private final T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImplement(int limit) {
        this.data = (T[]) new Object[limit];
    }

    @Override
    public void push(T value) {
        data[size++] = value;
    }

    @Override
    public T pop() {
        return isEmpty()?null:data[--size];
    }

    @Override
    public T peek() {
        return isEmpty()?null:data[size-1];
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

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            stringBuilder.append(", ");
        }
        stringBuilder.append("[");
        return stringBuilder.toString();
    }
}
