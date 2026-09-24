package Project1;


public class MyStack<T> {
	 
	/**
	 * individual node attributes
	 */
	private class Node {
	T data;
	Node next;
		Node(T data) {
	           this.data = data;
	           this.next = null;
	        }
		
	    }

	private Node top;
	private int size;

	/**
	 * Initializes a stack
	 */
	public MyStack() {
	   top = null;
	   size = 0;
	}
	
	/**
	 * adds generic type element to top of stack and increases stack size by 1
	 * @param element --> Value being added to top of stack
	 */
	public void push(T element) {
		Node newNode = new Node(element);
		newNode.next = top;
		
		top = newNode;
		size++;
	}
	
	/**
	 * removes top value in stack and returns the removed value and decreases stack size by 1
	 * @return --> previously top value that is now removed
	 */
	public T pop() {
		T removed = top.data;
		top = top.next;
		
		size--;
		return removed;
	
	}
	
	/**
	 * @return --> The data value that is at the top of the stack
	 */
	public T peek() {
		return top.data;
	}
	
	
	/**
	 * @return --> Size of the stack in int value
	 */
	public int size() {
		
		return size;
		}
	
	/**
	 * returns true if size of stack is 0
	 * @return --> true if stack is empty
	 */
	public boolean isEmpty() {
		return (size == 0);
		}


}
