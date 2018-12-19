package edu.uniandes.common.utils;

import java.util.Iterator;

/**
 * @author diegor
 *
 * @param <T> the object value
 */
public interface List<T> extends Iterable<T> {
	
	/**
	 * This method add a object to the list
	 * @param o
	 * @return true if is added to the list, false if not
	 */
	public boolean add(T o);
	/**
	 * This method add a list 
	 * @param list
	 * @return true if is added, false if not
	 */
	public boolean addAll(List<T> list);
	/**
	 * This methos clear the list
	 */
	public void clear();
	/**
	 * Verify if the list is empty
	 * @return true if the list is empty
	 */
	public boolean isEmpty();
	/**
	 * remove a object of the list
	 * @param objeto
	 */
	public boolean remove(T o);
	
	/**
	 * Search if the object is in the list
	 * @param object
	 * return true if the object exist in the list, false if not
	 */
	public boolean contains(T o);
	
	/**
	 * This method return the size of the list
	 * return int
	 */
	public int size();
	
	/**
	 * This method give the list in a array form
	 * @param type
	 * @return T[]
	 */
	public T[] toArray(Class<T> type);
	
	/**
	 * Give the iterator form the list
	 */
	public Iterator<T> iterator();
	
	/**
	 * Compare to objects
	 * @param list
	 * @return true if the two objects are equals, false if not
	 */
	public boolean equals(Object list);
}
