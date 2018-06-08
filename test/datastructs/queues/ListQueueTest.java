package datastructs.queues;

import datastructs.lists.SinglyLinkedList;

public class ListQueueTest extends AbstractQueueTest
{
    protected Queue<String> makeQueue()
    {
        return new ListQueue<>(new SinglyLinkedList<>());
    }
}
