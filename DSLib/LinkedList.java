package com.janfranco.datastructures;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>{
	
	private Node head;
	
	public class Node {
		public E value;
		public Node next;
	}
	
	public LinkedList() {
		this.head = null;
	}
	
	public void add(E value) {
		Node n = new Node();
		n.value = value;
		n.next = null;
		
		if (head == null) {
			head = n;
			return;
		}
		
		Node t = head;
		while (t.next != null)
			t = t.next;
		
		t.next = n;
		return;
	}
	
	public void remove(E value) {
		if (isListEmpty())
			return;
		
		if (head != null && head.value == value) {
			head = head.next;
			return;
		}
		
		Node t = head, prev = head;
		
		while(t != null && t.value != value) {
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
		while (t != null) {
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
	
	public void print() {
		Node t = head;
		
		while(t != null) {
			if (t.next == null)
				System.out.print(t.value);
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
