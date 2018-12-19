package edu.uniandes.common.utils;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements BidirectionalList<T>, Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    // ----------------------------------------------------------------------
    // Attributes
    // ----------------------------------------------------------------------

    protected Node<T>         first;
    protected Node<T>         last;
    protected int             size;

    // ----------------------------------------------------------------------
    // Builder
    // ----------------------------------------------------------------------

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.uniandes.diegoriveros.common.utils.List#add(java.lang.Object)
     */
    public boolean add(T o) {
        Node<T> n = new Node<T>(o);
        if (first == null) {
            first = n;
            last = n;
        }
        last.next = n;
        n.prev = last;
        n.next = first;
        first.prev = n;
        last = n;

        size++;

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.uniandes.diegoriveros.common.utils.List#addAll(edu.uniandes.diegoriveros
     * .common.utils.List)
     */
    public boolean addAll(List<T> list) {
        for (T t : list) {
            this.add(t);
        }

        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.uniandes.diegoriveros.common.utils.List#clear()
     */
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.uniandes.diegoriveros.common.utils.List#isEmpty()
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.uniandes.diegoriveros.common.utils.List#remove(java.lang.Object)
     */
    public boolean remove(T o) {
        Node<T> node = find(o);
        if (node == null) {
            return false;
        }

        if (first == node) {
            if (first != first.next) {
                first = first.next;
            } else {
                first = null;
            }
        }

        if (last == node) {
            if (last != last.prev) {
                last = last.prev;
            } else {
                last = null;
            }            
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }

        size--;
        return true;
    }

    /**
     * 
     * @param o
     * @return Pair<Node<T>>
     */
    private Node<T> find(T o) {
        Node<T> iter = this.first;
        while (iter != this.last && !(iter.t == null ? o == null : iter.t.equals(o))) {
            iter = iter.next;
        }

        if (iter != null && (iter.t == null ? o == null : iter.t.equals(o))) {
            return iter;
        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * edu.uniandes.diegoriveros.common.utils.List#contains(java.lang.Object)
     */
    public boolean contains(T o) {
        return find(o) != null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.uniandes.diegoriveros.common.utils.List#size()
     */
    public int size() {
        return size;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.uniandes.diegoriveros.common.utils.List#toArray(java.lang.Class)
     */
    public T[] toArray(Class<T> type) {
        @SuppressWarnings("unchecked")
        T array[] = (T[]) Array.newInstance(type, size);

        Node<T> n = this.first;
        for (int i = 0; i < size; i++) {
            array[i] = n.t;
            n = n.next;
        }
        
        return array;
    }

    /*
     * (non-Javadoc)
     * 
     * @see edu.uniandes.diegoriveros.common.utils.List#iterator()
     */
    public ListIterator<T> iterator() {
        return new ListIterator<T>() {
            private Node<T> iter = first;
            private int i = 0;

            public boolean hasNext() {
                return iter != null;
            }

            public T next() {
                if (iter == null) {
                    throw new NoSuchElementException();
                }
                T t = iter.t;
                iter = iter.next;
                i = (i == size - 1? i = 0 : i+1);
                return t;
            }

            public void remove() {
                if (iter == null) {
                    throw new NoSuchElementException("Cannot remove element from an empty list");
                }

                iter.prev.next = iter.next;
                iter.next.prev = iter.prev;

                if (iter == first) {
                    first = first.next;
                }
                if (iter == last) {
                    last = last.prev;
                }
                size--;
            }

            @Override
            public void add(T e) {
                Node<T> n = new Node<T>(e);
                if (first == null) {
                    first = n;
                    last = n;
                }
                iter.prev.next = n;
                n.prev = iter.prev;
                n.next = iter;
                iter.prev = n;
                iter = n;

                size++;
            }

            @Override
            public boolean hasPrevious() {
               return (iter != null);
            }

            @Override
            public int nextIndex() {
                return i;
            }

            @Override
            public T previous() {
                if (iter == null) {
                    throw new NoSuchElementException();
                }
                T t = iter.t;
                iter = iter.prev;
                i = (i == 0? i = size-1 : i-1);
                return t;
            }

            @Override
            public int previousIndex() {
                return i;
            }

            @Override
            public void set(T e) {
                iter.t =  e;
            }
        };
    }

    /*
     * (non-Javadoc)
     * 
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
    protected class Node<E> implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        public E                  t;
        public Node<E>            next;
        public Node<E>            prev;

        public Node(E o) {
            this.t = o;
        }
    }
}
