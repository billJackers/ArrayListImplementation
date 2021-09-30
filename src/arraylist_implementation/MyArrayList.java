import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of MyList with an array (a longer exercise would be to
 * implement the List interface as is done in the class java.util.ArrayList: the
 * source of the ArrayList class is available from Sun. Check it out).
 */

public class MyArrayList<E> implements MyList<E> {

    // Use an array for the implementation
    private E[] items;

    // Default capacity of the array
    private static final int DEFAULT_CAPACITY = 10;

    // Number of elements in the array
    private int size;

    /**
     * Constructs a MyArrayList with a specified capacity
     */
    public MyArrayList(int initialCapacity) {
        items = E[initialCapacity];
        size = 0;
    }

    /**
     * Constructs a MyArrayList with a default capacity
     */
    public MyArrayList() {
        items = E[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified element to the end of this list
     */
    public boolean add(E o) {
        // If there is no room in the array items
        if (size < items.length) {
            items[size] = o;
            return true;
        }
        // Make room for the new element
        E[] temp = E[size+1];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        // add the new element
    }

    /**
     * Empties this List
     */
    public void clear() {
        for (int i = 0; i < items.length) {
            items[i] = null;
        }
    }

    /**
     * Returns the element at the specified position in this list.
     */
    public E get(int index) {
        return items[index];
    }

    /**
     * Returns the index of the specified element (-1 if there is no match)
     */
    public int indexOf(Object o) {
        // If o is null (look for a null element in the array)
        if (o == null) {
            return -1;
        } else // o is an object (use equals)
        {
            for (int i = 0; i < items.length; i++) {
                if (items[i].equals(o)) return i;
            }
        }

        // If we get here, o is not in the list
        return -1;
    }

    /**
     * Returns true if this list contains the specified element.
     */
    public boolean contains(Object o) {
        // easy with indexOf
        if (indexOf(o) != -1) return true;
        return false;
    }

    /**
     * Removes the element in the List at position index
     */
    public boolean remove(int index) {

        // compact the array

        // let's gc do its work

    }

    /**
     * Removes the element in the List at position index
     */
    public boolean remove(Object o) {
        // easy with indexOf and remove
    }

    /**
     * Adds the specified object at the specified location
     */
    public boolean add(int index, E o) {

        // one way: add at the end and then shift the elements around
    }

    /**
     * Is this List equal to the specified object?
     */
    public boolean equals(Object o)
    {
        if (/* ???? */) {
            // o is an ArrayList

            // if the number of elements is not the same, this and o are not the
            // same

            // Check the elements one by one

            // At this point, the lists are equal

        }
        else {
            return false;
        }
    }
    /**
     * An inner class to define the iterator
     */
    private class MyIterator implements Iterator<E> {
        private int index = 0;

        private MyArrayList<E> list;

        private int lastIndex = -1; // index of the object most recently visited

        // by next

        /**
         * Create an iterator for a MyArrayList
         */
        public MyIterator(MyArrayList<E> list) {
        }

        /**
         * Any element left in the list?
         */
        public boolean hasNext() {
        }

        /**
         * Returns the current element in the list and move to the next element
         */
        public E next() {
        }

        /**
         * Removes the last object returned by next
         */
        public void remove() {
        }
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence.
     */
    public Iterator<E> iterator() {
    }
}
