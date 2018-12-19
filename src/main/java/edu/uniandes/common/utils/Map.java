package edu.uniandes.common.utils;

/**
 * Represents a collection of key value pairs.
 * Each key is unique.
 * @author diegor
 *
 * @param <K> The key type
 * @param <T> The value type
 */
public interface Map<K,T> {
	/**
	 * Puts a value <code>elem</code> associated with the <code>key</code>
	 * @param key The key associated to the value
	 * @param elem The value to store
	 */
	public void put(K key, T elem);
	
	/**
	 * Returns the corresponding element associated to the <code>key</code>
	 * @param key The key identifying an element
	 * @return The element associated to the <code>key</code>. If there is no such element, returns null
	 */
	public T get(K key);
	
	/**
	 * Returns the number of elements in the map
	 * @return the number of elements in the map
	 */
	public int size();
	
	/**
	 * Returns a collection of the keys in the map.
	 * @return a collection of the keys in the map
	 */
	public List<K> keys();
	
	/**
	 * Returns a collection of the values in the map.
	 * @return a collection of the values in the map.
	 */
	public List<T> values();

	/**
	 * Removes the element correspondong to the <code>key</code> from the map
	 * @param key
	 */
    public void remove(K key);
}
