package HW4;

import java.util.Iterator;

public interface MyIteratorInterface<T> extends Iterator<T> {
    void reset();
    T next();
    boolean hasNext();
    T getCurrent();
    void remove();
    void insertBefore(T value);
    void insertAfter(T value);
}
