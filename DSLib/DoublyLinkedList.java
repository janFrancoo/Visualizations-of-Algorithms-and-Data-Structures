package com.janfranco.datastructures;

import java.util.Iterator;

public class DoublyLinkedList<E> implements Iterable<E> {
	
	public class Node {
		public E value;
		Node next, prev;
	}
	
	private Node head;
	
	public DoublyLinkedList() {
		this.head = null;
	}
	
	public void insert(E value) {
		Node n = new Node();
		n.value = value;
		n.prev = null;
		n.next = null;
		
		if (this.head == null) {
			head = n;
			return;
		}
		
		Node t = this.head;
		while(t.next != null)
			t = t.next;
		
		t.next = n;
		n.prev = t;
	}
	
	public void remove(E value) {
		if (head == null)
			return;
		
		if (head.value == value) {
			head = head.next;
			head.prev = null;
			return;
		}
		
		Node t = head;
		while (t.next != null && t.value != value)
			t = t.next;
		
		if (t.value == value) {
			if (t.next == null) {
				t.prev.next = null;
			} 
			else {
				t.prev.next = t.next;
				t.next.prev = t.prev;
			}
		}

	}
	
	public boolean search(E value) {
		Node t = head;
		while(t != null) {
			if (t.value == value)
				return true;
			t = t.next;
		}
		return false;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public int getLength() {
		int len = 0;
		Node t = head;
		while (t != null) {
			t = t.next;
			len++;
		}
		return len;
	}
	
	public void print() {
		Node t = this.head;
		while (t != null) {
			if (t.next == null)
				System.out.print(t.value);
			else
				System.out.print(t.value + " -> ");
			t = t.next;
		}
		System.out.println();
	}
	
	public void clear() {
		this.head = null;
	}
	
	public class ListIterator implements Iterator<E> {

		Node t = head;
		
		@Override
		public boolean hasNext() {
			if (t != null)
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
