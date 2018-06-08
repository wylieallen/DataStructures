package datastructs.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class BSTNodeTest
{
    @Test
    public void testNodeInstantiation()
    {
        String derp = "derp";
        BSTNode<String> node = new BSTNode<>(derp);
        Assertions.assertEquals(derp, node.value);
        Assertions.assertEquals(BSTNode.NULL, node.left);
        Assertions.assertEquals(BSTNode.NULL, node.right);
        Assertions.assertEquals(1, node.getHeight());
    }

    @Test
    public void testBalancedInsertion()
    {
        BSTNode<Integer> root = new BSTNode<>(0);

        Assertions.assertEquals(1, root.getSize());
        Assertions.assertEquals(1, root.getHeight());

        Assertions.assertFalse(root.insert(null));

        Assertions.assertTrue(root.insert(-2));
        Assertions.assertTrue(root.insert(2));

        Assertions.assertEquals(3, root.getSize());
        Assertions.assertEquals(2, root.getHeight());

        Assertions.assertTrue(-2 == root.left.value);
        Assertions.assertTrue(2 == root.right.value);
        Assertions.assertEquals(1, root.left.getSize());
        Assertions.assertEquals(1, root.right.getSize());
        Assertions.assertEquals(1, root.left.getHeight());
        Assertions.assertEquals(1, root.right.getHeight());

        Assertions.assertTrue(root.insert(-1));
        Assertions.assertTrue(root.insert(-3));
        Assertions.assertTrue(root.insert(1));
        Assertions.assertTrue(root.insert(3));

        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());

        Assertions.assertTrue(-1 == root.left.right.value);
        Assertions.assertTrue(-3 == root.left.left.value);
        Assertions.assertTrue(1 == root.right.left.value);
        Assertions.assertTrue(3 == root.right.right.value);

        Assertions.assertEquals(3, root.left.getSize());
        Assertions.assertEquals(3, root.right.getSize());
        Assertions.assertEquals(2, root.left.getHeight());
        Assertions.assertEquals(2, root.right.getHeight());

        Assertions.assertEquals(1, root.left.left.getSize());
        Assertions.assertEquals(1, root.left.right.getSize());
        Assertions.assertEquals(1, root.right.left.getSize());
        Assertions.assertEquals(1, root.right.right.getSize());
        Assertions.assertEquals(1, root.left.left.getHeight());
        Assertions.assertEquals(1, root.left.right.getHeight());
        Assertions.assertEquals(1, root.right.left.getHeight());
        Assertions.assertEquals(1, root.right.right.getHeight());

        Assertions.assertFalse(root.insert(0));
        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());

        Assertions.assertFalse(root.insert(-1));
        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());

        Assertions.assertFalse(root.insert(1));
        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());

        Assertions.assertFalse(root.insert(-2));
        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());

        Assertions.assertFalse(root.insert(2));
        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());

        Assertions.assertFalse(root.insert(-3));
        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());

        Assertions.assertFalse(root.insert(3));
        Assertions.assertEquals(7, root.getSize());
        Assertions.assertEquals(3, root.getHeight());
    }

    @Test
    public void testImbalancedInsertion()
    {
        BSTNode<Integer> root = new BSTNode<>(0);

        Assertions.assertEquals(1, root.getSize());
        Assertions.assertEquals(1, root.getHeight());
        Assertions.assertTrue(0 == root.value);

        root.insert(-1);

        Assertions.assertEquals(2, root.getSize());
        Assertions.assertEquals(2, root.getHeight());
        Assertions.assertTrue(-1 == root.left.value);
        Assertions.assertEquals(BSTNode.NULL, root.right);

        root.insert(-2);
        root.insert(-3);
        root.insert(-4);

        Assertions.assertEquals(5, root.getSize());
        Assertions.assertEquals(5, root.getHeight());
        Assertions.assertEquals(BSTNode.NULL, root.right);
    }

    @Test
    public void testPreOrderIterator()
    {
        BSTNode<Integer> root = new BSTNode<>(0);

        Iterator<Integer> iterator = root.preOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());

        root.insert(-2);
        root.insert(2);

        iterator = root.preOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(2 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        root.insert(-3);
        root.insert(-1);
        root.insert(1);
        root.insert(3);

        iterator = root.preOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-3 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-1 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(1 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(3 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        iterator = BSTNode.NULL.preOrderIterator();

        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());
    }

    @Test
    public void testInOrderIterator()
    {
        BSTNode<Integer> root = new BSTNode<>(0);

        Iterator<Integer> iterator = root.inOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());

        root.insert(-2);
        root.insert(2);

        iterator = root.inOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(2 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());

        root.insert(-3);
        root.insert(-1);
        root.insert(1);
        root.insert(3);

        iterator = root.inOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-3 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-1 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(1 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(3 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        iterator = BSTNode.NULL.inOrderIterator();

        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());
    }

    @Test
    public void testPostOrderIterator()
    {
        BSTNode<Integer> root = new BSTNode<>(0);

        Iterator<Integer> iterator = root.postOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        root.insert(-2);
        root.insert(2);

        iterator = root.postOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        root.insert(-3);
        root.insert(-1);
        root.insert(1);
        root.insert(3);

        iterator = root.postOrderIterator();

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-3 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-1 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(-2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(1 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(3 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(2 == iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertTrue(0 == iterator.next());
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());

        iterator = BSTNode.NULL.postOrderIterator();

        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertNull(iterator.next());
    }
}
