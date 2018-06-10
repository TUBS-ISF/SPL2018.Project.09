package strings;

import java.util.LinkedList;

public class Trie {
	class Node {
		char content;
		boolean isEnd;
		int count;
		LinkedList<Node> childList;

		public Node(char c) {
			childList = new LinkedList<Node>();
			isEnd = false;
			content = c;
			count = 0;
		}

		public Node subNode(char c) {
			if (childList != null)
				for (Node child : childList)
					if (child.content == c)
						return child;
			return null;
		}
	}

	private Node root;

	public Trie() {
		root = new Node(' ');
	}

	public void insert(String word) {
		if (search(word) == true)
			return;
		Node current = root;
		for (char ch : word.toCharArray()) {
			Node child = current.subNode(ch);
			if (child != null)
				current = child;
			else {
				current.childList.add(new Node(ch));
				current = current.subNode(ch);
			}
			current.count++;
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		Node current = root;
		for (char ch : word.toCharArray()) {
			if (current.subNode(ch) == null)
				return false;
			else
				current = current.subNode(ch);
		}
		if (current.isEnd == true)
			return true;
		return false;
	}

	public void remove(String word) {
		if (search(word) == false) {
			// gesuchtes Wort ist nicht in Trie
			return;
		}
		Node current = root;
		for (char ch : word.toCharArray()) {
			Node child = current.subNode(ch);
			if (child.count == 1) {
				current.childList.remove(child);
				return;
			} else {
				child.count--;
				current = child;
			}
		}
		current.isEnd = false;
	}

}
