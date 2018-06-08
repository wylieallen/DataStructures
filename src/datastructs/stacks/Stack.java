package datastructs.stacks;

public interface Stack<T>
{
    T pop() throws UnsupportedOperationException;
    T peek();
    void push(T value);
    int getSize();
}
