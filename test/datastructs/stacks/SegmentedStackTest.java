package datastructs.stacks;

import datastructs.stacks.SegmentedStack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SegmentedStackTest extends AbstractStackTest
{
    private SegmentedStack<String> stack;
    private static final int MAX_SIZE = 10;

    @Override
    protected Stack<String> makeStack()
    {
        return stack = new SegmentedStack<>(MAX_SIZE);
    }

    @Test
    public void testInitialization()
    {
        Assertions.assertEquals(MAX_SIZE, stack.getMaxSize());
        Assertions.assertEquals(1, stack.getSegmentCount());
        Assertions.assertEquals(0, stack.getSize());

        stack = new SegmentedStack<>(-1);

        Assertions.assertTrue(stack.getMaxSize() > 0);
    }

    @Test
    public void testSizes()
    {
        int size = stack.getMaxSize();
        for(int i = 0; i < size * 100; i++)
        {
            stack.push("a");
            Assertions.assertEquals(1 + (i / size), stack.getSegmentCount());
            Assertions.assertEquals(i + 1, stack.getSize());
        }
    }

    @Test
    public void testSegmentedPop()
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

        for(int i = 0; i < MAX_SIZE * 10; i++)
        {
            stack.push("a");
        }

        Assertions.assertEquals(10, stack.getSegmentCount());

        for(int i = 0; i < MAX_SIZE; i++)
        {
            stack.pop();
        }

        Assertions.assertEquals(9, stack.getSegmentCount());
    }
}
