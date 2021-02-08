package HW2;


import java.util.Arrays;


/**
 *
 * 1. Создать массив большого размера (миллион элементов).
 * 2. Написать методы удаления, добавления, поиска элемента массива.
 * 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
 * @param <E>
 */

public class MyArray<E extends Comparable<? super E>> implements MyArrayInterface<E>, Cloneable {
    private E[] mass;
    private int size;
    private final static int defaultSize = 10000;

    public MyArray() {
        this(defaultSize);
    }

    @SuppressWarnings("unchecked")
    public MyArray(int startsize) {
        startsize = (startsize<=0)?1:startsize;
        size = 0;
        this.mass = (E[]) new Comparable[startsize];
    }

    public MyArray(E[] mass) {
        this.mass = mass;
        this.size = mass.length;
    }

    @Override
    public void add(E value) {
        expand();
        mass[size++] = value;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return mass[index];
    }

    @Override
    public boolean remove(E value) {
        return remove(indexOf(value));
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        if (index < size && index>=0){
            System.arraycopy(mass, index + 1, mass, index, size - index - 1);
            mass[--size] = null;
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size-1; i++) {
            if (value.equals(mass[i])) return i;
        }
        return -1;
    }

    @Override
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(mass[i])) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    public int realSize(){
        return mass.length;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "mass=" + Arrays.toString(mass) +
                '}';
    }


    @SuppressWarnings("unchecked")
    @Override
    protected MyArray<E> clone() throws CloneNotSupportedException {
        return (MyArray<E>) super.clone();
    }

    /************************************
     * sorts
     */
    @Override
    public void bubbleSort() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1-i; j++) {
                if (mass[j].compareTo(mass[j+1])>0)
                    swap(j,j+1);
            }
        }
    }

    @Override
    public void selectSort() {
        int min;
        for (int i = 0; i < size; i++) {
            min = i;
            for (int j = i; j < size; j++) {
                if (mass[j].compareTo(mass[min]) < 0)
                    min = j;
            }
            swap(min, i);
        }
    }

    @Override
    public void insertSort() {
        for (int i = 1; i < size; i++) {
            if (mass[i].compareTo(mass[i-1])<0){
                for (int j = i; j > 0; j--) {
                    if (mass[j].compareTo(mass[j-1])<0) swap(j,j-1);
                }
            }
        }

    }

    /*****************************************
     * service methods
     * */

    private void swap(int from, int to){
        if (from != to){
            E temp;
            temp = mass[from];
            mass[from] = mass[to];
            mass[to] = temp;
        }
    }

    private void expand(){
        if (mass.length == size){
            mass = Arrays.copyOf(mass, (int) Math.floor(1.5*size));
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >=size){
            throw new IndexOutOfBoundsException("incorrect index value: "+index);
        }
    }

}
