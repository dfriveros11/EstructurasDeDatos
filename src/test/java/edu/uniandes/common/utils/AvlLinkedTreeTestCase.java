package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import edu.uniandes.common.utils.AvlLinkedTree;

public class AvlLinkedTreeTestCase {


	@Test
	public void testInsert() {
		AvlLinkedTree<Integer> tree = new AvlLinkedTree<Integer>();
		tree.insert(50);
		tree.insert(25);
		tree.insert(70);
		tree.insert(15);
		tree.insert(40);
		tree.insert(60);
		tree.insert(90);
		tree.insert(30);
		tree.insert(80);
		tree.insert(95);
		
		tree.balance();
		
		assertEquals(10, tree.size());
		assertEquals(4, tree.getHeight());
		
		Iterator<Integer> iter = tree.preOrder();
		//revisar
		assertEquals(new Integer(50), iter.next());
		assertEquals(new Integer(25), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(40), iter.next());
		assertEquals(new Integer(30), iter.next());
		assertEquals(new Integer(70), iter.next());
		assertEquals(new Integer(60), iter.next());
		assertEquals(new Integer(90), iter.next());
		assertEquals(new Integer(80), iter.next());
		assertEquals(new Integer(95), iter.next());
		
		tree.insert(75);
		tree.balance();
		
		assertEquals(11, tree.size());
		//revisar el gethigh, al insertar uno nuevo no lo vuelve a balancear
		assertEquals(4, tree.getHeight());
		
		Iterator<Integer> iter2 = tree.preOrder();
		assertEquals(new Integer(50), iter2.next());
		assertEquals(new Integer(25), iter2.next());
		assertEquals(new Integer(15), iter2.next());
		assertEquals(new Integer(40), iter2.next());
		assertEquals(new Integer(30), iter2.next());
		assertEquals(new Integer(80), iter2.next());
		assertEquals(new Integer(70), iter2.next());
		assertEquals(new Integer(60), iter2.next());
		assertEquals(new Integer(75), iter2.next());
		assertEquals(new Integer(90), iter2.next());
		assertEquals(new Integer(95), iter2.next());
	}
	
	@Test
	public void testInsert2() {
		AvlLinkedTree<Integer> tree = new AvlLinkedTree<Integer>();
		tree.insert(50);
		tree.insert(25);
		tree.insert(80);
		tree.insert(15);
		tree.insert(40);
		tree.insert(60);
		tree.insert(8);
		tree.insert(20);
		tree.insert(90);
		tree.insert(70);
		
		tree.balance();
		
		assertEquals(10, tree.size());
		assertEquals(4, tree.getHeight());
		
		Iterator<Integer> iter = tree.preOrder();
		//revisar
		assertEquals(new Integer(50), iter.next());
		assertEquals(new Integer(25), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(20), iter.next());
		assertEquals(new Integer(40), iter.next());
		assertEquals(new Integer(80), iter.next());
		assertEquals(new Integer(60), iter.next());
		assertEquals(new Integer(70), iter.next());
		assertEquals(new Integer(90), iter.next());
		
		tree.insert(22);
		tree.balance();
		
		assertEquals(11, tree.size());
		//revisar el gethigh, al insertar uno nuevo no lo vuelve a balancear
		assertEquals(4, tree.getHeight());
		
		Iterator<Integer> iter2 = tree.preOrder();
		assertEquals(new Integer(50), iter2.next());
		assertEquals(new Integer(20), iter2.next());
		assertEquals(new Integer(15), iter2.next());
		assertEquals(new Integer(8), iter2.next());
		assertEquals(new Integer(25), iter2.next());
		assertEquals(new Integer(22), iter2.next());
		assertEquals(new Integer(40), iter2.next());
		assertEquals(new Integer(80), iter2.next());
		assertEquals(new Integer(60), iter2.next());
		assertEquals(new Integer(70), iter2.next());
		assertEquals(new Integer(90), iter2.next());
	}

	@Test
	public void testDelete() {
		AvlLinkedTree<Integer> tree = new AvlLinkedTree<Integer>();
		tree.insert(30);
		tree.insert(40);
		tree.insert(16);
		tree.insert(8);
		tree.insert(33);
		tree.insert(90);
		tree.insert(60);
		tree.insert(32);
		tree.insert(96);
		tree.insert(26);
		tree.insert(28);
		tree.insert(35);
		tree.insert(37);
		tree.insert(50);
		
		tree.balance();
		
		assertEquals(14, tree.size());
		assertEquals(5, tree.getHeight());
		
		Iterator<Integer> iter = tree.preOrder();
		//revisar
		assertEquals(new Integer(30), iter.next());
		assertEquals(new Integer(16), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(26), iter.next());
		assertEquals(new Integer(28), iter.next());
		assertEquals(new Integer(40), iter.next());
		assertEquals(new Integer(33), iter.next());
		assertEquals(new Integer(32), iter.next());
		assertEquals(new Integer(35), iter.next());
		assertEquals(new Integer(37), iter.next());
		assertEquals(new Integer(90), iter.next());
		assertEquals(new Integer(60), iter.next());
		assertEquals(new Integer(50), iter.next());
		assertEquals(new Integer(96), iter.next());
		
		tree.delete(28);
		tree.balance();
		
		assertEquals(13, tree.size());
		assertEquals(5, tree.getHeight());
		
		Iterator<Integer> iter2 = tree.preOrder();
		//revisar
		assertEquals(new Integer(40), iter2.next());
		assertEquals(new Integer(30), iter2.next());
		assertEquals(new Integer(16), iter2.next());
		assertEquals(new Integer(8), iter2.next());
		assertEquals(new Integer(26), iter2.next());
		assertEquals(new Integer(33), iter2.next());
		assertEquals(new Integer(32), iter2.next());
		assertEquals(new Integer(35), iter2.next());
		assertEquals(new Integer(37), iter2.next());
		assertEquals(new Integer(90), iter2.next());
		assertEquals(new Integer(60), iter2.next());
		assertEquals(new Integer(50), iter2.next());
		assertEquals(new Integer(96), iter2.next());
	}

	@Test
	public void testSearch() {
		AvlLinkedTree<Integer> tree = new AvlLinkedTree<Integer>();
		tree.insert(30);
		tree.insert(40);
		tree.insert(16);
		tree.insert(8);
		tree.insert(33);
		tree.insert(90);
		tree.insert(60);
		tree.insert(32);
		tree.insert(96);
		tree.insert(26);
		tree.insert(28);
		tree.insert(35);
		tree.insert(37);
		tree.insert(50);
		
		tree.balance();
		
		assertEquals(14, tree.size());
		assertEquals(5, tree.getHeight());
				  
		assertEquals(new Integer(35), tree.search(35));
		assertEquals(new Integer(26), tree.search(26));
		assertEquals(new Integer(60), tree.search(60));
		
		tree.delete(60);
		tree.balance();
		
		assertEquals(13, tree.size());
		assertEquals(5, tree.getHeight());
		assertNull(tree.search(60));
	}

}
