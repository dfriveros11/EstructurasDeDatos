package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.common.utils.Graphs;

public class GraphsTestCase {
	
	private Graphs<String> graph;
	
	@Before
	public void setup(){
		graph = new Graphs<String>();
		
		graph.add("a", null, null);
		assertEquals(1, graph.getSize());
		
		graph.add("b", "2", "a");
		graph.add("c", "3", "a");
		graph.add("d", "4", "a");
		graph.add("e", "5", "a");
		graph.add("f", "6", "a");
		graph.add("g", "7", "a");
		assertEquals(6, graph.getCurva().size);
		assertEquals(7, graph.getSize());
	}
	
	@Test
	public void testSearch(){
		
		String a = graph.search("e");
		assertEquals(null, a);
		
		String b = graph.search("a");
		assertEquals("a", b);
	}
	

}
