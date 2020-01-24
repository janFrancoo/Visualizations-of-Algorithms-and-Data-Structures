package com.janfranco.datastructures;

public class Queue<E> {
	
	private E[] queueArr;	
	private int rear, front, queueSize;

	/**
	 * Constructor to create a queue data structure
	 * with given size
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public Queue(int size) {
		this.rear = 0;
		this.front = 0;
		this.queueSize = size;
		this.queueArr = (E[]) new Object[this.queueSize];
	}
	
	
	/**
	 * Default constructor to create the queue data structure
	 * with default size
	 */
	public Queue() {
		this(4);
	}
	
	/**
	 * This method returns the latest item that added to the queue
	 * @return
	 */
	public E getRear() {
		return this.queueArr[this.rear - 1];
	}
	
	/**
	 * This method returns the index of latest item
	 * @return
	 */
	public int getRearIndex() {
		return this.rear;
	}
	
	/**
	 * This method returns the front element of the queue
	 * @return
	 */
	public E getFront() {
		return this.queueArr[this.front];
	}
	
	/**
	 * This method returns the index of item in front
	 * @return
	 */
	public int getFrontIndex() {
		return this.front;
	}
	
	/**
	 * This method returns the size of queue
	 * @return
	 */
	public int getSize() {
		return this.queueSize;
	}
	
	/**
	 * This method returns true if the queue is empty
	 * @return
	 */
	public boolean isEmpty() {
		if(this.front == this.rear)
			return true;
		return false;
	}
	
	/**
	 * This method returns true if the queue is full
	 * @return
	 */
	public boolean isFull() {
		if(this.rear == this.queueSize)
			return true;
		return false;
	}
	
	private void increaseQueueSize() {
		int count = 0;
		@SuppressWarnings("unchecked")
		E[] newQueueArr = (E[]) new Object[this.queueSize*2];
		
		for(int i=this.front; i<this.rear; i++) {
			newQueueArr[count] = this.queueArr[i];
			count++;
		}
		
		this.queueArr = newQueueArr;
		this.front = 0;
		this.rear = count;
		this.queueSize *= 2;
	}
	
	/**
	 * This method adds an entry to the queue
	 * @param entitiy
	 */
	public void enqueue(E entry) {
		if(this.isFull())
			this.increaseQueueSize();
		this.queueArr[this.rear] = entry;
		this.rear++;
	}
	
	/**
	 * This method removes and returns the front of the queue
	 * @return
	 */
	public E dequeue() {
		if(this.isEmpty())
			return null;
		E entry = this.queueArr[this.front];
		this.front++;
		return entry;
	}
	
	/**
	 * This method returns the element at i in queue
	 * @return
	 */
	public E get(int i) {
		return this.queueArr[i];
	}
	
	/**
	 * This method prints the entries in the queue 
	 */
	public void printQueue() {
		for(int i=this.front; i<this.rear; i++)
			System.out.print(this.queueArr[i] + " ");
	}

	@Override
	public String toString() {
		String entities = "";
		for(int i=this.front; i<this.rear; i++)
			entities += String.valueOf(this.queueArr[i]) + " ";
		return entities;
	}
	
}
