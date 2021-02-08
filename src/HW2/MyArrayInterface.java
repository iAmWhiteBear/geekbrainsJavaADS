package HW2;

public interface MyArrayInterface<E> {
    void add(E value);
    E get(int index);
    boolean remove(E value);
    boolean remove(int index);
    int indexOf(E value);
    boolean contains(E value);
    int size();


    void bubbleSort();
    void selectSort();
    void insertSort();
}
