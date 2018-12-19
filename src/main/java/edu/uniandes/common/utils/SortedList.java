package edu.uniandes.common.utils;

import java.util.Comparator;

/**
 * @author diegor
 *
 * @param <T>
 */
public class SortedList<T> extends LinkedList<T> implements List<T> {
	/**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Comparator<? super T> comparator;
    
    public SortedList() {
        comparator = new Comparator<T>() {

            @SuppressWarnings("unchecked")
            @Override
            public int compare(T o1, T o2) {
               return ((Comparable<? super T>)o1).compareTo(o2);
            }
        };
    }
    
    public SortedList(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }
    
    /* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.LinkedList#add(java.lang.Object)
	 */
	@Override
	public boolean add(T o) {
		if (o == null) {
			throw new IllegalArgumentException("Cannot add null element to sorted list");
		}
		Node<T> n = new Node<T>(o);
		
		Node<T> iterBefore = null;
		Node<T> iter = first;
		while (iter != null && comparator.compare(iter.t, o) <= 0) {
			iterBefore = iter;
			iter = iter.next;
		}
		if (iterBefore != null) {
			iterBefore.next = n;
		}
		if (iter == first) {
			first = n;
		}
		if (iter == null) {
			last = n;
		}
		n.next = iter;
		size++;
		return true;
	}
}
