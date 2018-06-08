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

    public T peek() throws UnsupportedOperationException
    {
        if(getSize() <= 0) throw new UnsupportedOperationException();

        return list.getHead();
    }

    public T pop() throws UnsupportedOperationException
    {
        if(getSize() <= 0) throw new UnsupportedOperationException();

        return list.remove(0);
    }

    public void push(T value)
    {
        list.append(value);
    }
}
