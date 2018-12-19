package edu.uniandes.common.utils;


import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.Iterator;


/**
 * A table of key/value pairs
 * @author diegor
 *
 * @param <K> The type of the key
 * @param <T> The type of the value
 */
public class HashTable<K, T> implements Map<K, T>, Serializable {

	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
	 * A static for create the HashTable
	 */
	private static final int INITIAL_BUFFER_SIZE = 13;
	/**
	 * A static value of LOAD_FACTOR
	 */
	private static final double MAX_LOAD_FACTOR = 0.5;
	/**
	 * The list of the HashTable
	 */
	private List<Node<K, T>> [] lists;
	/**
	 * The size of the HashTable
	 */
	private int size;
	/**
	 * The bufferSize
	 */
	private int bufferSize;
	
	/**
	 * Constructor class
	 */
	public HashTable(){
		this(INITIAL_BUFFER_SIZE);
	}
	/**
	 * @param initialBufferSize
	 */
	private HashTable(int initialBufferSize) {
		this.bufferSize = initialBufferSize;
		List<Node<K,T>> tempLists = new LinkedList<Node<K, T>>();
		try {
			@SuppressWarnings("unchecked")
			List<Node<K, T>>[] lists = (List<Node<K, T>>[]) Array.newInstance(tempLists.getClass(), bufferSize);
			this.lists = lists;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.Map#put(java.lang.Object, java.lang.Object)
	 */
	public void put(K key, T elem) {
		int pos = getPositionForKey(key);
		
		if (lists[pos] == null) {
			lists[pos] = new LinkedList<Node<K,T>>();
		}
		List<HashTable<K, T>.Node<K, T>> list = lists[pos];
		
		Node<K, T> node = new Node<K, T>(key, elem);
		
		if (list.contains(node)) {
			list.remove(node);
		}
		
		list.add(node);
		size++;
		
		if (size / bufferSize > MAX_LOAD_FACTOR) {
			this.rehash();
		}
	}

	/**
	 * @param key
	 * @return
	 */
	private int getPositionForKey(K key) {
		return Math.abs(key.hashCode() % this.bufferSize);
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.Map#get(java.lang.Object)
	 */
	public T get(K key) {
		int pos = getPositionForKey(key);
		if (lists[pos] != null) {
			Iterator<Node<K,T>> iter = lists[pos].iterator();
			while (iter.hasNext()) {
				Node<K, T> n = iter.next();
				if (n.key.equals(key)) {
					return n.elem;
				}
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.Map#size()
	 */
	public int size() {
		return size;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.Map#keys()
	 */
	public List<K> keys() {
		List<K> keys = new LinkedList<K>();
		for (List<Node<K, T>> list : lists) {
			if (list != null) {
				for (Node<K, T> n : list) {
					keys.add(n.key);
				}
			}
		}
		
		return keys;
	}

	/* (non-Javadoc)
	 * @see edu.uniandes.diegoriveros.common.utils.Map#values()
	 */
	public List<T> values() {
		List<T> values = new LinkedList<T>();
		for (List<Node<K, T>> list : lists) {
			if (list != null) {
				for (Node<K, T> n : list) {
					values.add(n.elem);
				}
			}
		}
		
		return values;
	}

	public Iterator<Node<K, T>> getIterator() {
	    SortedList<List<Node<K, T>>> subListasPorTamano = new SortedList<List<Node<K,T>>>(new Comparator<List<Node<K,T>>>() {
            @Override
            public int compare(List<HashTable<K, T>.Node<K, T>> arg0, List<HashTable<K, T>.Node<K, T>> arg1) {
               return arg0.size() - arg1.size();
            }
        });
	    
	    for (List<Node<K, T>> subLista : lists) {
	        if (subLista.size() > 0) {
	            subListasPorTamano.add(subLista);
	        }
	    }
	    
	    return subListasPorTamano.first.t.iterator();
	}
	
	/**
	 * Represents an element within the HashTable. 
	 * Contains a single pair of key/value.
	 * @author diegor
	 *
	 * @param <P>
	 * @param <Q>
	 */
	private class Node<P,Q> implements Comparable<Node<P, Q>>, Serializable{
		/**
         * 
         */
        private static final long serialVersionUID = 1L;
        
        public P key;
		public Q elem;
		
		public Node() {
			
		}
		public Node(P k, Q t) {
			key = k;
			elem = t;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}
			
			Node<P, Q> node = new Node<P, Q>();
			if (!obj.getClass().equals(node.getClass())) {
				return false;
			}
			
			@SuppressWarnings("unchecked")
			Node<P, Q> objNode = (Node<P,Q>)obj;
			
			return (this.key.equals(objNode.key));
		}

		public int compareTo(Node<P, Q> o) {
			try {
				@SuppressWarnings("unchecked")			
				Comparable<P> thiskey = (Comparable<P>)this.key;
				return thiskey.compareTo(o.key);
			} catch (ClassCastException e) {
				throw new ClassCastException("The key type for the Hashtable must be Comparable");
			}
			
		}
	}
	
	/**
	 * The method to recalculate the size of the buffered table
	 */
	private void rehash() {
		HashTable<K, T> nuevaTabla = new HashTable<K, T>(bufferSize * 2 + 1);

		for (int j = 0; j < lists.length; j++) {
			if (lists[j] != null) {
				Iterator<Node<K, T>> iter = lists[j].iterator();

				while (iter.hasNext()) {
					Node<K, T> node = iter.next();
					nuevaTabla.put(node.key, node.elem);
				}
			}
		}

		this.lists = nuevaTabla.lists;
		this.bufferSize = nuevaTabla.bufferSize;
	}
	
    public void remove(K key) {
        int pos = getPositionForKey(key);
        
        if (lists[pos] != null) {
            for (Node<K, T> candidateNode : lists[pos]) {
                if (candidateNode.key.equals(key)) {
                    lists[pos].remove(candidateNode);
                    if (lists[pos].size() == 0) {
                        lists[pos] = null;
                    }
                    size--;
                }
            }            
        }
    }
}
