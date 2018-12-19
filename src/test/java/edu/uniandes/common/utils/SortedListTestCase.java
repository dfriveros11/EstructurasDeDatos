package edu.uniandes.common.utils;



import java.util.Iterator;

import org.junit.Test;

import edu.uniandes.common.utils.List;
import edu.uniandes.common.utils.SortedList;
import static org.junit.Assert.*;


public class SortedListTestCase {

	@Test
	public void testAddMultiples() {
		List<Integer> list = new SortedList<Integer>();
		list.add(3);
		list.add(1);
		list.add(5);
		
		assertEquals(3, list.size());
		Iterator<Integer> iterator = list.iterator();
		assertEquals(new Integer(1), iterator.next());
		assertEquals(new Integer(3), iterator.next());
		assertEquals(new Integer(5), iterator.next());
	}
	
	@Test
	public void testAddMultiples2() {
		List<Integer> list = new SortedList<Integer>();
		list.add(5);
		list.add(3);
		list.add(1);
		
		assertEquals(3, list.size());
		Iterator<Integer> iterator = list.iterator();
		assertEquals(new Integer(1), iterator.next());
		assertEquals(new Integer(3), iterator.next());
		assertEquals(new Integer(5), iterator.next());
	}
	
	@Test
	public void testAddMultiples3() {
		List<Integer> list = new SortedList<Integer>();
		list.add(1);
		list.add(3);
		list.add(5);
		
		assertEquals(3, list.size());
		Iterator<Integer> iterator = list.iterator();
		assertEquals(new Integer(1), iterator.next());
		assertEquals(new Integer(3), iterator.next());
		assertEquals(new Integer(5), iterator.next());
	}
	
	@Test
	public void testAddNullElement() {
		List<Integer> list = new SortedList<Integer>();
		list.add(1);
		try {
			list.add(null);
			fail("Should throw IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			//expected
		}
		
	}
	
}
