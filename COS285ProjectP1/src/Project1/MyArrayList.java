package Project1;
//@Author Dax Morin
//This is my custom implementation of an ArrayList because using the one that was given to me is not cool
import java.util.*;

public class MyArrayList<T> implements Iterable<T> {
 // internal array used to store elements
 private Object[] elements;

 // number of elements currently stored
 private int size;

// starting capacity of the array
private static final int DEFAULT_CAPACITY = 10;

 /**
* creates an empty MyArrayList with a default capacity
*/
public MyArrayList() {
	elements = new Object[DEFAULT_CAPACITY];
	size = 0;
	    }

	    /**
	     * adds an element to the end of the list
	     *
	     * @param element the element to add
	     */
	    public void add(T element) {
	        // make the array larger if necessary
	        if (size == elements.length) {
	            resize();
	        }

	        elements[size] = element;
	        size++;
	    }

	    /**
	     * removes the element at the specified index.
	     *
	     * @param index the index of the element to remove
	     * @return the removed element
	     */
	    public T remove(int index) {
	        checkIndex(index);

	        T removedElement = (T) elements[index];

	        // all elements one to the left
	        for (int i = index; i < size - 1; i++) {
	            elements[i] = elements[i + 1];
	        }

	        //removes end reference??????
	        elements[size - 1] = null;
	        size--;

	        return removedElement;
	    }

	    /**
	     * returns the element at the specified index
	     *
	     * @param index the index of the element
	     * @return the element at the index
	     */
	    public T get(int index) {
	        checkIndex(index);

	        return (T) elements[index];
	    }

	    /**
	     * removes all elements from the list
	     */
	    public void clear() {
	        for (int i = 0; i < size; i++) {
	            elements[i] = null;
	        }

	        size = 0;
	    }

	    /**
	     * returns the number of elements in the list
	     *
	     * @return the number of elements
	     */
	    public int size() {
	        return size;
	    }

	    /**
	     * checks whether the list contains the specified element
	     *
	     * @param element the element to search for
	     * @return true only if the element
	     */
	    public boolean contains(T element) {
	        for (int i = 0; i < size; i++) {
	            if (element == null && elements[i] == null) {
	                return true;
	            }

	            if (element != null && element.equals(elements[i])) {
	                return true;
	            }
	        }

	        return false;
	    }

	    /**
	     * checks whether the list is empty
	     *
	     * @return true if the list is empty, false otherwise
	     */
	    public boolean isEmpty() {
	        return size == 0;
	    }

	    /**
	     * returns an iterator that goes through the elements in the list
	     *
	     * @return an iterator for the list
	     */
	    
	    @Override
	    public Iterator<T> iterator() {
	        return new Iterator<T>() {

	            private int currentIndex = 0;

	            @Override
	            public boolean hasNext() {
	                return currentIndex < size;
	            }

	            @Override
	            public T next() {
	                if (!hasNext()) {
	                    throw new NoSuchElementException();
	                }

	                return (T) elements[currentIndex++];
	            }
	        };
	    }

	    /**
	     * increases the capacity of the internal array
	     */
	    private void resize() {
	        Object[] newElements = new Object[elements.length * 2];

	        for (int i = 0; i < size; i++) {
	            newElements[i] = elements[i];
	        }

	        elements = newElements;
	    }

	    /**
	     * checks whether an index is valid.
	     *
	     * @param index the index to check
	     */
	    private void checkIndex(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index: " + index);
	       }
	   }
}

