package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.common.utils.BrotherSonTree;

public class BrotherSonTreeTestCase {

	BrotherSonTree<Integer> tree = new BrotherSonTree<Integer>();

	@Before
	public void testBrotherSonTree() {
		tree = new BrotherSonTree<Integer>();
		assertEquals(0, tree.size());

		tree.insert(null, 1);
		tree.insert(1, 2);
		tree.insert(1, 8);
		tree.insert(1, 9);
		tree.insert(1, 10);
		tree.insert(1, 11);

		assertEquals(6, tree.size());

		tree.insert(2, 3);
		tree.insert(2, 4);
		tree.insert(2, 5);
		tree.insert(2, 6);
		tree.insert(2, 7);

		assertEquals(11, tree.size());

		tree.insert(null, 20);
		tree.insert(20, 12);
		tree.insert(20, 18);
		tree.insert(20, 19);
		tree.insert(20, 21);

		assertEquals(16, tree.size());

		tree.insert(12, 13);
		tree.insert(12, 14);
		tree.insert(12, 15);
		tree.insert(12, 16);
		tree.insert(12, 17);

		assertEquals(21, tree.size());

		tree.insert(null, 40);
		tree.insert(40, 22);
		tree.insert(40, 28);
		tree.insert(40, 29);
		tree.insert(40, 30);
		tree.insert(40, 31);

		assertEquals(27, tree.size());

		tree.insert(22, 23);
		tree.insert(22, 24);
		tree.insert(22, 25);
		tree.insert(22, 26);
		tree.insert(22, 27);

		assertEquals(32, tree.size());

	}

	@Test
	public void testPreOrden() {

		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());

		assertEquals(new Integer(20), iter.next());
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		assertEquals(new Integer(17), iter.next());
		assertEquals(new Integer(18), iter.next());
		assertEquals(new Integer(19), iter.next());
		assertEquals(new Integer(21), iter.next());

