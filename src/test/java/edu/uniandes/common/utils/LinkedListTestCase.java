package edu.uniandes.common.utils;



import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.uniandes.common.utils.LinkedList;
import edu.uniandes.common.utils.List;


public class LinkedListTestCase {

	@Test
	public void testAdd() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		
		assertEquals(1, list.size());
		assertEquals("a", list.iterator().next());
	}
	
	@Test
	public void testAddMultiples() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		assertEquals(3, list.size());
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
	}
	
	@Test
	public void testAddAll() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		List<String> list2 = new LinkedList<String>();
		list2.add("d");
		list2.add("e");
		list2.add("f");
		
		list1.addAll(list2);
		
		assertEquals(6, list1.size());
		Iterator<String> iterator = list1.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		assertEquals("f", iterator.next());
	}
	
	@Test
	public void testAddAllMultiple() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		List<String> list2 = new LinkedList<String>();
		list2.add("d");
		list2.add("e");
		list2.add("f");
		
		list1.addAll(list2);
		
		List<String> list3 = new LinkedList<String>();
		list3.add("g");
		list3.add("h");
		list3.add("i");
		
		list1.addAll(list3);
		
		assertEquals(9, list1.size());
		Iterator<String> iterator = list1.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
		assertEquals("d", iterator.next());
		assertEquals("e", iterator.next());
		assertEquals("f", iterator.next());
		assertEquals("g", iterator.next());
		assertEquals("h", iterator.next());
		assertEquals("i", iterator.next());
	}

	@Test
	public void testClear() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		
		assertEquals(2, list.size());
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		
		list.clear();
		assertEquals(0, list.size());
		iterator = list.iterator();
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testContainsSingleElement() {
		List<String> list = new LinkedList<String>();
		list.add("a");
				
		assertEquals(1, list.size());		
		assertTrue(list.contains("a"));
	}
	
	@Test
	public void testContainsMultiElementFirst() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
				
		assertEquals(3, list.size());		
		assertTrue(list.contains("a"));
	}
	
	@Test
	public void testContainsMultiElementLast() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
				
		assertEquals(3, list.size());		
		assertTrue(list.contains("c"));
	}
	
	@Test
	public void testContainsMultiElementMiddle() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
				
		assertEquals(3, list.size());		
		assertTrue(list.contains("b"));
	}
	@Test
	public void testContainsFalse() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
				
		assertEquals(3, list.size());		
		assertFalse(list.contains("x"));
	}
	
	@Test
	public void testEquals() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		
		List<String> list2 = new LinkedList<String>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
				
		assertTrue(list1.equals(list2));		
	}
	
	@Test
	public void testEqualsWithNullElements() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add("b");
		list1.add(null);
		list1.add("c");
		
		List<String> list2 = new LinkedList<String>();
		list2.add("a");
		list2.add("b");
		list2.add(null);
		list2.add("c");
				
		assertTrue(list1.equals(list2));		
	}
	
	@Test
	public void testIsEmpty() {
		List<String> list1 = new LinkedList<String>();
		
		assertTrue(list1.isEmpty());
		
		list1.add("a");
		
		assertFalse(list1.isEmpty());		
		list1.clear();
				
		assertTrue(list1.isEmpty());		
	}
	
	@Test
	public void testIterator() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add("b");
		list1.add(null);
		list1.add("c");
		
		Iterator<String> iterator = list1.iterator();
		assertTrue(iterator.hasNext());
		assertEquals("a", iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("b", iterator.next());
		assertTrue(iterator.hasNext());
		assertNull(iterator.next());
		assertTrue(iterator.hasNext());
		assertEquals("c", iterator.next());
		assertFalse(iterator.hasNext());
		
		try {
			iterator.next();
			fail("Expected error");
		} catch (NoSuchElementException e) {
			//expected
		}		
	}
	

    @Test
    public void testIteratorRemove() {
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        
        Iterator<String> iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        iterator.remove();        
        assertTrue(iterator.hasNext());        
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());        
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Expected error");
        } catch (NoSuchElementException e) {
            //expected
        }       
    }
    
    @Test
    public void testIteratorRemoveFirst() {
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        
        Iterator<String> iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        iterator.remove();        
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());        
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Expected error");
        } catch (NoSuchElementException e) {
            //expected
        }       
    }
    
    @Test
    public void testIteratorRemoveSecond() {
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        
        Iterator<String> iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());   
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        iterator.remove();     
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());        
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Expected error");
        } catch (NoSuchElementException e) {
            //expected
        }       
    }
    
    @Test
    public void testIteratorRemoveSecondToLast() {
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        
        Iterator<String> iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());   
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());          
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        iterator.remove();   
        assertTrue(iterator.hasNext());        
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Expected error");
        } catch (NoSuchElementException e) {
            //expected
        }       
    }
    
    @Test
    public void testIteratorRemoveLast() {
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        
        Iterator<String> iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());   
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());          
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());        
        assertTrue(iterator.hasNext());        
        assertEquals("d", iterator.next());
        iterator.remove();   
        assertFalse(iterator.hasNext());
        
        iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Expected error");
        } catch (NoSuchElementException e) {
            //expected
        }       
    }
    
    @Test
    public void testIteratorMiddle() {
        List<String> list1 = new LinkedList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");
        
        Iterator<String> iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());   
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());          
        assertTrue(iterator.hasNext());
        assertEquals("c", iterator.next());        
        iterator.remove();
        assertTrue(iterator.hasNext());        
        assertEquals("d", iterator.next());
        assertTrue(iterator.hasNext());        
        assertEquals("e", iterator.next());           
        assertFalse(iterator.hasNext());
        
        iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("a", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("b", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("d", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("e", iterator.next());
        assertFalse(iterator.hasNext());
        
        try {
            iterator.next();
            fail("Expected error");
        } catch (NoSuchElementException e) {
            //expected
        }       
    }
	
	@Test
	public void testRemoveOneElemList() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		
		assertEquals(1, list.size());
		assertEquals("a", list.iterator().next());
		
		list.remove("a");
		
		assertEquals(0, list.size());
		assertFalse(list.iterator().hasNext());
		
	}
	
	@Test
	public void testRemoveFirstMultiElemList() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		
		assertEquals(2, list.size());
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		
		list.remove("a");
		
		assertEquals(1, list.size());
		iterator = list.iterator();
		assertEquals("b", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testRemoveFirstMultiElemLast() {
		List<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		
		assertEquals(2, list.size());
		Iterator<String> iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		
		list.remove("b");
		
		iterator = list.iterator();
		assertEquals("a", iterator.next());
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testRemoveNullElement() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add("b");
		list1.add(null);
		list1.add("c");

		list1.remove(null);
		
		assertEquals(3, list1.size());
		Iterator<String> iterator = list1.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertEquals("c", iterator.next());
	}
	
	@Test
	public void testRemoveMultiNullElement() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add(null);
		list1.add("b");
		list1.add(null);
		list1.add("c");

		list1.remove(null);
		
		assertEquals(4, list1.size());
		Iterator<String> iterator = list1.iterator();
		assertEquals("a", iterator.next());
		assertEquals("b", iterator.next());
		assertNull(iterator.next());
		assertEquals("c", iterator.next());
	}
	
	@Test
	public void testToArray() {
		List<String> list1 = new LinkedList<String>();
		list1.add("a");
		list1.add(null);
		list1.add("b");
		list1.add(null);
		list1.add("c");

		String[] array = list1.toArray(String.class);
		
		assertArrayEquals(new String[] {"a", null, "b", null, "c"}, array);

	}
}
