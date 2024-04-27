/*
 * Abstract Queue interface
 */

public interface Queue {
	// most important methods
	public void   enqueue(Object n); // add an object at the rear of the queue
	public Object dequeue();    	 // remove an object from the front of the queue

	// others
	public boolean isEmpty();       // true if queue is empty
	public boolean isFull();      	// true if queue is full (if it has limited storage)
	public Object  front(); 		// examine front object on queue without removing it
}
