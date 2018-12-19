package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.uniandes.common.utils.HashTable;
import edu.uniandes.common.utils.List;

public class HashTableTestCase {
	@Test
	public void testAdd() {
		HashTable<String, String> table = new HashTable<String, String>();
		table.put("1", "a");
		
		assertEquals(1, table.size());
		assertEquals("a", table.get("1"));
	}
	@Test
	public void testAddMultiples() {
		HashTable<String, String> table = new HashTable<String, String>();
		table.put("1", "a");
		table.put("2", "b");
		table.put("3", "c");
		
		
		assertEquals(3, table.size());
		assertEquals("a", table.get("1"));
		assertEquals("b", table.get("2"));
		assertEquals("c", table.get("3"));
	}
	
	@Test
	public void testKeys() {
		HashTable<String, String> table = new HashTable<String, String>();
		table.put("1", "a");
		table.put("2", "b");
		table.put("3", "c");

		
		List<String> keys =table.keys();
		
		assertEquals(3, keys.size());
		assertTrue(keys.contains("1"));
		assertTrue(keys.contains("2"));
		assertTrue(keys.contains("3"));
	}
	@Test
	public void testValues() {
		HashTable<String, String> table = new HashTable<String, String>();
		table.put("1", "a");
		table.put("2", "b");
		table.put("3", "c");

		
		List<String> values =table.values();
		
		assertEquals(3, values.size());
		assertTrue(values.contains("a"));
		assertTrue(values.contains("b"));
		assertTrue(values.contains("c"));
	}
	
	@Test
    public void testRemove() {
        HashTable<String, String> table = new HashTable<String, String>();
        int numberOfElementsToAdd = 20;
        for (Integer i = 1; i <= numberOfElementsToAdd; i++) {
            table.put(i.toString(), i.toString());
        }
        
        assertEquals(numberOfElementsToAdd, table.size());
        assertNotNull(table.get("2"));
        
        List<String> values =table.values();
        
        assertEquals(numberOfElementsToAdd, values.size());
        for (Integer i = 1; i <= numberOfElementsToAdd; i++) {
            assertTrue(values.contains(i.toString()));
        }
        
        
        //removing elements
        int borrarDesde = 5;
        int borrarHasta = 15;
        for (Integer i = borrarDesde; i < borrarHasta; i++) {
            table.remove(i.toString());
        }
         
        
        //validating content of table after removal
        assertEquals(10, table.size());
        for (Integer i = borrarDesde; i < borrarHasta; i++) {
            assertNull(table.get(i.toString()));
        }
        
        List<String> values2 =table.values();
        
        assertEquals(10, values2.size());
        for (Integer i =1; i < borrarDesde; i++) {
            assertTrue(values2.contains(i.toString()));
        }
        for (Integer i = borrarHasta; i <= 20; i++) {
            assertTrue(values2.contains(i.toString()));
        }
    }
	
	
}
