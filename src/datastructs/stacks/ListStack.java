package datastructs.stacks;

import datastructs.lists.List;

public class ListStack<T> implements Stack<T>
{
    private List<T> list;

    public ListStack(List<T> list)
    {
        this.list = list;
    }

    public void push(T value)
    {
        list.prepend(value);
    }

    public T peek() throws UnsupportedOperationException
    {
        if(getSize() <= 0)
        {
            throw new UnsupportedOperationException();
        }

        return list.getHead();
    }

    public T pop() throws UnsupportedOperationException
    {
        if(getSize() <= 0)
        {
            throw new UnsupportedOperationException();
        }

        return list.remove(0);
    }

    public int getSize() { return list.getSize(); }
}
