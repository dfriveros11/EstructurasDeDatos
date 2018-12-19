package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.common.utils.NTree;

public class NTreeTestCase {

	private NTree<Integer> tree;

	@Before
	public void setUp(){
		
		tree = new NTree<Integer>();
		assertEquals(0, tree.size());
		
		tree.insert(null, 1);
		tree.insert(1, 2);
		tree.insert(1, 8);
		tree.insert(1, 9);
		tree.insert(1, 10);
		tree.insert(1, 11);
		
		tree.insert(2, 3);
		tree.insert(2, 4);
		tree.insert(2, 5);
		tree.insert(2, 6);
		tree.insert(2, 7);
		
		tree.insert(3, 12);
		tree.insert(3, 13);
		tree.insert(3, 14);
		tree.insert(3, 15);
		tree.insert(3, 16);
		
		assertEquals(16, tree.size());
	}
	
	@Test
	public void testPreOrder() {
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());	
		
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());
		
	}
	
	@Test
	public void testPostOrder(){		
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		assertEquals(new Integer(3), iter.next());
		
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(2), iter.next());		
		
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());
		assertEquals(new Integer(1), iter.next());
		
		
	}
	
	@Test
	public void testGetMin(){
		
		NTree<Integer> tree = new NTree<Integer>();
		tree.insert(null, 16);
		tree.insert(16, 2);
		tree.insert(16, 8);
		tree.insert(16, 9);
		tree.insert(16, 10);
		tree.insert(16, 11);
		
		tree.insert(2, 3);
		tree.insert(2, 4);
		tree.insert(2, 5);
		tree.insert(2, 6);
		tree.insert(2, 7);
		
		tree.insert(3, 12);
		tree.insert(3, 13);
		tree.insert(3, 14);
		tree.insert(3, 15);
		tree.insert(3, 1);
		
		assertEquals(16, tree.size());
		
		assertEquals(new Integer(1), tree.getMin());
		
	}
	
	@Test
	public void testSearchLevels(){
		
		tree.insert(8, 80);
		tree.insert(8, 81);
		tree.insert(8, 82);
		tree.insert(8, 83);
		tree.insert(8, 84);
	
		Iterator<Integer> iter = tree.getLevel(3);
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		
		Iterator<Integer> iter2 = tree.getLevel(2);
		assertEquals(new Integer(3), iter2.next());
		assertEquals(new Integer(4), iter2.next());
		assertEquals(new Integer(5), iter2.next());
		assertEquals(new Integer(6), iter2.next());
		assertEquals(new Integer(7), iter2.next());
		assertEquals(new Integer(80), iter2.next());
		assertEquals(new Integer(81), iter2.next());
		assertEquals(new Integer(82), iter2.next());
		assertEquals(new Integer(83), iter2.next());
		assertEquals(new Integer(84), iter2.next());
		
		Iterator<Integer> iter3 = tree.getLevel(1);
		assertEquals(new Integer(2), iter3.next());
		assertEquals(new Integer(8), iter3.next());
		assertEquals(new Integer(9), iter3.next());
		assertEquals(new Integer(10), iter3.next());
		assertEquals(new Integer(11), iter3.next());
		
		Iterator<Integer> iter4 = tree.getLevel(0);
		assertEquals(new Integer(1), iter4.next());
	}
	
	@Test
	public void testOrderInLevels(){
		
		tree.insert(8, 80);
		tree.insert(8, 81);
		tree.insert(8, 82);
		tree.insert(8, 83);
		tree.insert(8, 84);
		
		Iterator<Integer> iter = tree.getAllLevels();
		assertEquals(new Integer(1), iter.next());
		
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(8), iter.next());		
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());
		
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());		
		assertEquals(new Integer(80), iter.next());
		assertEquals(new Integer(81), iter.next());
		assertEquals(new Integer(82), iter.next());
		assertEquals(new Integer(83), iter.next());
		assertEquals(new Integer(84), iter.next());
				
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
	}
	
	@Test
	public void testGetHeight() {
		
		assertEquals(4, tree.getHeight());
		
		tree.insert(8, 80);
		tree.insert(8, 81);
		tree.insert(8, 82);
		tree.insert(8, 83);
		tree.insert(8, 84);
		
		assertEquals(4, tree.getHeight());
		
		tree.insert(12, 120);
		
		assertEquals(5, tree.getHeight());
	}
	
	@Test
	public void testDelete() {
		
		tree.delete(14);
		
		assertEquals(15, tree.size());
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());	
		
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());
	}
	
	@Test
	public void testDelete2() {
		
		tree.delete(3);
		
		assertEquals(16, tree.size());
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());	
		
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());
		
	}
}
