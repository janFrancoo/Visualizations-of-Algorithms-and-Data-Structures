package com.janfranco.datastructures;

import java.util.Iterator;

public class CircularLinkedList<E> implements Iterable<E>{
	
	private Node head;
	
	public class Node {
		public E value;
		public Node next;
	}
	
	public CircularLinkedList() {
		this.head = null;
	}
	
	public void add(E value) {
		Node n = new Node();
		n.value = value;
		n.next = head;
		
		if (isListEmpty()) {
			head = n;
			n.next = head;
			return;
		}
		
		Node t = head;
		while(t.next != head)
			t = t.next;
		
		t.next = n;
	}
	
	public void remove(E value) {
		if (isListEmpty())
			return;
		
		Node t = head, prev = head;
		
		if (head != null && head.value == value) {
			while(t.next != head)
				t = t.next;
			t.next = head.next;
			head = head.next;
			return;
		}
		
		while(t.next != head && t.value != value) {
			prev = t;
			t = t.next;
		}
		
		if (t.value == value)
			prev.next = t.next;
	}
	
	public boolean isListEmpty() {
		if (head != null)
			return false;
		else return true;
	}
	
	public boolean search(E value) {
		Node t = head;
		
		if (t.value == value)
			return true;
		else
			t = t.next;
		
		while (t != head) {
			if (t.value == value)
				return true;
			t = t.next;
		}
		
		return false;
	}
	
	public void clean() {
		this.head = null;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public int getLength() {
		Node t = head;
		int length = 1;
		
		if (t == null)
			return 0;
		
		while(t.next != head) {
			length++;
			t = t.next;
		}
		
		return length;
	}
	
	public void print() {
		Node t = head;
		
		if (t != null) {
			System.out.print(t.value + " -> ");
			t = t.next;
		}
		
		while(t != head) {
			if (t.next == head)
				System.out.print(t.value + " -> " + t.next.value + "(head)");
			else
				System.out.print(t.value + " -> ");
			t = t.next;
		}
		
		System.out.println();
	}
	
	public class ListIterator implements Iterator<E> {

		Node t = head;
		
		@Override
		public boolean hasNext() {
			if (t != null && t.next != head)
				return true;
			return false;
		}

		@Override
		public E next() {
			E val = t.value;
			t = t.next;
			return val;
		}
		
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

}
