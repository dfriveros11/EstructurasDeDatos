package edu.uniandes.common.utils;

import java.util.Iterator;

public interface Tree<T>{
	/**
	 * It inserts the new object into the Tree
	 * @param object, parent
	 * @return if the object was added to the tree, it returns true, if not false
	 */
	public boolean insert(T parent, T object);
	/**
	 * It deletes the selected object
	 * @param object
	 * @return the object deleted in the tree
	 */
	public T delete(T object);
	/**
	 * It search the object. It returns the object but if the object does not exist it returns null
	 * @param object
	 * @return object
	 */
	public T search(T object);
	/**
	 * Returns the elements in a pre-order traversal (root, then left subtree, then right subtree)
	 * @return The iterator from the list
	 */
	public Iterator<T> preOrder();
	/**
	 * Returns the elements in a post-order traversal (left subtree, then right subtree, then root)
	 * @return The iterator from the list
	 */
	public Iterator<T> postOrder();
	/**
	 * Returns an iterator to all the elements in the tree on a given level
	 * @param level
	 * @returnThe iterator from the list
	 */
	public Iterator<T> getLevel(int level);
	/**
	 * Returns an iterator to all the elements in the tree ordered by level
     * (The equivalent of invoking getLevel(level) for all levels in the tree)
	 * @param level
	 * @returnThe iterator from the list
	 */
	public Iterator<T> getAllLevels();

    /**
	 * @returns the number of nodes in the tree
	 */
	public int size();
	
	/**
	 * @return the minimum value of the tree
	 */
	public T getMin();
	
	/**
	 * @return the height of the tree
	 */
	public int getHeight();
}
