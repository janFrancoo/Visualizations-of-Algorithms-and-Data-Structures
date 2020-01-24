package com.janfranco.datastructures;

public class CircularQueue<E> {
	
	private E[] queueArr;	
	private int rear, front, queueSize;
	private boolean rTour;

	/**
	 * Constructor to create a queue data structure
	 * with given size
	 * @param size
	 */
	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		this.rear = 0;
		this.front = 0;
		this.queueSize = size;
		this.rTour = false;
		this.queueArr = (E[]) new Object[this.queueSize];
	}
	
	/**
	 * Default constructor to create the queue data structure
	 * with default size
	 */
	public CircularQueue() {
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
	 * This method returns the rTrue variable
	 * @return
	 */
	public boolean getRTour() {
		return this.rTour;
	}
	
	private boolean isSatisfied() {
	    if(!rTour) {
	        if(rear + 1 >= front)
	            return true;
	        return false;
	    }
	    else {
	        if(rear + 1 <= front)
	            return true;
	        return false;
	    }
	}
	
	/**
	 * This method adds an entry to the queue
	 * @param entitiy
	 */
	public void enqueue(E entry) {
		if(isSatisfied()) {
			queueArr[rear] = entry;
	        rear += 1;
	        if(rear == queueSize) {
	            rear = 0;
	            rTour = true;
	        }
		}
	}
	
	/**
	 * This method removes and returns the front of the queue
	 * @return
	 */
	public E dequeue() {
	    if(isSatisfied()) {
	        E element = queueArr[front];
	        front += 1;
	        if(front == queueSize) {
	            front = 0;
	            rTour = false;
	        }
	        return element;
	    }
	    return null;
	}
	
	/**
	 * This method returns the element at i in queue
	 * @return
	 */
	public E get(int i) {
		return this.queueArr[i];
	}
	
	/**
	 * This method returns the active size
	 * @return
	 */
	public int getActiveSize() {
		if(rear >= front)	return rear - front;
		else				return queueSize - front + rear;
	}
	
	/**
	 * This method prints the entries in the queue 
	 */
	public void printQueue() {
	    if(front > rear || (rear == front && rTour)) {
	        for(int i=front; i<queueSize; i++)
	            System.out.print(queueArr[i] + " ");
	        for(int i=0; i<rear; i++)
	            System.out.print(queueArr[i] + " ");
	    }
	    else {
	        for(int i=front; i<rear; i++)
	            System.out.print(queueArr[i] + " ");
	    }
	    System.out.println();
	}

	@Override
	public String toString() {
		String entities = "";
		if(front > rear || (rear == front && rTour)) {
	        for(int i=front; i<queueSize; i++)
	            entities += queueArr[i];
	        for(int i=0; i<rear; i++)
	        	entities += queueArr[i];
		}
	    else {
	        for(int i=front; i<rear; i++)
	        	entities += queueArr[i];
	    }
	    return entities;
	}
	
}
