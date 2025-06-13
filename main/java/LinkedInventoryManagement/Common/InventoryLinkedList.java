/*
 * Justin Jung
 * jxj180046
 */
package LinkedInventoryManagement.Common;

/**
 * InventoryLinkedList
 */
public class InventoryLinkedList<E extends Comparable<E>> {
	private int size = 0;
	private Node<E> head, tail;
	
	//Node for the LinkedList
	public static class Node<E>
	{
		public Node<E> prev, next;
		public E element;
		Node(E o)
		{
			element = o;
		}
	}
	//Creates an empty linked list
	public InventoryLinkedList()
	{
		
	}
	//Creates a linked list with a set of elements
    public InventoryLinkedList(E[] elements)
    {
    	for(int i = 0; i < elements.length; i++)
    	{
    		Insert(size,elements[i]);
    	}
    }
    //Returns the size of the linkedlist
    public Integer GetLength()
    {
    	return size;
    }
    //Gets the first element of the linkedlist
    public E GetFirst()
    {
    	return head.element;
    }
  //Gets the last element of the linkedlist
    public E GetLast()
    {
    	return tail.element;
    }
  //Inserts an element at a certain index in the linked list
    public void Insert(int index, E element)
    {
    	if(index == 0)
    	{
    		if(head == null)
    		{
    			Node<E> newhead = new Node<>(element);
    			head = tail = newhead;
    		}
    		else
    		{
    			Node<E> newhead = new Node<>(element);
    			newhead.next = head;
    			head.prev = newhead;
    			head = newhead;
    		}
    	}
    	else
    	if(index >= size)
    	{
    		if(tail == null)
    		{
    			Node<E> newtail = new Node<>(element);
    			tail = newtail;
    		}
    		else
    		{
    			Node<E> newtail = new Node<>(element);
    			newtail.prev = newtail;
    			tail.next = newtail;
    			tail = newtail;
    		}
    	}
    	else
    	{
    		Node<E> current = head;
    		Node<E> previous = current;
    		for(int i = 0; i < index; i++)
    		{
    			previous = current;
    			current = current.next;
    		}
    		Node<E> newNode = new Node<E>(element);
    		current.prev = newNode;
    		previous.next = newNode;
    		newNode.prev = previous;
    		newNode.next = current;
    	}
    	size++;
    }
  //Gets the element at an index of the linkedlist
    public E GetElement(int index)
    {
    	if(index < 0 || index > size)
    	{
    		return null;
    	}
    	Node<E> current = head;
    	for(int i = 0; i < index; i++)
    	{
    		current = current.next;
    	}
    	return current.element;
    }
  //Removes an element at a certain index in the linkedlist
    public E Remove(int index)
    {
    	if(index < 0 || index >= size)
    	{
    		return null;
    	}
    	else
    	if(index == 0)
    	{
    		head = head.next;
    		size--;
    		return head.element;
    	}
    	else if(index == size - 1)
    	{
    		tail = tail.prev;
    		size--;
    		return tail.element;
    	}
    	else
    	{
    		Node<E> current = head;
    		Node<E> previous = current;
    		for(int i = 0; i < index; i++)
    		{
    			previous = current;
    			current = current.next;
    		}
    		previous.next = current.next;
    		current.next.prev = previous;
    		size--;
    		return current.element;
    	}
    }
  //Prints out the linked list
    public String toString()
    {
    	StringBuilder result = new StringBuilder("[");
    	Node<E> current = head;
    	for(int i = 0; i < size; i++)
    	{
    		result.append(current.element);
    		current = current.next;
    		if(current != null)
    		{
    			result.append(", ");
    		}
    		else
    		{
    			result.append("]");
    		}
    	}
    	return result.toString();
    }
  //Check if the linked list has an element
    public boolean Contains(E element)
    {
    	Node<E> current = head;
    	for(int i = 0; i < size; i++)
    	{
    		if(current.element.equals(element))
    		{
    			return true;
    		}
    		current = current.next;
    	}
    	return false;
    }
  //Changes the element at a ceratin index
    public E SetElement(int index, E element)
    {
    	Node<E> current = head;
    	for(int i = 0; i < index; i++)
    	{
    		current = current.next;
    	}
    	current.element = element;
    	return current.element;
    }
    //Implement a generic linkedlist to support different data types. 
    //Use this class instead of using ArrayList.     
    //Create another class that represents the node of a linkedlist.

}