package datastructs.queues;

import datastructs.lists.List;

public class ListQueue<T> implements Queue<T>
{
    private List<T> list;

    public ListQueue(List<T> list)
    {
        this.list = list;
    }

    public int getSize() { return list.getSize(); }

    public T peek()
    {
        return list.getHead();
    }

    public T pop() throws UnsupportedOperationException
    {
        try
        {
            return list.remove(0);
        }
        catch(IndexOutOfBoundsException e)
        {
            throw new UnsupportedOperationException();
        }
    }

    public void push(T value)
    {
        list.append(value);
    }
}
