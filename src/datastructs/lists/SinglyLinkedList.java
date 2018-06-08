package datastructs.lists;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList<T> implements List<T>
{
    private class Node
    {
        public final T value;
        public Node next;

        public Node(T value)
        {
            this.value = value;
            this.next = NULL;
        }
    }

    private final Node NULL = new Node(null);

    // Members:

    private Node head;
    private Node tail;
    private int size;

    // Constructors:

    public SinglyLinkedList()
    {
        head = tail = NULL;
        size = 0;
    }

    public SinglyLinkedList(T initial)
    {
        head = tail = new Node(initial);
        size = 1;
    }

    // Accessors:

    public T getHead() { return head.value; }
    public T getTail() { return tail.value; }
    public int getSize() { return size; }

    public T get(int i) throws IndexOutOfBoundsException
    {
        if(i < 0 || i >= size) throw new IndexOutOfBoundsException();

        Node cur = head;
        while(i-- > 0)
        {
            cur = cur.next;
        }
        return cur.value;
    }

    public T getFromTail(int i) throws IndexOutOfBoundsException
    {
        return get(size - 1 - i);
    }

    public boolean contains(T value)
    {
        if(size == 0) return false;
        if(size == 1) return head.value == value;

        Node cur = head;
        while(cur != NULL)
        {
            if(cur.value == value) return true;
            cur = cur.next;
        }
        return false;
    }

    public int count(T value)
    {
        if(size == 0) return 0;
        if(size == 1) return (head.value == value) ? 1 : 0;

        int count = 0;
        Node cur = head;
        while(cur != NULL)
        {
            if(cur.value == value) count++;
            cur = cur.next;
        }

        return count;
    }

    // Mutators:

    public void removeDuplicates()
    {
        if(size <= 1) return;

        Set<T> previouslySeenElements = new HashSet<>();
        Node prev = head;
        Node cur = prev.next;

        previouslySeenElements.add(prev.value);

        while(cur != NULL)
        {
            if(previouslySeenElements.contains(cur.value))
            {
                prev.next = cur.next;
                cur = cur.next;
                size--;
            }
            else
            {
                previouslySeenElements.add(cur.value);
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public void remove(T value)
    {
        if(size == 0) return;
        if(size == 1)
        {
            if(head.value == value)
            {
                head = tail = NULL;
                --size;
                return;
            }
        }

        Node prev = head, cur = head.next;

        if(head.value == value)
        {
            head = cur;
            --size;
            return;
        }

        while(cur != NULL)
        {
            if(cur.value == value)
            {
                prev.next = cur.next;
                --size;
                if(cur == tail) tail = prev;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public T remove(int i) throws IndexOutOfBoundsException
    {
        if(i < 0 || i >= size) throw new IndexOutOfBoundsException();

        if(i == 0)
        {
            T value = head.value;
            head = head.next;
            --size;
            return value;
        }
        else
        {
            Node prev = head;
            Node cur = head.next;
            i--;

            while(i-- > 0)
            {
                prev = cur;
                cur = cur.next;
            }

            prev.next = cur.next;
            --size;
            if(cur == tail) tail = prev;
            return cur.value;
        }
    }

    public void prepend(T value)
    {
        if(size == 0)
        {
            head = tail = new Node(value);
        }
        else
        {
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
        ++size;
    }

    public void append(T value)
    {
        if(size == 0)
        {
            head = tail = new Node(value);
        }
        else
        {
            tail.next = new Node(value);
            tail = tail.next;
        }
        ++size;
    }
}
