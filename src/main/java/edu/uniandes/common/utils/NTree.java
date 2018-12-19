package edu.uniandes.common.utils;

import java.util.Iterator;

public class NTree<T extends Comparable<T>> implements Tree<T>{
	
	private Node<T> root;
	
	public NTree (){
		root = null;
	}

	public boolean insert(T parent, T object) {
		if (root == null) {
			Node<T> node = new Node<T>(object);
			root = node;
			return true;
		} 
		
		return root.insert(parent, object);		
	}

	public T delete(T object) {
		if (root != null) {
			return root.delete(object);
		}
		return null;
	}

	public T search(T object) {
		if (root != null) {
			return root.search(object);
		}
		return null;
	}

	public Iterator<T> preOrder() {
		List<T> lista = new LinkedList<T>();
		if (root != null) {
			root.preOrder(lista);
		}
		return lista.iterator();
	}

	public Iterator<T> postOrder() {
		List<T> lista = new LinkedList<T>();
		if (root != null) {
			root.postOrder(lista);
		}
		return lista.iterator();
	}

	public Iterator<T> getLevel(int level) {
		List<T> lista = new LinkedList<T>();
		if (root != null) {
			root.searchLevels(lista, level);
		}
		return lista.iterator();
	}

	public Iterator<T> getAllLevels(){
		List<T> lista = new LinkedList<T>();
		
		for (int h = 0; h < this.getHeight(); h++) {
			Iterator<T> nodeIter = this.getLevel(h);
			while (nodeIter.hasNext()) {
				lista.add(nodeIter.next());
			}
		}
		return lista.iterator();
	}
	
	public int size(){
		if (root != null) {
			return root.size() + 1;
		}
		return 0;
	}
	
	public T getMin(){
		if (root != null) {
			return root.getMin();
		}
		return null;
	}
	
	public int getHeight(){
		if (root != null) {
			return root.getHeight();
		}
		return 0;
	}

	protected class Node<P extends Comparable<P>> implements Comparable<Node<P>>{
		protected List<Node<P>> children; 
		protected P elem;
		
		public Node(P o){
			this.elem = o;
			children = new SortedList<Node<P>>();
		}
		
		public boolean insert(P parent, P elem) {
			Node<P> n = searchNode(parent);
			if (n != null) {
				n.children.add(new Node<P>(elem));
				return true;
			}
			return false;			
		}
		
		public P delete(P object) {
			Node<P> n = searchNode(object);
			Node<P> parentOfN = searchParentNode(object);
			if (n != null && n.children.size() == 0) {
				if (n != root) {
					parentOfN.children.remove(n);
				} else {
					root = null;
				}
				return n.elem;
			}
			return null;
		}
		
		public int size(){
			int valor = 0;
			Iterator<Node<P>> iter = this.children.iterator();
			while (iter.hasNext()) {
				Node<P> hijo =  iter.next();
				valor++;
				valor += hijo.size();
			}
			return valor;
		}
		
		private Node<P> searchParentNode(P objeto){
			for (Node<P> child: children) {
				if (child.elem.compareTo(objeto) == 0) {
					return this;
				}	
			}
			
			for (Node<P> child: children) {
				Node<P> parentOf = child.searchParentNode(objeto);
				if (parentOf != null) {
					return parentOf;
				}
			}
			
			return null;
		}
		
		private Node<P> searchNode(P objeto){
			int value = this.elem.compareTo(objeto);
			if (value == 0) {
				return this;
			}
			Iterator<Node<P>> iter = children.iterator();
			while (iter.hasNext()) {
				Node<P> node = iter.next().searchNode(objeto);
				if (node != null) {
					return node;
				}
			}
			return null;
		}
		
		public P search(P objeto){
			Node<P> node = searchNode(objeto);
			if (node != null) {
				return node.elem;
			}
			return null;
		}
		
		public void preOrder(List<P> lista){
			lista.add(this.elem);
			Iterator<Node<P>> iter = children.iterator();
			while (iter.hasNext()) {
				Node<P> hijo = iter.next();
				hijo.preOrder(lista);
			}
		}
		
		public void postOrder(List<P> lista){
			Iterator<Node<P>> iter = children.iterator();
			while (iter.hasNext()) {
				Node<P> hijo =  iter.next();
				hijo.postOrder(lista);
			}
			lista.add(this.elem);
		}
		
		public void searchLevels(List<P> list, int level){
			int value = 0;
			if (value == level) {
				list.add(this.elem);
			}else {
				Iterator<Node<P>> iter = this.children.iterator();
				while (iter.hasNext()) {
					Node<P> hijo = iter.next();
					hijo.searchLevels(list, level -1);
				}
			}
		}

		public P getMin(){
			P min = this.elem;
			return this.getMin(min);
		}
		
		private P getMin(P min) {
			if (this.elem.compareTo(min) < 0) {
				min = this.elem;
			}
			
			for (Node<P> child : children) {
				P childMin = child.getMin();
				if (childMin.compareTo(min) < 0) {
					min = childMin;
				}
			}
			
			return min;
		}
		
		public int getHeight(){
			int highestChild = 0;
			
			for (Node<P> child : children) {
				int childHeight = child.getHeight();
				if (childHeight > highestChild) {
					highestChild = childHeight;
				}
			}
			return highestChild + 1;
		}
		
		//@Override
		public int compareTo(Node<P> o) {
			return this.elem.compareTo(o.elem);
		}
	}

}
