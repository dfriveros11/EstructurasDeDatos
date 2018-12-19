package edu.uniandes.common.utils;

public class Tuple<T, V> {
	public T first;
	public V second;

	public Tuple() {
	}
	
	public Tuple(T t, V v) {
		this.first = t;
		this.second = v;
	}
}