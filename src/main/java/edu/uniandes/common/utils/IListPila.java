package edu.uniandes.common.utils;

import java.util.Iterator;



public interface IListPila<T>  extends Iterable<T>{

	 /* (non-Javadoc)
		 * @see edu.uniandes.common.utils.DoubleLinkedList#add(java.lang.Object)
		 * o(1) porque agrega en el ultimo
		 */
		public boolean add(T o);
		 
		  /**
		   * Remueve el ultimo de la lista
		 * @return 
		 */
		public T remove();
		
		/**o(1)
		 * @return
		 */
		public T consultarBase();
		
		/**
		 * o(1)
		 * @return
		 */
		public T consultarTope();
		
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
}

