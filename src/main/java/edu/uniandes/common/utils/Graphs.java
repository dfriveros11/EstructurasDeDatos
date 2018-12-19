package edu.uniandes.common.utils;


public class Graphs<T> {
	
	//----------------------
	//Atributos
	//----------------------
	
	private GraphNode<T> initial;
	private LinkedList<Curve<T>> curva;
	private int size;
	
	//----------------------
	//Constructor
	//----------------------
	
	public Graphs(){
		this.initial = null;
		this.curva = new LinkedList<Curve<T>>();
		this.size = 0;
	}
	
	//----------------------
	//Getters and Setters
	//----------------------
	
	public GraphNode<T> getInitial() {
		return initial;
	}

	public LinkedList<Curve<T>> getCurva() {
		return curva;
	}
	
	public int getSize() {
		return size;
	}

	//----------------------
	//Method
	//----------------------
	

	public void add(T o, T value, T e){
		GraphNode<T> n = new GraphNode<T>(o);
		if (initial == null) {
			initial = n;
			size++;
		}else {
			if (value != null && e != null) {
				GraphNode<T> find = new GraphNode<T>(e);
				GraphNode<T> node = this.searchNode(find);
				if (node != null) {
					node.next = n;
					Curve<T> c = new Curve<T>(value, node, n);
					curva.add(c);
					size++;
				}
			}
			else {
				throw new IllegalArgumentException();
			}
		}
	}
	
	private GraphNode<T> searchNode(GraphNode<T> node){
		GraphNode<T> iter = this.initial;
		while (iter != null) {
			if (iter.element == node.element) {
				return iter;
			}
			iter = iter.next;
		}
		return null;
	}
	
	public T search(T o){
		GraphNode<T> search = new GraphNode<T>(o);
		GraphNode<T> find = this.searchNode(search);
		if (find != null) {
			return find.element;
		}
		return null;
	}
	
	protected class GraphNode<P>{
		
		protected P element;
		protected GraphNode<P> next;
		
		public GraphNode(P o){
			this.element = o;
		}
	}
	
	protected class Curve<E>{
		
		protected E element;
		protected String direction;
		
		public Curve(E o, GraphNode<E> current, GraphNode<E> add){
			this.element = o;
			this.direction = current.element+ "" + add.element;
		}
	}

}
