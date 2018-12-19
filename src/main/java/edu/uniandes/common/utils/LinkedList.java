package edu.uniandes.common.utils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>, Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    //----------------------------------------------------------------------
	//Attributes
	//----------------------------------------------------------------------

	protected Node<T> first;
	protected Node<T> last;
	protected int size;
	
	//----------------------------------------------------------------------
	//Builder
	//----------------------------------------------------------------------

	public LinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	public LinkedList(T[] elems) {
        this();
        
        for (T t : elems) {
            this.add(t);
        }
    }
    /* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#add(java.lang.Object)
	 */
	public boolean add(T o) {
		Node<T> n = new Node<T>(o);
		if (first == null) {
			first = n;
			last = n;
		} else {
			last.next = n;
			last = n;
		}
		size++;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#addAll(edu.uniandes.diegoriveros.common.utils.List)
	 */
	public boolean addAll(List<T> list) {
		for (T t : list) {
			this.add(t);
		}
		
		return true;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#clear()
	 */
	public void clear() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#isEmpty()
	 */
	public boolean isEmpty() {
		return this.size == 0;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#remove(java.lang.Object)
	 */
	public boolean remove(T o) {
		Tuple<Node<T>, Node<T>> pair = find(o);
		Node<T> iterBefore = pair.first;
		Node<T> iter = pair.second;
		if (iter == null) {
			return false;
		}
		
		if (first == iter) {
			first = iter.next;
		}
		
		if (last == iter) {
			last = iterBefore;
		}
		
		if (iterBefore != null) {
			iterBefore.next = iter.next;
		}
		
		size--;
		return true;
	}

	/**
	 * 
	 * @param o
	 * @return Pair<Node<T>> 
	 */
	private Tuple<Node<T>, Node<T>> find(T o) {
		Node<T> iterBefore = null;
		Node<T> iter = this.first;
		while (iter != null && !((iter.t == null ? o == null : iter.t.equals(o)) || (iter.t == null  && o == null))) {
			iterBefore = iter;
			iter = iter.next;
		}
		
		if (iter != null && (iter.t == null ? o == null : iter.t.equals(o))) {
			return new Tuple<Node<T>, Node<T>>(iterBefore, iter);
		} else {
			return new Tuple<Node<T>, Node<T>>(null, null);
		}
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#contains(java.lang.Object)
	 */
	public boolean contains(T o) {
		Tuple<Node<T>, Node<T>> iterAndBefore = find(o);
		return iterAndBefore.second != null;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#size()
	 */
	public int size() {
		return size;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#toArray(java.lang.Class)
	 */
	public T[] toArray(Class<T> type) {
		@SuppressWarnings("unchecked")
		T array[] = (T[])Array.newInstance(type, size);
		
		Iterator<T> iter = this.iterator();
		int i = 0;
		while (iter.hasNext()) {
			array[i] = iter.next();
			i++;
		}
		
		return array;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.List#iterator()
	 */
	public Iterator<T> iterator() {
		return new Iterator<T>() {		    
		    private Node<T> prev = null;
		    private Node<T> prevPrev = null;
			private Node<T> iter = first;
			public boolean hasNext() {
				return iter != null;
			}

			public T next() {
				if (iter == null) {
					throw new NoSuchElementException();
				}
				if (prevPrev == null || (prevPrev != null && prevPrev.next != iter)) {
				    prevPrev = prev;
				}
				prev = iter;				
				T t = iter.t;
				iter = iter.next;
				return t;
			}

			public void remove() {
			    if (prev == null) {
			        throw new IllegalStateException("Cannot remove an element before calling next() first");
			    }
			    if (prev == first) {
			        first = prev.next;
			        prev = null;
			    }
			    if (prev == last) {
			        prevPrev.next = null;
			        last = prevPrev;
			        prev = null;
			    }
			    if (prev != null) {
			        prevPrev.next = iter;
			    }
			    size--;
			}
		};
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) o;
		if (list == null) {
			return false;
		}

		if (this == list) {
			return true;
		}
		
		if (this.size() != list.size()) {
			return false;
		}
		
		Iterator<T> thisIter = this.iterator();
		Iterator<T> listIter = list.iterator();
		
		while (thisIter.hasNext()) {
			T elem1 = thisIter.next();
			T elem2 = listIter.next();
			if (!(elem1 == null ? elem2 == null : elem1.equals(elem2))) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @author diegor
	 *
	 * @param <E>
	 */
	protected class Node<E> implements Serializable{
		/**
         * 
         */
        private static final long serialVersionUID = 1L;
        
        public E t;
		public Node<E> next;
		
		public Node(E o) {
			this.t = o;
		}
	}
}
