package edu.uniandes.common.utils;


import org.junit.Test;

import edu.uniandes.common.utils.Huffman;

public class HuffmanTestCase {

	@Test
	public void testSimple() {
		Huffman huff = new Huffman("heladeria");
        huff.getCompressed();
		//assertEquals("1101000011101110001010111", huff.getCompressed());
	}

}
