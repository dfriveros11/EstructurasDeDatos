package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class DoubleLinkedListTestCase {

    @Test
    public void testAdd() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());

        iter = list.iterator();

        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());

        list.add("d");

        iter = list.iterator();

        assertEquals(4, list.size());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        assertEquals("d", iter.next());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        assertEquals("d", iter.next());

    }

    @Test
    public void testAddAll() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        List<String> elements = new LinkedList<String>();
        elements.add("a");
        elements.add("b");
        elements.add("c");
        list.addAll(elements);

        assertEquals(3, list.size());

        iter = list.iterator();

        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());

        List<String> elements2 = new LinkedList<String>();
        elements2.add("d");
        elements2.add("e");
        elements2.add("f");
        list.addAll(elements2);

        iter = list.iterator();

        assertEquals(6, list.size());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        assertEquals("d", iter.next());
        assertEquals("e", iter.next());
        assertEquals("f", iter.next());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
    }

    @Test
    public void testClear() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());

        list.clear();
        
        assertEquals(0, list.size());
       
        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }
    }

    @Test
    public void testIsEmpty() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertTrue(list.isEmpty());
        
        list.add("a");
        list.add("b");
        list.add("c");

        assertFalse(list.isEmpty());
        
        list.clear();
        
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemove() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());

        iter = list.iterator();

        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());

        list.remove("b");

        iter = list.iterator();

        assertEquals(2, list.size());
        assertEquals("a", iter.next());
        assertEquals("c", iter.next());
        assertEquals("a", iter.next());
        assertEquals("c", iter.next());
        
        list.remove("a");
        list.remove("c");
        assertFalse(list.remove("a"));
        assertFalse(list.remove("b"));
        assertFalse(list.remove("c"));
    }
    
    @Test
    public void testRemoveFirst() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());

        iter = list.iterator();

        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());

        list.remove("a");

        iter = list.iterator();

        assertEquals(2, list.size());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
    }
    
    @Test
    public void testRemoveLast() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());

        iter = list.iterator();

        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());

        list.remove("c");

        iter = list.iterator();

        assertEquals(2, list.size());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("a", iter.next());
        assertEquals("b", iter.next());
    }

    @Test
    public void testContains() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());
        
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertTrue(list.contains("c"));
    }

    @Test
    public void testSize() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());
    }

    @Test
    public void testToArray() {
        DoubleLinkedList<String> list = new DoubleLinkedList<String>();

        assertEquals(0, list.size());

        ListIterator<String> iter = list.iterator();
        try {
            iter.next();
            fail("Empty list iter.next() should throw NoSuchElementException");
        } catch (NoSuchElementException e) {
            // expected
        }

        list.add("a");
        list.add("b");
        list.add("c");

        assertEquals(3, list.size());
        
        assertArrayEquals(new String[] {"a", "b", "c"}, (String[])list.toArray(String.class));
    }
    
    @Test
    public void testIteratorAdd() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	
    	ListIterator<String> iterator = lista.iterator();
    	assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		iterator.add(null);    	
		assertNull(iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("a", iterator.next());

    }
    
    @Test
    public void testIteratorHasPrevious() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	
    	ListIterator<String> iterator = lista.iterator();
    	assertTrue(iterator.hasPrevious());
		assertEquals("a", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("b", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("c", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("a", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("b", iterator.previous());
		assertTrue(iterator.hasPrevious());
		assertEquals("a", iterator.previous());
		assertTrue(iterator.hasPrevious());
		assertEquals("c", iterator.previous());
		assertTrue(iterator.hasPrevious());
		assertEquals("b", iterator.previous());
    }
    
    @Test
    public void testIteratorNext() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	
    	ListIterator<String> iterator = lista.iterator();
    	assertTrue(iterator.hasNext());
		
    }
    
    @Test
    public void testIteratorNextIndex() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	lista.add("d");
    	lista.add("e");
    	
    	ListIterator<String> iter = lista.iterator();
    	assertEquals(0, iter.nextIndex());
    	iter.next();
    	assertEquals(1, iter.nextIndex());
    	iter.next();
    	assertEquals(2, iter.nextIndex());
    	iter.next();
    	assertEquals(3, iter.nextIndex());
    	iter.next();
    	assertEquals(4, iter.nextIndex());
    	iter.next();
        assertEquals(0, iter.nextIndex());
    }
    
    @Test
    public void testIteratorPrevious() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	
    	ListIterator<String> iterator = lista.iterator();
    	assertTrue(iterator.hasPrevious());
		assertEquals("a", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("b", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("c", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("a", iterator.next());
		assertTrue(iterator.hasPrevious());
		assertEquals("b", iterator.previous());
		assertTrue(iterator.hasPrevious());
		assertEquals("a", iterator.previous());
		assertTrue(iterator.hasPrevious());
		assertEquals("c", iterator.previous());
		assertTrue(iterator.hasPrevious());
		assertEquals("b", iterator.previous());

    }
    
    @Test
    public void testIteratorPreviousIndex() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	lista.add("d");
    	lista.add("e");
    	
    	ListIterator<String> iter = lista.iterator();
    	assertEquals(0, iter.previousIndex());
    	iter.previous();
    	assertEquals(4, iter.previousIndex());
        iter.previous();
        assertEquals(3, iter.previousIndex());
        iter.previous();
        assertEquals(2, iter.previousIndex());
        iter.previous();
        assertEquals(1, iter.previousIndex());
        iter.previous();
        assertEquals(0, iter.previousIndex());
    }
    
    @Test
    public void testIteratorRemove() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	
    	ListIterator<String> iter = lista.iterator();
   
    	iter.remove();
    	assertEquals("a", iter.next());
    	assertEquals("b", iter.next());
    	assertEquals("c", iter.next());
    	assertEquals("b", iter.next());
    	iter.remove();
    	assertEquals("c", iter.next());
    	assertEquals("b", iter.next());
    	assertEquals("b", iter.next());
    }
    
    @Test
    public void testIteratorSet() {
    	DoubleLinkedList<String> lista = new DoubleLinkedList<String>();
    	lista.add("a");
    	lista.add("b");
    	lista.add("c");
    	
    	ListIterator<String> iter = lista.iterator();
    	
    	iter.set("x");
    	
    	assertEquals("x", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
        
        iter = lista.iterator();
        
    	iter.set("a");
    	
    	assertEquals("a", iter.next());
        assertEquals("b", iter.next());
        assertEquals("c", iter.next());
    }
}
