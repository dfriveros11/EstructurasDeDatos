package edu.uniandes.common.utils;

import java.util.Iterator;

/**
 * @author diegor
 *
 * @param <T> object type
 */
public interface BinaryTree<T> {
	/**
	 * It inserts the new object into the Tree
	 * @param object
	 * @return if the object was added to the tree, it returns true, if not false
	 */
	public boolean insert(T object);
	/**
	 * It deletes the selected object
	 * @param object
	 * @return the object deleted in the tree
	 */
	public T delete(T object);
	/**
	 * It searchs the object. It returns the object but if the object does not exist it returns null
	 * @param object
	 * @return object
	 */
	public T search(T object);
	/**
	 *It adds the tree objects to a list in preOrden
	 * @return The iterator from the list
	 */
	public Iterator<T> preOrder();
	/**
	 *It adds the tree objects to a list in posOrden
	 * @return The iterator from the list
	 */
	public Iterator<T> postOrder();
	/**
	 *It adds the tree objects to a list in inOrden
	 * @return The iterator from the list
	 */
	public Iterator<T> inOrder();
	/**
	 * It adds the tree objects to a list in levels
	 * @param level
	 * @returnThe iterator from the list
	 */
	public Iterator<T> searchLevels(int level);
	
	/**
	 * It adds the tree objects to a list in levels
	 * @return iterator from the list
	 */
	public Iterator<T> getAllLevels();
	
	/**
	 * @return size
	 */
	public int size();
}
