package edu.uniandes.common.utils;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.common.utils.BrotherSonTree;
import edu.uniandes.common.utils.Tree;

public class BrotherSonTreeSmallTestCase {
	
	private Tree<Integer> smallTree;

	@Before
	public void setup() {
		smallTree = new BrotherSonTree<Integer>();
		smallTree.insert(null, 1);
		smallTree.insert(1, 2);
		smallTree.insert(null, 3);
		smallTree.insert(3, 4);
		
		assertEquals(4, smallTree.size());
	}
	
	@Test
	public void testPreOrder(){
		
		Iterator<Integer> iter = smallTree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
		
	}
	
	@Test
	public void testPostOrder() {
		Iterator<Integer> iter2 = smallTree.postOrder();
		assertEquals(new Integer(2), iter2.next());
		assertEquals(new Integer(1), iter2.next());
		assertEquals(new Integer(4), iter2.next());
		assertEquals(new Integer(3), iter2.next());
	}
	
	@Test
	public void testGetLevel() {
		Iterator<Integer> iter1 = smallTree.getLevel(0);
		assertEquals(new Integer(1), iter1.next());
		assertEquals(new Integer(3), iter1.next());
		
		Iterator<Integer> iter2 = smallTree.getLevel(1);
		assertEquals(new Integer(2), iter2.next());
		assertEquals(new Integer(4), iter2.next());
		
	}
	
	@Test
	public void testLevelsOrder() {
		Iterator<Integer> iter3 = smallTree.getAllLevels();
		assertEquals(new Integer(1), iter3.next());
		assertEquals(new Integer(3), iter3.next());
		assertEquals(new Integer(2), iter3.next());
		assertEquals(new Integer(4), iter3.next());
	}
	
	@Test
	public  void testDarMenor() {
		assertEquals(new Integer(1), smallTree.getMin());
	}

	@Test
	public void testDarAltura() {
		assertEquals(2, smallTree.getHeight());
	}
	
	@Test
	public void testDelete() {
		smallTree.delete(2);
		
		assertEquals(3, smallTree.size());
		
		Iterator<Integer> iter = smallTree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
	}
	
	@Test
	public void testDelete2() {
		smallTree.delete(1);
		
		assertEquals(4, smallTree.size());
		
		Iterator<Integer> iter = smallTree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
	}
}