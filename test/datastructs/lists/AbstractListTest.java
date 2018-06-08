package datastructs.lists;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractListTest
{
    private List<String> list;

    protected abstract List<String> makeList();

    @BeforeEach
    public void initializeList()
    {
        this.list = makeList();
    }

    @Test
    public void testInitialization()
    {
        Assertions.assertNull(list.getHead());
        Assertions.assertNull(list.getTail());
        Assertions.assertEquals(0, list.getSize());

        list = new SinglyLinkedList<>("Herp");

        Assertions.assertEquals("Herp", list.getHead());
        Assertions.assertEquals("Herp", list.getTail());
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    public void testAppend()
    {
        Assertions.assertNull(list.getHead());
        Assertions.assertNull(list.getTail());
        Assertions.assertEquals(0, list.getSize());

        list.append("Herp");

        Assertions.assertEquals("Herp", list.getHead());
        Assertions.assertEquals("Herp", list.getTail());
        Assertions.assertEquals(1, list.getSize());

        list.append("Derp");

        Assertions.assertEquals("Herp", list.getHead());
        Assertions.assertEquals("Derp", list.getTail());
        Assertions.assertEquals(2, list.getSize());

        list.append("Flerp");

        Assertions.assertEquals("Herp", list.getHead());
        Assertions.assertEquals("Flerp", list.getTail());
        Assertions.assertEquals(3, list.getSize());
    }

    @Test
    public void testPrepend()
    {
        Assertions.assertNull(list.getHead());
        Assertions.assertNull(list.getTail());
        Assertions.assertEquals(0, list.getSize());

        list.prepend("Herp");

        Assertions.assertEquals("Herp", list.getHead());
        Assertions.assertEquals("Herp", list.getTail());
        Assertions.assertEquals(1, list.getSize());

        list.prepend("Derp");

        Assertions.assertEquals("Derp", list.getHead());
        Assertions.assertEquals("Herp", list.getTail());
        Assertions.assertEquals(2, list.getSize());

        list.prepend("Flerp");

        Assertions.assertEquals("Flerp", list.getHead());
        Assertions.assertEquals("Herp", list.getTail());
        Assertions.assertEquals(3, list.getSize());
    }

    @Test
    public void testGet()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));

        list.append("Herp");

        Assertions.assertEquals("Herp", list.get(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));

        list.append("Derp");

        Assertions.assertEquals("Herp", list.get(0));
        Assertions.assertEquals("Derp", list.get(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));

        list.append("Flerp");

        Assertions.assertEquals("Herp", list.get(0));
        Assertions.assertEquals("Derp", list.get(1));
        Assertions.assertEquals("Flerp", list.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));

        list.prepend("Glerp");

        Assertions.assertEquals("Glerp", list.get(0));
        Assertions.assertEquals("Herp", list.get(1));
        Assertions.assertEquals("Derp", list.get(2));
        Assertions.assertEquals("Flerp", list.get(3));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
    }

    @Test
    public void testRemove()
    {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));

        list.append("Herp");
        list.append("Derp");
        list.append("Flerp");
        list.append("Glerp");

        Assertions.assertEquals(4, list.getSize());
        Assertions.assertEquals("Herp", list.getHead());
        Assertions.assertEquals("Herp", list.get(0));
        Assertions.assertEquals("Derp", list.get(1));
        Assertions.assertEquals("Flerp", list.get(2));
        Assertions.assertEquals("Glerp", list.get(3));
        Assertions.assertEquals("Glerp", list.getTail());

        list.remove(0);

        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Derp", list.getHead());
        Assertions.assertEquals("Derp", list.get(0));
        Assertions.assertEquals("Flerp", list.get(1));
        Assertions.assertEquals("Glerp", list.get(2));
        Assertions.assertEquals("Glerp", list.getTail());

        list.remove(1);

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Derp", list.getHead());
        Assertions.assertEquals("Derp", list.get(0));
        Assertions.assertEquals("Glerp", list.get(1));
        Assertions.assertEquals("Glerp", list.getTail());

        list.remove(0);

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Glerp", list.getHead());
        Assertions.assertEquals("Glerp", list.get(0));
        Assertions.assertEquals("Glerp", list.getTail());

        list.remove(0);

        Assertions.assertEquals(0, list.getSize());

        list.append("Herp");
        list.append("Derp");
        list.append("Flerp");

        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("Herp", list.get(0));
        Assertions.assertEquals("Derp", list.get(1));
        Assertions.assertEquals("Flerp", list.get(2));
        Assertions.assertEquals("Flerp", list.getTail());

        list.remove(2);

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Herp", list.get(0));
        Assertions.assertEquals("Derp", list.get(1));
        Assertions.assertEquals("Derp", list.getTail());
    }

    @Test
    public void testContainsElement()
    {
        Assertions.assertFalse(list.contains("a"));
        Assertions.assertFalse(list.contains("b"));
        Assertions.assertFalse(list.contains("c"));

        list.append("a");

        Assertions.assertTrue(list.contains("a"));
        Assertions.assertFalse(list.contains("b"));
        Assertions.assertFalse(list.contains("c"));

        list.append("b");

        Assertions.assertTrue(list.contains("a"));
        Assertions.assertTrue(list.contains("b"));
        Assertions.assertFalse(list.contains("c"));

        list.append("c");

        Assertions.assertTrue(list.contains("a"));
        Assertions.assertTrue(list.contains("b"));
        Assertions.assertTrue(list.contains("c"));

        list.remove("c");

        Assertions.assertTrue(list.contains("a"));
        Assertions.assertTrue(list.contains("b"));
        Assertions.assertFalse(list.contains("c"));

        list.remove("a");

        Assertions.assertFalse(list.contains("a"));
        Assertions.assertTrue(list.contains("b"));
        Assertions.assertFalse(list.contains("c"));
    }

    @Test
    public void testRemoveByElement()
    {
        Assertions.assertEquals(0, list.getSize());

        list.remove("herp");

        Assertions.assertEquals(0, list.getSize());

        list.append("herp");
        list.append("derp");
        list.append("flerp");

        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("herp", list.get(0));
        Assertions.assertEquals("derp", list.get(1));
        Assertions.assertEquals("flerp", list.get(2));

        list.remove("glerp");

        Assertions.assertEquals(3, list.getSize());
        Assertions.assertEquals("herp", list.get(0));
        Assertions.assertEquals("derp", list.get(1));
        Assertions.assertEquals("flerp", list.get(2));

        list.remove("derp");

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("herp", list.get(0));
        Assertions.assertEquals("flerp", list.get(1));

        list.remove("herp");

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("flerp", list.get(0));

        list.remove("flerp");

        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void testCountElement()
    {
        Assertions.assertEquals(0, list.count("a"));
        Assertions.assertEquals(0, list.count("b"));
        Assertions.assertEquals(0, list.count("c"));
        Assertions.assertEquals(0, list.count("d"));

        list.append("a");
        list.append("b");
        list.append("c");

        Assertions.assertEquals(1, list.count("a"));
        Assertions.assertEquals(1, list.count("b"));
        Assertions.assertEquals(1, list.count("c"));
        Assertions.assertEquals(0, list.count("d"));

        list.append("a");
        list.append("a");
        list.append("a");

        Assertions.assertEquals(4, list.count("a"));
        Assertions.assertEquals(1, list.count("b"));
        Assertions.assertEquals(1, list.count("c"));
        Assertions.assertEquals(0, list.count("d"));

        list.remove("a");

        Assertions.assertEquals(3, list.count("a"));
        Assertions.assertEquals(1, list.count("b"));
        Assertions.assertEquals(1, list.count("c"));
        Assertions.assertEquals(0, list.count("d"));

        list.remove("a");
        list.remove("a");

        Assertions.assertEquals(1, list.count("a"));
        Assertions.assertEquals(1, list.count("b"));
        Assertions.assertEquals(1, list.count("c"));
        Assertions.assertEquals(0, list.count("d"));
    }
}
