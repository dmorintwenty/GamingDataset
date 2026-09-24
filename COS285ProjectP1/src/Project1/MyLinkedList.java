package Project1;
//@Author Dax Morin
import java.util.*;

/**
 * The linked list implementation because using the one java gave me is illegal
 * checkIndex() has been added to check if method is reaching for index in valid range (avoid crashes)
 * 
 *
 * @param <T>
 */
public class MyLinkedList<T> implements Iterable<T> {

	/**
	 * represents one node in the linked list.
	 */
	private class Node {

		T data;
		Node next;

		/**
		 * creates a new node containing the given data.
		 *
		 * @param data the element stored in the node
		 */
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private int size;

	/**
	 * creates an empty linked list
	 */
	public MyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * adds an element to the end of the list
	 *
	 * @param element --> the element to add
	 */
	public void add(T element) {
		Node newNode = new Node(element);

		if (head == null) {
			head = newNode;
		} else {
			Node current = head;

			while (current.next != null) {
				current = current.next;
			}

			current.next = newNode;
		}

		size++;
	}

	/**
	 * removes list element at desired index
	 *
	 * @param index --> the index of the element to remove
	 * @return the element that was removed
	 */
	public T remove(int index) {
		checkIndex(index);

		if (index == 0) {
			T removed = head.data;
			head = head.next;
			size--;
			return removed;
		}

		Node current = head;

		for (int i = 0; i < index - 1; i++) {
			current = current.next;
		}

		T removed = current.next.data;
		current.next = current.next.next;

		size--;

		return removed;
	}

	/**
	 * returns the element at the desired index
	 *
	 * @param index --> the index of the element to return
	 * @return the element at the index
	 */
	public T get(int index) {
		checkIndex(index);

		Node current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		return current.data;
	}

	/**
	 * replaces the element at the specified index
	 *
	 * @param index the index of the element to replace
	 * @param element --> the new element that is passed / stored
	 * @return the element that was previously stored at the index
	 */
	public T set(int index, T element) {
		checkIndex(index);

		Node current = head;

		for (int i = 0; i < index; i++) {
			current = current.next;
		}

		T oldValue = current.data;
		current.data = element;

		return oldValue;
	}

	/**
	 * removes all elements from the list (DANGEORUS)
	 */
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * returns the number of elements in the list
	 *
	 */
	public int size() {
		return size;
	}

	/**
	 * checks whether the list contains the specified element
	 *
	 * @param element --> the element to search for
	 * @return true ONLY if desired element is found
	 */
	public boolean contains(T element) {
		Node current = head;

		while (current != null) {
			if (element == null) {
				if (current.data == null) {
					return true;
				}
			} else if (element.equals(current.data)) {
				return true;
			}

			current = current.next;
		}

		return false;
	}

	/**
	 * checks whether the list contains no elements
	 *
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * returns an iterator for traversing the list.
	 *
	 * @return an iterator over the elements in the list
	 */
	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {

			private Node current = head;

			/**
			 * checks whether another element exists in the list.
			 *
			 * @return true if another element exists, false otherwise
			 */
			@Override
			public boolean hasNext() {
				return current != null;
			}

			/**
			 * returns the next element in the list.
			 *
			 * @return the next element
			 * @throws NoSuchElementException if there are no more elements
			 */
			@Override
			public T next() {

				if (!hasNext()) {
					throw new NoSuchElementException();
				}

				T data = current.data;
				current = current.next;

				return data;
			}
		};
	}

	/**
	 * checks whether an index is within the valid range
	 *
	 * @param index --> the index to check
	 * @throws IndexOutOfBoundsException if the index is invalid
	 */
	private void checkIndex(int index) {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(
					"Index: " + index + ", Size: " + size);
		}
	}
}