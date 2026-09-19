package Project1;
/*
 * Method Checklist
 * push
 * pop
 * peek
 * isEmpty
 * size
 * 
 */


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

public MyStack() {
   top = null;
   size = 0;
}

public void push(T element) {
	Node newNode = new Node(element);
	newNode.next = top;
	
	top = newNode;
	size++;
}

public T pop() {
	T removed = top.data;
	top = top.next;
	
	size--;
	return removed;

}

public T peek() {
	return top.data;
}


//TODO: size()
//TODO:isEmpty()
}
