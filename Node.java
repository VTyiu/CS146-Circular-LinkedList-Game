package cs146F20.tang.project1;

// models a Node for a circularlinkedlist
public class Node {
	
	private int value;
	private Node next;
	
	/*
	 * Constructs a new Node
	 * @param value the integer value of the node
	 */
	public Node(int value) {
		this.value = value;
	}
	
	/*
	 * Gets the value of the node
	 * @return the value of the node
	 */
	int getValue() {
		return value;
	}
	
	/*
	 * Gets the next reference of the node
	 * @return the node's reference to the next node
	 */
	Node getNext() {
		return next;
	}
	
	/*
	 * Sets the next reference of the node
	 * @param next the node to set as the reference of the Node
	 */
	void setNext(Node next) {
		this.next = next;
	}
}
