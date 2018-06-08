package datastructs.stacks;

import datastructs.lists.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ListStackTest extends AbstractStackTest
{
    @Override
    protected Stack<String> makeStack()
    {
        return new ListStack<>(new SinglyLinkedList<>());
    }
}
