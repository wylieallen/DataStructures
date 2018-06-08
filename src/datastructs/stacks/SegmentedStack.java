package datastructs.stacks;

import datastructs.lists.SinglyLinkedList;

public class SegmentedStack<T> implements Stack<T>
{
    private Stack<Stack<T>> stacks;
    private final int maxSize;

    public SegmentedStack(int maxSize)
    {
        this.stacks = new ListStack<>(new SinglyLinkedList<>());
        if(maxSize <= 0) maxSize = 1;
        this.maxSize = maxSize;
        stacks.push(new ListStack<>(new SinglyLinkedList<>()));
    }

    public T peek()
    {
        return stacks.peek().peek();
    }

    public T pop() throws UnsupportedOperationException
    {
        T value = stacks.peek().pop();
        if(stacks.getSize() > 1 && stacks.peek().getSize() == 0)
        {
            stacks.pop();
        }
        return value;
    }

    public void push(T value)
    {
        if(stacks.peek().getSize() == maxSize)
        {
            stacks.push(new ListStack<>(new SinglyLinkedList<>()));
        }
        stacks.peek().push(value);
    }

    public int getSize()
    {
        return (stacks.getSize() - 1) * maxSize + stacks.peek().getSize();
    }

    public int getSegmentCount() { return stacks.getSize(); }

    public int getMaxSize() { return maxSize; }
}
