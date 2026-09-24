package Project1;
//@Author Dax Morin

public class MyQueue<T> {

	private class Node {

		T data;
		Node next;

		/**
		 * creates a new node containing the given element
		 *
		 * @param data --> value being stored in the node
		 */
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node front;
	private Node rear;
	private int size;

	/**
	 * creates an empty queue
	 */
	public MyQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	/**
	 * adds generic type element to rear of queue
	 * and increases queue size by 1
	 *
	 * @param element --> value being added to rear of queue
	 */
	public void offer(T element) {

		Node newNode = new Node(element);

		if (rear == null) {
			front = newNode;
			rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}

		size++;
	}

	/**
	 * removes front value in queue and returns the removed value
	 * and decreases queue size by 1
	 *
	 * @return --> previously front value that is now removed
	 */
	public T poll() {

		if (front == null) {
			return null;
		}

		T removed = front.data;

		front = front.next;

		if (front == null) {
			rear = null;
		}

		size--;

		return removed;
	}

	/**
	 * returns the front value in queue without removing it
	 *
	 * @return --> current front value in queue
	 */
	public T peek() {

		if (front == null) {
			return null;
		}

		return front.data;
	}

	/**
	 * checks whether the queue contains no elements
	 *
	 * @return --> true if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * returns the number of elements currently in queue
	 *
	 * @return --> number of elements in queue
	 */
	public int size() {
		return size;
	}
}
