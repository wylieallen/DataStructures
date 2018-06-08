package datastructs.lists;

public interface List<T>
{
    T getHead();
    T getTail();
    T get(int index);
    T remove(int index);
    void remove(T value);
    void append(T value);
    void prepend(T value);
    int getSize();
    int count(T value);
    boolean contains(T value);
}
