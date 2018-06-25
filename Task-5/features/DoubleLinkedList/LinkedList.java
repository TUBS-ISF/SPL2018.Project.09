
public class LinkedList {

	class Node {
		public int data;
		public Node next, prev;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	public Node head, tail;
	public int size;
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void delete(Node node) {
		if (node == this.head) {
			this.head = this.head.next;
			if (this.head != null)
				this.head.prev = null;
			this.size--;
			return;
		}
		if (node == this.tail) {
			this.tail = this.tail.prev;
			if (this.tail != null)
				this.tail.next = null;
			this.size--;
			return;
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
		this.size--;
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
		Node n = new Node(data);
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

	public void print() {

		for (Node x = this.head; x != null; x = x.next) {
			System.out.println(x.data + ", ");
		}

	}

}
