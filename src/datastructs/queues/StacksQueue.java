package datastructs.queues;

import datastructs.stacks.Stack;

public class StacksQueue<T> implements Queue<T>
{
    private Stack<T> forward, reverse;

    public StacksQueue(Stack<T> forward, Stack<T> reverse)
    {
        this.forward = forward;
        this.reverse = reverse;
    }

    public T peek()
    {
        return forward.peek();
    }

    public void push(T value)
    {
        while(forward.getSize() > 0)
        {
            reverse.push(forward.pop());
        }
        reverse.push(value);

        while(reverse.getSize() > 0)
        {
            forward.push(reverse.pop());
        }
    }

    public T pop()
    {
        return forward.pop();
    }

    public int getSize() { return forward.getSize(); }
}
