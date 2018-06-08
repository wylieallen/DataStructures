package datastructs.queues;

public interface Queue<T>
{
    T pop() throws UnsupportedOperationException;
    T peek();
    void push(T value);
    int getSize();
}
