package datastructs.queues;

import datastructs.lists.SinglyLinkedList;
import datastructs.queues.StacksQueue;
import datastructs.stacks.ListStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StacksQueueTest extends AbstractQueueTest
{
    protected Queue<String> makeQueue()
    {
        return new StacksQueue<>(new ListStack<>(new SinglyLinkedList<>()),
                new ListStack<>(new SinglyLinkedList<>()));
    }
}
