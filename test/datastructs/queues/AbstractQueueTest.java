package datastructs.queues;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractQueueTest
{
    protected abstract Queue<String> makeQueue();

    private Queue<String> queue;

    @BeforeEach
    public void initializeQueue()
    {
        this.queue = makeQueue();
    }

    @Test
    public void testPeek()
    {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.peek());
        Assertions.assertEquals(0, queue.getSize());

        queue.push("Herp");

        Assertions.assertEquals("Herp", queue.peek());
        Assertions.assertEquals(1, queue.getSize());

        queue.push("Derp");

        Assertions.assertEquals("Herp", queue.peek());
        Assertions.assertEquals(2, queue.getSize());
    }

    @Test
    public void testPop()
    {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> queue.pop());
        Assertions.assertEquals(0, queue.getSize());

        queue.push("Herp");
        queue.push("Derp");

        Assertions.assertEquals("Herp", queue.peek());
        Assertions.assertEquals(2, queue.getSize());

        Assertions.assertEquals("Herp", queue.pop());
        Assertions.assertEquals(1, queue.getSize());

        Assertions.assertEquals("Derp", queue.peek());
        Assertions.assertEquals(1, queue.getSize());

        Assertions.assertEquals("Derp", queue.pop());
        Assertions.assertEquals(0, queue.getSize());
    }
}
