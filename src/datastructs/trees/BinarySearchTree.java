package datastructs.trees;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>>
{
    public final T value;
    public BinarySearchTree<T> left, right;
    private int size, height;

    public BinarySearchTree(T value)
    {
        this.value = value;
        left = right = NULL;
        this.size = 1;
        this.height = 1;
    }

    private int recalculateHeight()
    {
        int max = 0;

        if(left != NULL)
        {
            max = left.getHeight();
        }

        if(right != NULL)
        {
            if(max < right.getHeight())
                max = right.getHeight();
        }

        return max + 1;
    }

    public boolean insert(T value)
    {
        if(value == null) return false;

        if (this.value.compareTo(value) > 0)
        {
            if (left == NULL)
            {
                left = new BinarySearchTree<>(value);
                size++;
                height = recalculateHeight();
                return true;
            }
            else
            {
                if (left.insert(value))
                {
                    size++;
                    height = recalculateHeight();
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else if (this.value.compareTo(value) < 0)
        {
            if (right == NULL)
            {
                right = new BinarySearchTree<>(value);
                size++;
                height = recalculateHeight();
                return true;
            }
            else
            {
                if (right.insert(value))
                {
                    size++;
                    height = recalculateHeight();
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }

        return false;
    }

    public Iterator<T> preOrderIterator()
    {
        return new Iterator<T>()
        {
            private boolean leftTraversed, centerTraversed, rightTraversed;
            private Iterator<T> leftIterator, rightIterator;

            {
                if (left == NULL)
                {
                    leftTraversed = true;
                }
                else
                {
                    leftTraversed = false;
                    leftIterator = left.preOrderIterator();
                }

                if (value == null)
                {
                    centerTraversed = true;
                }

                if (right == NULL)
                {
                    rightTraversed = true;
                }
                else
                {
                    rightTraversed = false;
                    rightIterator = right.preOrderIterator();
                }
            }

            public T next()
            {
                if (!centerTraversed)
                {
                    centerTraversed = true;
                    return value;
                }
                else if (!leftTraversed)
                {
                    T value = leftIterator.next();
                    if (!leftIterator.hasNext())
                        leftTraversed = true;
                    return value;
                }
                else if (!rightTraversed)
                {
                    T value = rightIterator.next();
                    if (!rightIterator.hasNext())
                        rightTraversed = true;
                    return value;
                }

                return null;
            }

            public boolean hasNext()
            {
                return !(leftTraversed && centerTraversed && rightTraversed);
            }
        };
    }

    public Iterator<T> inOrderIterator()
    {
        return new Iterator<T>()
        {
            private boolean leftTraversed, centerTraversed, rightTraversed;
            private Iterator<T> leftIterator, rightIterator;
            {
                if (left == NULL)
                {
                    leftTraversed = true;
                }
                else
                {
                    leftTraversed = false;
                    leftIterator = left.inOrderIterator();
                }

                if (value == null)
                {
                    centerTraversed = true;
                }

                if (right == NULL)
                {
                    rightTraversed = true;
                }
                else
                {
                    rightTraversed = false;
                    rightIterator = right.inOrderIterator();
                }
            }

            public boolean hasNext()
            {
                return !(leftTraversed && centerTraversed && rightTraversed);
            }

            public T next()
            {
                if (!leftTraversed)
                {
                    T value = leftIterator.next();
                    if (!leftIterator.hasNext())
                        leftTraversed = true;
                    return value;
                }
                else if (!centerTraversed)
                {
                    centerTraversed = true;
                    return value;
                }
                else if (!rightTraversed)
                {
                    T value = rightIterator.next();
                    if (!rightIterator.hasNext())
                        rightTraversed = true;
                    return value;
                } else return null;
            }
        };
    }

    public Iterator<T> postOrderIterator()
    {
        return new Iterator<T>()
        {
            private boolean leftTraversed, centerTraversed, rightTraversed;
            private Iterator<T> leftIterator, rightIterator;
            {
                if (left == NULL)
                {
                    leftTraversed = true;
                }
                else
                {
                    leftIterator = left.postOrderIterator();
                    leftTraversed = false;
                }

                if (value == null)
                {
                    centerTraversed = true;
                }

                if (right == NULL)
                {
                    rightTraversed = true;
                }
                else
                {
                    rightIterator = right.postOrderIterator();
                    rightTraversed = false;
                }
            }

            public boolean hasNext()
            {
                return !(leftTraversed && centerTraversed && rightTraversed);
            }

            public T next()
            {
                if (!leftTraversed)
                {
                    T value = leftIterator.next();
                    if (!leftIterator.hasNext())
                        leftTraversed = true;
                    return value;
                }
                else if (!rightTraversed)
                {
                    T value = rightIterator.next();
                    if (!rightIterator.hasNext())
                        rightTraversed = true;
                    return value;
                }
                else if (!centerTraversed)
                {
                    centerTraversed = true;
                    return value;
                }

                return null;
            }
        };
    }

    public int getHeight()
    {
        return height;
    }

    public int getSize()
    {
        return size;
    }

    public static final BinarySearchTree NULL = new BinarySearchTree<>(null);
    static
    {
        NULL.left = NULL.right = NULL;
    }
}
