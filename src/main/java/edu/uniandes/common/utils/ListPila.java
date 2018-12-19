package edu.uniandes.common.utils;

/**
 * @author df.riveros11
 *
 * @param <T>
 */
public class ListPila<T> extends DoubleLinkedList<T> implements IListPila<T> {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**o(1)
	 * @return
	 */
	public T consultarBase(){
		return first.t;
	}
	
	/**
	 * o(1)
	 * @return
	 */
	public T consultarTope(){
		return last.t;
	}

    @Override
    public T remove() {
        Node<T> node = this.last;
        if (node == null) {
            return null;
        }

        if (first == node) {
            first = first.next;
        }

        if (last != last.prev) {
            last = last.prev;
        } else {
            last = null;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        size--;
        return node.t;
        
    }

}
