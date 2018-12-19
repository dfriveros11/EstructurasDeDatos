package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import edu.uniandes.common.utils.BinaryTree;
import edu.uniandes.common.utils.LinkedTree;

public class LinkedTreeTestCase {

	@Test
	public void testLinkedTree() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		assertEquals(0, tree.size());
	}

	@Test
	public void testInsert() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(3, tree.size());
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(3), iter.next());
	}
	
	@Test
	public void testPreOrder() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(8), iter.next());
	}
	
	@Test
	public void testPreOrder2() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(5);
		tree.insert(8);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(7), iter.next());
	}
	@Test
	public void testSearchLevels() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.searchLevels(1);
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(3), iter.next());
	}
	
	@Test
	public void testSearchLevels2() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(5);
		tree.insert(8);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.searchLevels(2);
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(8), iter.next());
	}
	@Test
	public void testPostOrder() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(2), iter.next());
	}
	
	@Test
	public void testPostOrder2() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(5);
		tree.insert(8);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(2), iter.next());
	}
	
	@Test
	public void testInOrder() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.inOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(8), iter.next());
	}
	
	@Test
	public void testInOrder2() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(5);
		tree.insert(8);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.inOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(8), iter.next());
	}

	@Test
	public void testDelete() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		
		assertEquals(1, tree.size());
		
		tree.delete(2);
		
		assertEquals(0, tree.size());
		
	}
	
	@Test
	public void testDelete2() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(2), iter.next());
		
		tree.delete(7);
		assertEquals(5, tree.size());
		
		Iterator<Integer> iter2 = tree.postOrder();
		assertEquals(new Integer(1), iter2.next());
		assertEquals(new Integer(5), iter2.next());
		assertEquals(new Integer(8), iter2.next());
		assertEquals(new Integer(3), iter2.next());
		assertEquals(new Integer(2), iter2.next());
	}
	
	@Test
	public void testDelete3() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		
		assertEquals(5, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(2), iter.next());
		
		tree.delete(7);
		assertEquals(4, tree.size());
		
		Iterator<Integer> iter2 = tree.postOrder();
		assertEquals(new Integer(1), iter2.next());
		assertEquals(new Integer(5), iter2.next());
		assertEquals(new Integer(3), iter2.next());
		assertEquals(new Integer(2), iter2.next());
	}
	
	@Test
	public void testDelete4() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(8);
		
		assertEquals(5, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(2), iter.next());
		
		tree.delete(7);
		assertEquals(4, tree.size());
		
		Iterator<Integer> iter2 = tree.postOrder();
		assertEquals(new Integer(1), iter2.next());
		assertEquals(new Integer(8), iter2.next());
		assertEquals(new Integer(3), iter2.next());
		assertEquals(new Integer(2), iter2.next());
	}
	
	@Test
	public void testDelete5() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(2), iter.next());
		
		tree.delete(2);
		assertEquals(5, tree.size());
		
		Iterator<Integer> iter2 = tree.postOrder();
		assertEquals(new Integer(1), iter2.next());
		assertEquals(new Integer(5), iter2.next());
		assertEquals(new Integer(8), iter2.next());
		assertEquals(new Integer(7), iter2.next());
		assertEquals(new Integer(3), iter2.next());
	}

	@Test
	public void testDelete6() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(7), iter.next());
		
		tree.delete(2);
		assertEquals(5, tree.size());
		
		Iterator<Integer> iter2 = tree.postOrder();
		assertEquals(new Integer(1), iter2.next());
		assertEquals(new Integer(3), iter2.next());
		assertEquals(new Integer(5), iter2.next());
		assertEquals(new Integer(8), iter2.next());
		assertEquals(new Integer(7), iter2.next());
	}
	
	@Test
	public void testDelete7() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(7);
		tree.insert(5);
		tree.insert(8);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(6, tree.size());
		
		Iterator<Integer> iter = tree.postOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(7), iter.next());
		
		tree.delete(5);
		assertEquals(5, tree.size());
		
		Iterator<Integer> iter2 = tree.postOrder();
		assertEquals(new Integer(1), iter2.next());
		assertEquals(new Integer(3), iter2.next());
		assertEquals(new Integer(2), iter2.next());
		assertEquals(new Integer(8), iter2.next());
		assertEquals(new Integer(7), iter2.next());
	}
	
	@Test
	public void testSearch() {
		BinaryTree<Integer> tree = new LinkedTree<Integer>();
		tree.insert(2);
		tree.insert(5);
		tree.insert(8);
		tree.insert(7);
		tree.insert(1);
		tree.insert(3);
		
		assertEquals(6, tree.size());
				  
		assertEquals(new Integer(1), tree.search(1));
		assertEquals(new Integer(5), tree.search(5));
		assertEquals(new Integer(8), tree.search(8));
		assertNull(tree.search(9));
	}

}
