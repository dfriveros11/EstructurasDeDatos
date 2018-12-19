package edu.uniandes.common.utils;

import java.util.ListIterator;

public interface BidirectionalList<T> extends List<T> {

	@Override
	public ListIterator<T> iterator();
}
