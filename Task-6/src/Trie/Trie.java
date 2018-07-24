package Trie;

import java.util.HashMap;
import java.util.Map;

public  class Trie {
	public  class Node {
		public char c;
		public int d;
		public Map<Character, Node> M;
		public Node(char c) {
			this.c = c;
			this.d = 1;
			M = new HashMap<Character, Node>();
		}
	}
	Node root;
	public Trie() {
		root = new Node(' ');
	}
	public void insert(String s) {
		Node t = root;
		for(int i = 0; i < s.length(); i++) {
			Node k = t.M.get(s.charAt(i));
			if(k == null) {
				k = new Node(s.charAt(i));
				t.M.put(s.charAt(i), k);
				t = k;
			}else {
				t = k;
				t.d++;
			}
		}
	}
	public void delete(String s) {
		Node t = root;
		for(int i = 0; i < s.length(); i++) {
			Node k = t.M.get(s.charAt(i));
			if(k == null) {
				return;
			}else {
				t = k;
				t.d--;
			}
		}
	}
	public Node search(String s) {
		Node t = root;
		for(int i = 0; i < s.length(); i++) {
			t = t.M.get(s.charAt(i));
			if(t == null) return null;
		}
		return t;
	}
	public Node deletep(String s) {
		return null;
	}
	public void print(Node node) {
		for(Map.Entry<Character, Node> x : node.M.entrySet()) {
			System.out.println(x.getKey());
			Node child = x.getValue();
			if(child != null)
				print(child);
		}
	}
}