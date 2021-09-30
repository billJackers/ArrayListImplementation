package arraylist_implementation;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*

I learned how the algorithms of the arrays were implemented.
One thing that was particularly challenging was the equals method. To overcome this, I used the getClass() method to
determine if the object was a MyArrayList class.

 */

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
     * O(1)
     */
    public MyArrayList(int initialCapacity) {
        items = E[initialCapacity];
        size = 0;
    }

    /**
     * Constructs a MyArrayList with a default capacity
     * O(1)
     */
    public MyArrayList() {
        items = E[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     * O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     * O(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified element to the end of this list
     * O(n)
     */
    public boolean add(E o) {
        try {
            // If there is no room in the array items
            if (size < items.length) {
                items[size] = o;
                return true;
            }
            // Make room for the new element
            E[] temp = E[size + 1];
            for (int i = 0; i < size; i++) {
                temp[i] = items[i];
            }
            // add the new element
            temp[temp.length - 1] = o;
            items = temp;
            size++;
            return true;
        } catch (Exception e) {
            System.out.print("Error");
            return false;
        }
    }

    /**
     * Empties this List
     * O(n)
     */
    public void clear() {
        for (int i = 0; i < items.length; i++) {
            items[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     * O(1)
     */
    public E get(int index) {
        return items[index];
    }

    /**
     * Returns the index of the specified element (-1 if there is no match)
     * O(n)
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
     * O(n)
     */
    public boolean contains(Object o) {
        // easy with indexOf
        if (indexOf(o) != -1) return true;
        return false;
    }

    /**
     * Removes the element in the List at position index
     * O(n)
     */
    public boolean remove(int index) {

        try {
            items[index] = null;
            // compact the array
            E[] temp = E[items.length - 1];
            for (int i = 0; i < items.length-2; i++) {
                if (i == index) {
                    i++;
                } else {
                    temp[i] = items[i];
                }
            }
            items = temp;
            // let's gc do its work
            return true;
        } catch (Exception e) {
            System.out.println("Error");
            return false;
        }
    }

    /**
     * Removes the element in the List at position index
     * O(n)
     */
    public boolean remove(Object o) {
        // easy with indexOf and remove
        try {
            remove(indexOf(o));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Adds the specified object at the specified location
     */
    public boolean add(int index, E o) {

        // one way: add at the end and then shift the elements around
        try {
            for (int i = size-1; i >= index; i--) {
                items[i+1] = items[i];
            }
            size++;
            items[index] = o;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Is this List equal to the specified object?
     * O(n)
     */
    public boolean equals(Object o)
    {
        if (items.getClass().equals(o.getClass())) {
            // o is an ArrayList
            MyArrayList temp = (MyArrayList) o;
            // if the number of elements is not the same, this and o are not the
            // same
            if (size != temp.size()) {
                return false;
            }
            // Check the elements one by one
            for (int i = 0; i < size; i++) {
                if (!items[i].equals(temp.get(i))) {
                    return false;
                }
            }
            // At this point, the lists are equal
            return true;
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
         * O(1)
         */
        public MyIterator(MyArrayList<E> list) {
            this.list = list;
        }

        /**
         * Any element left in the list?
         * O(1)
         */
        public boolean hasNext() {
            return index < list.size()-1;
        }

        /**
         * Returns the current element in the list and move to the next element
         * O(1)
         */
        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastIndex = index;
            index++;
            return list.get(index);
        }

        /**
         * Removes the last object returned by next
         */
        public void remove() {
            MyArrayList.this.remove(index);
        }
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence.
     */
    public Iterator<E> iterator() {
        return new MyIterator(this);
    }
}
