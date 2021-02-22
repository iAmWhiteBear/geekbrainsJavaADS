package HW4;

import HW3.StackInterface;

public class LinkedListStack<T> implements StackInterface<T> {

    private final MyLinkedList<T> list;

    public LinkedListStack() {
        this.list = new MyLinkedList<>();
    }

    @Override
    public void push(T value){
        list.insertFirst(value);
    }

    @Override
    public T pop(){
        return list.removeFirst();
    }

    @Override
    public T peek(){
        return list.getFirst();
    }

    @Override
    public int size(){
        return list.size();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public boolean isFull(){
        return false;
    }

    @Override
    public void display(){
        list.display();
    }
}
