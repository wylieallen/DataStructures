package datastructs.stacks;

public interface Stack<T>
{
    T pop();
    T peek();
    void push(T value);
    int getSize();
}
