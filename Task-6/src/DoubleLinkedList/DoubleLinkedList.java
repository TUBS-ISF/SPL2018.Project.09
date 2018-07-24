package DoubleLinkedList;

import java.util.Stack;


/*
 * Author Toghrul Gasimov from TU-BS Uni IMN 
 */
class DoubleLinkedList {
	public Node head, tail;
	public int size = 0;
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Node remove(Node node) {
		if (node == this.head) {
			this.head = this.head.next;
			if (this.head != null)
				this.head.prev = null;
			this.size--;
			return node;
		}
		if (node == this.tail) {
			this.tail = this.tail.prev;
			if (this.tail != null)
				this.tail.next = null;
			this.size--;
			return node;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
		this.size--;
		return node;
	}

	public Node removeEnd() {
		return this.remove(this.tail);
	}

	public void insertStrat(int data) {
	    Node n = new Node(data);
	    if (this.size == 0) {
	      this.head = n;
	      this.tail = n;
	    } else {
	      this.head.prev = n;
	      n.next = this.head;
	      this.head = n;
	    }
	    this.size++;
	  }
	  public void insertEnd(int data) {
	    Node  n = new Node(data);
	    if (this.size == 0) {
	      this.head = n;
	      this.tail = n;
	    } else {
	      this.tail.next = n;
	      n.prev = this.tail;
	      this.tail = n;
	    }
	    this.size++;
	  }

	public void insert(Node node, int data) {
		Node k = new Node(data);
		k.prev = node;
		k.next = node.next;
		if (node.next != null) {
			node.next.prev = k;
		} else {
			this.tail = k;
		}
		node.next = k;
		this.size++;
	}
	public void reverse() {
		
	}

}
