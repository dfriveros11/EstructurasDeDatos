package edu.uniandes.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import edu.uniandes.common.utils.Tries;

public class TriesTestCase {

	private Tries<Integer> smallTree;

	@Before
	public void insert() {
		smallTree = new Tries<Integer>();
		boolean see = smallTree.insert("rico", 2);
		assertEquals(true, see);
		boolean see2 = smallTree.insert("rio", 4);
		assertEquals(true, see2);	
	}
	
	@Test
	public void delete(){
        Iterator<Integer> word = smallTree.searchWord("rico");
        assertEquals(new Integer(2), word.next());

        Iterator<Integer> word2 = smallTree.searchWord("rio");
        assertEquals(new Integer(4), word2.next());

		smallTree.delete("rico");

        Iterator<Integer> word3 = smallTree.searchWord("rio");
        assertEquals(new Integer(4), word3.next());

        try {
            smallTree.searchWord("rico");
            fail("Should have thrown exception");
        } catch (NoSuchElementException e) {
            //expected
        }
	}
	
	@Test
	public void searchWord() throws Exception{
		Iterator<Integer> word = smallTree.searchWord("rico");
		assertEquals(new Integer(2), word.next());

        Iterator<Integer> word2 = smallTree.searchWord("rio");
        assertEquals(new Integer(4), word2.next());
	}
	
	@Test
	public void searchPrefixExactMatch() throws Exception{
		Iterator<Integer> word = smallTree.searchPrefix("rico");
        assertEquals(new Integer(2), word.next());

        smallTree.insert("roma", 6);
        smallTree.insert("romano", 8);

        Iterator<Integer> word2 = smallTree.searchPrefix("romano");
        assertEquals(new Integer(8), word2.next());
        assertFalse(word2.hasNext());
	}

    @Test
    public void searchPrefixPartialMatch() throws Exception{
        Iterator<Integer> word = smallTree.searchPrefix("rico");
        assertEquals(new Integer(2), word.next());

        smallTree.insert("roma", 6);
        smallTree.insert("romano", 8);

        Iterator<Integer> word2 = smallTree.searchPrefix("roma");
        assertEquals(new Integer(6), word2.next());
        assertEquals(new Integer(8), word2.next());
        assertFalse(word2.hasNext());
    }

    @Test
    public void searchPrefixPartialMatch2() throws Exception{
        Iterator<Integer> word = smallTree.searchPrefix("rico");
        assertEquals(new Integer(2), word.next());

        smallTree.insert("roma", 6);
        smallTree.insert("romano", 8);

        Iterator<Integer> word2 = smallTree.searchPrefix("ri");
        assertEquals(new Integer(2), word2.next());
        assertEquals(new Integer(4), word2.next());
        assertFalse(word2.hasNext());
    }

    @Test
    public void searchPrefixAllElementsEmptyString() throws Exception{
        Iterator<Integer> word = smallTree.searchPrefix("rico");
        assertEquals(new Integer(2), word.next());

        smallTree.insert("roma", 6);
        smallTree.insert("romano", 8);

        Iterator<Integer> word2 = smallTree.searchPrefix("");
        assertEquals(new Integer(2), word2.next());
        assertEquals(new Integer(4), word2.next());
        assertEquals(new Integer(6), word2.next());
        assertEquals(new Integer(8), word2.next());
        assertFalse(word2.hasNext());
    }

    @Test
    public void searchPrefixAllElementsMatch() throws Exception{
        Iterator<Integer> word = smallTree.searchPrefix("rico");
        assertEquals(new Integer(2), word.next());

        smallTree.insert("roma", 6);
        smallTree.insert("romano", 8);

        Iterator<Integer> word2 = smallTree.searchPrefix("r");
        assertEquals(new Integer(2), word2.next());
        assertEquals(new Integer(4), word2.next());
        assertEquals(new Integer(6), word2.next());
        assertEquals(new Integer(8), word2.next());
        assertFalse(word2.hasNext());
    }

    @Test
    public void searchPrefixNoMatch() throws Exception{
        Iterator<Integer> word = smallTree.searchPrefix("rico");
        assertEquals(new Integer(2), word.next());

        smallTree.insert("roma", 6);
        smallTree.insert("romano", 8);

        Iterator<Integer> word2 = smallTree.searchPrefix("abc");
        assertFalse(word2.hasNext());
    }

    @Test
    public void searchPrefixNull() throws Exception{
        Iterator<Integer> word = smallTree.searchPrefix("rico");
        assertEquals(new Integer(2), word.next());

        smallTree.insert("roma", 6);
        smallTree.insert("romano", 8);

        try {
            smallTree.searchPrefix(null);
            fail("should throw a NullPointerException");
        } catch (NullPointerException e) {
            //expected
        }

    }
	
	@Test
	public void longestWord() throws Exception{
		Iterator<Integer> word = smallTree.searchLongestWord("rico");
		assertEquals(new Integer(2), word.next());
	}
}