		assertEquals(new Integer(40), iter.next());
		assertEquals(new Integer(22), iter.next());
		assertEquals(new Integer(23), iter.next());
		assertEquals(new Integer(24), iter.next());
		assertEquals(new Integer(25), iter.next());
		assertEquals(new Integer(26), iter.next());
		assertEquals(new Integer(27), iter.next());
		assertEquals(new Integer(28), iter.next());
		assertEquals(new Integer(29), iter.next());
		assertEquals(new Integer(30), iter.next());
		assertEquals(new Integer(31), iter.next());

	}

	@Test
	public void testPostOrden() {

		Iterator<Integer> iter = tree.postOrder();

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

		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		assertEquals(new Integer(17), iter.next());
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(18), iter.next());
		assertEquals(new Integer(19), iter.next());
		assertEquals(new Integer(21), iter.next());
		assertEquals(new Integer(20), iter.next());

		assertEquals(new Integer(23), iter.next());
		assertEquals(new Integer(24), iter.next());
		assertEquals(new Integer(25), iter.next());
		assertEquals(new Integer(26), iter.next());
		assertEquals(new Integer(27), iter.next());
		assertEquals(new Integer(22), iter.next());
		assertEquals(new Integer(28), iter.next());
		assertEquals(new Integer(29), iter.next());
		assertEquals(new Integer(30), iter.next());
		assertEquals(new Integer(31), iter.next());
		assertEquals(new Integer(40), iter.next());

	}

	@Test
	public void testOrdenInLevels() {

		Iterator<Integer> iter = tree.getAllLevels();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(20), iter.next());
		assertEquals(new Integer(40), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(18), iter.next());
		assertEquals(new Integer(19), iter.next());
		assertEquals(new Integer(21), iter.next());
		assertEquals(new Integer(22), iter.next());
		assertEquals(new Integer(28), iter.next());
		assertEquals(new Integer(29), iter.next());
		assertEquals(new Integer(30), iter.next());
		assertEquals(new Integer(31), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		assertEquals(new Integer(17), iter.next());
		assertEquals(new Integer(23), iter.next());
		assertEquals(new Integer(24), iter.next());
		assertEquals(new Integer(25), iter.next());
		assertEquals(new Integer(26), iter.next());
		assertEquals(new Integer(27), iter.next());


		
	}

	@Test
	public void testDarMenor() {
		BrotherSonTree<Integer> tree = new BrotherSonTree<Integer>();

		tree.insert(null, 50);
		tree.insert(50, 2);
		tree.insert(50, 8);
		tree.insert(50, 9);
		tree.insert(50, 10);
		tree.insert(50, 11);

		assertEquals(6, tree.size());

		tree.insert(2, 3);
		tree.insert(2, 4);
		tree.insert(2, 5);
		tree.insert(2, 6);
		tree.insert(2, 7);

		assertEquals(11, tree.size());

		tree.insert(null, 20);
		tree.insert(20, 12);
		tree.insert(20, 18);
		tree.insert(20, 19);
		tree.insert(20, 21);

		assertEquals(16, tree.size());

		tree.insert(12, 13);
		tree.insert(12, 14);
		tree.insert(12, 15);
		tree.insert(12, 16);
		tree.insert(12, 17);

		assertEquals(21, tree.size());

		tree.insert(null, 40);
		tree.insert(40, 22);
		tree.insert(40, 28);
		tree.insert(40, 29);
		tree.insert(40, 30);
		tree.insert(40, 31);

		assertEquals(27, tree.size());

		tree.insert(22, 1);
		tree.insert(22, 24);
		tree.insert(22, 25);
		tree.insert(22, 26);
		tree.insert(22, 27);

		assertEquals(32, tree.size());

		assertEquals(new Integer(1), tree.getMin());
		assertEquals(3, tree.getHeight());
	}

	@Test
	public void testSearchLevels() {

		Iterator<Integer> iter2 = tree.getLevel(2);
		assertEquals(new Integer(3), iter2.next());
		assertEquals(new Integer(4), iter2.next());
		assertEquals(new Integer(5), iter2.next());
		assertEquals(new Integer(6), iter2.next());
		assertEquals(new Integer(7), iter2.next());
		assertEquals(new Integer(13), iter2.next());
		assertEquals(new Integer(14), iter2.next());
		assertEquals(new Integer(15), iter2.next());
		assertEquals(new Integer(16), iter2.next());
		assertEquals(new Integer(17), iter2.next());
		assertEquals(new Integer(23), iter2.next());
		assertEquals(new Integer(24), iter2.next());
		assertEquals(new Integer(25), iter2.next());
		assertEquals(new Integer(26), iter2.next());
		assertEquals(new Integer(27), iter2.next());

		Iterator<Integer> iter3 = tree.getLevel(1);
		assertEquals(new Integer(2), iter3.next());
		assertEquals(new Integer(8), iter3.next());
		assertEquals(new Integer(9), iter3.next());
		assertEquals(new Integer(10), iter3.next());
		assertEquals(new Integer(11), iter3.next());
		assertEquals(new Integer(12), iter3.next());
		assertEquals(new Integer(18), iter3.next());
		assertEquals(new Integer(19), iter3.next());
		assertEquals(new Integer(21), iter3.next());
		assertEquals(new Integer(22), iter3.next());
		assertEquals(new Integer(28), iter3.next());
		assertEquals(new Integer(29), iter3.next());
		assertEquals(new Integer(30), iter3.next());
		assertEquals(new Integer(31), iter3.next());

		Iterator<Integer> iter4 = tree.getLevel(0);
		assertEquals(new Integer(1), iter4.next());
		assertEquals(new Integer(20), iter4.next());
		assertEquals(new Integer(40), iter4.next());
	}
	
	@Test
	public void testDelete() {
		tree.delete(25);
		
		assertEquals(31, tree.size());
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());

		assertEquals(new Integer(20), iter.next());
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		assertEquals(new Integer(17), iter.next());
		assertEquals(new Integer(18), iter.next());
		assertEquals(new Integer(19), iter.next());
		assertEquals(new Integer(21), iter.next());

		assertEquals(new Integer(40), iter.next());
		assertEquals(new Integer(22), iter.next());
		assertEquals(new Integer(23), iter.next());
		assertEquals(new Integer(24), iter.next());
		assertEquals(new Integer(26), iter.next());
		assertEquals(new Integer(27), iter.next());
		assertEquals(new Integer(28), iter.next());
		assertEquals(new Integer(29), iter.next());
		assertEquals(new Integer(30), iter.next());
		assertEquals(new Integer(31), iter.next());
	}
	
	@Test
	public void testDelete2() {
		tree.delete(2);
		
		assertEquals(32, tree.size());
		
		Iterator<Integer> iter = tree.preOrder();
		assertEquals(new Integer(1), iter.next());
		assertEquals(new Integer(2), iter.next());
		assertEquals(new Integer(3), iter.next());
		assertEquals(new Integer(4), iter.next());
		assertEquals(new Integer(5), iter.next());
		assertEquals(new Integer(6), iter.next());
		assertEquals(new Integer(7), iter.next());
		assertEquals(new Integer(8), iter.next());
		assertEquals(new Integer(9), iter.next());
		assertEquals(new Integer(10), iter.next());
		assertEquals(new Integer(11), iter.next());

		assertEquals(new Integer(20), iter.next());
		assertEquals(new Integer(12), iter.next());
		assertEquals(new Integer(13), iter.next());
		assertEquals(new Integer(14), iter.next());
		assertEquals(new Integer(15), iter.next());
		assertEquals(new Integer(16), iter.next());
		assertEquals(new Integer(17), iter.next());
		assertEquals(new Integer(18), iter.next());
		assertEquals(new Integer(19), iter.next());
		assertEquals(new Integer(21), iter.next());

		assertEquals(new Integer(40), iter.next());
		assertEquals(new Integer(22), iter.next());
		assertEquals(new Integer(23), iter.next());
		assertEquals(new Integer(24), iter.next());
		assertEquals(new Integer(25), iter.next());
		assertEquals(new Integer(26), iter.next());
		assertEquals(new Integer(27), iter.next());
		assertEquals(new Integer(28), iter.next());
		assertEquals(new Integer(29), iter.next());
		assertEquals(new Integer(30), iter.next());
		assertEquals(new Integer(31), iter.next());

	}
}
