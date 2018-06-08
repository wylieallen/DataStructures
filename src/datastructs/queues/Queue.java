package datastructs.queues;

public interface Queue<T>
{
    T pop();
    T peek();
    void push(T value);
    int getSize();
}
