package com.janfranco.datastructures;

public class Stack<E> {

	private E[] stackArr;
	private int stackSize, top;
	
	
	/**
	 * Constructor to create stack with given size
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public Stack(int size) {
		this.top = -1;
		this.stackSize = size;
		this.stackArr = (E[]) new Object[this.stackSize];
	}
	
	
	/**
	 * Default constructor to create stack with default size
	 */
	public Stack() {
		this(4);
	}
	
	
	/**
	 * This method returns true if the stack is empty
	 * @return
	 */
	public boolean isStackEmpty() {
		return (top == -1);
	}
	
	
	/**
	 * This method returns true if the stack is full
	 * @return
	 */
	public boolean isStackFull() {
		return (top == stackSize - 1);
	}
	
	private void increaseStackCapacity() {
		@SuppressWarnings("unchecked")
		E[] newStack = (E[]) new Object[this.stackSize*2];
		for(int i=0; i<stackSize; i++) {
			newStack[i] = stackArr[i];
		}
		this.stackArr = newStack;
		this.stackSize = this.stackSize * 2;
	}
	
	
	/**
	 * This method adds the given entry to the top of the stack
	 * @param entry
	 */
	public void push(E entry) {
		if(this.isStackFull())
			this.increaseStackCapacity();
		this.stackArr[++top] = entry;
	}
	
	/**
	 * This method removes the entry from the top of the stack
	 * @return
	 * @throws Exception
	 */
	public E pop() throws Exception {
		if(this.isStackEmpty())
			throw new Exception("Stack is empty.");
		return this.stackArr[top--];
	}
	
	/**
	 * This method returns the top of the stack
	 * @return
	 * @throws Exception
	 */
	public E peek() throws Exception {
		if(this.isStackEmpty())
			throw new Exception("Stack is empty");
		return stackArr[top];
	}

	@Override
	public String toString() {
		String entries = "";
		if(!this.isStackEmpty()) {
			for(int i=0; i<=top; i++) {
				entries += String.valueOf(this.stackArr[i]);
				entries += " ";
			}
		}
		return entries;
	}
	
}
