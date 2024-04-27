/** Abstract Stack interface */

public interface Stack 
{
	// most important methods
	public void   push(Object n); // push an object onto top of the stack
	public Object pop();    	  // pop an object from top of the stack

	// others   
	public Object  top(); 		  // examine top object on stack without removing it
	public boolean isEmpty();     // true if stack is empty
	public boolean isFull();  	  // true if stack is full (if it has limited storage)
}
