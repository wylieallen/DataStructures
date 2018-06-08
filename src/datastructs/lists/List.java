package datastructs.lists;

public interface List<T>
{
    T getHead();
    T getTail();
    T get(int index) throws IndexOutOfBoundsException;
    T remove(int index) throws IndexOutOfBoundsException;
    void remove(T value);
    void append(T value);
    void prepend(T value);
    int getSize();
    int count(T value);
    boolean contains(T value);
}
