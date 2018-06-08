package datastructs.stacks;

import datastructs.lists.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractStackTest
{
    private Stack<String> stack;

    protected abstract Stack<String> makeStack();

    @BeforeEach
    public void initializeStack()
    {
        this.stack = makeStack();
    }

    @Test
    public void testPeek()
    {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> stack.peek());
        Assertions.assertEquals(0, stack.getSize());

        stack.push("Herp");

        Assertions.assertEquals("Herp", stack.peek());
        Assertions.assertEquals(1, stack.getSize());

        stack.push("Derp");

        Assertions.assertEquals("Derp", stack.peek());
        Assertions.assertEquals(2, stack.getSize());
    }

    @Test
    public void testPop()
    {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> stack.pop());
        Assertions.assertEquals(0, stack.getSize());

        stack.push("Herp");
        stack.push("Derp");

        Assertions.assertEquals("Derp", stack.peek());
        Assertions.assertEquals(2, stack.getSize());

        Assertions.assertEquals("Derp", stack.pop());
        Assertions.assertEquals(1, stack.getSize());

        Assertions.assertEquals("Herp", stack.peek());
        Assertions.assertEquals(1, stack.getSize());

        Assertions.assertEquals("Herp", stack.pop());
        Assertions.assertEquals(0, stack.getSize());
    }
}
