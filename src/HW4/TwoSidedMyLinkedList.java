package HW4;

public class TwoSidedMyLinkedList<T> extends MyLinkedList<T> implements LinkedListInterface<T>{
    protected Node<T> lastElement;

    @Override
    public void insertFirst(T value) {
        Node<T> first = new Node<>(value, null, firstElement);
        if (!isEmpty()) {
            firstElement.prev = first;
        }
        firstElement = first;
        size++;
        if (size==1) lastElement = firstElement;



    }

    public void insertLast(T value){
        Node<T> last = new Node<>(value, lastElement, null);
        if(!isEmpty()){
            lastElement.next = last;
        }
        lastElement = last;
        size++;
        if (size==1) firstElement = lastElement;
    }


    public T removeLast() {
        if(isEmpty()) return null;

        Node<T> removedElement = lastElement;
        lastElement = removedElement.prev;
        removedElement.prev = null;
        size--;
        return removedElement.item;
    }

    @Override
    public boolean remove(T value) {
        Node<T> current = firstElement;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            current = current.next;
        }

        if (current == null) return false;

        if (current == firstElement) {
            firstElement = firstElement.next;
            firstElement.prev = null;
        } else if (current == lastElement) {
            lastElement = lastElement.prev;
            lastElement.next = null;
        } else {
            current.next = current.prev;
            current.prev = current.next;
        }

        current.next = null;
        current.prev = null;
        size--;

        return true;
    }

    public T getLast(){
        return lastElement.item;
    }

}
