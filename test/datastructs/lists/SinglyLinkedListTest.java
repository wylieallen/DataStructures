package datastructs.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest extends AbstractListTest
{
    private SinglyLinkedList<String> list;

    @Override
    protected List<String> makeList()
    {
        return list = new SinglyLinkedList<>();
    }

    @Test
    public void testRemoveDuplicates()
    {
        Assertions.assertEquals(0, list.getSize());

        list.removeDuplicates();

        Assertions.assertEquals(0, list.getSize());

        list.append("a");
        list.append("b");
        list.append("c");

        Assertions.assertEquals(3, list.getSize());

        list.removeDuplicates();

        Assertions.assertEquals(3, list.getSize());

        list.append("b");

        Assertions.assertEquals(4, list.getSize());
        Assertions.assertEquals("a", list.get(0));
        Assertions.assertEquals("b", list.get(1));
        Assertions.assertEquals("c", list.get(2));
        Assertions.assertEquals("b", list.get(3));

        list.removeDuplicates();

        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("a", list.get(0));
        Assertions.assertEquals("b", list.get(1));
        Assertions.assertEquals("c", list.get(2));
    }

    @Test
    public void testGetFromTail()
    {
        for(int i = -1; i <= 1; i++)
        {
            int count = i;
            Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFromTail(count));
        }

        list.append("herp");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFromTail(-1));
        Assertions.assertEquals("herp", list.getFromTail(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFromTail(1));

        list.append("derp");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFromTail(-1));
        Assertions.assertEquals("derp", list.getFromTail(0));
        Assertions.assertEquals("herp", list.getFromTail(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFromTail(2));

        list.prepend("flerp");

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFromTail(-1));
        Assertions.assertEquals("derp", list.getFromTail(0));
        Assertions.assertEquals("herp", list.getFromTail(1));
        Assertions.assertEquals("flerp", list.getFromTail(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFromTail(3));
    }
}
