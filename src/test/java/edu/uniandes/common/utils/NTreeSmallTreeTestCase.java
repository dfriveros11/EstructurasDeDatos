package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.common.utils.NTree;

public class NTreeSmallTreeTestCase {

	private NTree<Integer> smallTree;

	@Before
	public void setUp() {
		smallTree = new NTree<Integer>();
		
		assertEquals(0, smallTree.size());
		
		smallTree.insert(null, 1);
		smallTree.insert(1, 2);
		
		assertEquals(2, smallTree.size());
	}
	
	@Test
	public void testSearch() {
		assertEquals(new Integer(2), smallTree.search(2));
	}

	@Test
	public void testPreOrder() {
		Iterator<Integer> iter = smallTree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
	}

	@Test
	public void testPostOrder() {
		Iterator<Integer> iter = smallTree.postOrder();
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(1), iter.next());
	}

	@Test
	public void testDarMenor() {
		assertEquals(new Integer(1), smallTree.getMin());
	}

	@Test
	public void testGetHeight() {
		assertEquals(2, smallTree.getHeight());
	}

	@Test
	public void testDelete() {
		smallTree.delete(1);
		
		assertEquals(2, smallTree.size());
		
		Iterator<Integer> iter = smallTree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
	}
	
	@Test
	public void testDelete2() {
		smallTree.delete(2);
		
		assertEquals(1, smallTree.size());
		
		Iterator<Integer> iter = smallTree.preOrder();
		assertEquals(new Integer(1), iter.next());
	}
	
}
