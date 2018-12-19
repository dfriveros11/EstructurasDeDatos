package edu.uniandes.common.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface ITries<P> {

    /**
     * Insert the word
     * @param key
     * @param p
     * @return
     */
    public boolean insert(String key, P p);

    /**
     * Search the objects that are in the word
     * @param key
     * @return Iterator of the objects
     * @throws NoSuchElementException
     */
    public Iterator<P> searchWord(String key) throws NoSuchElementException;

    /**
     * Search the objects that are in the prefix
     * @param prefix
     * @return Iterator of the objects that are in the prefix
     */
    public Iterator<P> searchPrefix(String prefix);
    /**
     * Search the longest word
     * @param prefix
     * @return Iterator of the objects that are in the prefix
     */
    public Iterator<P> searchLongestWord(String word);

    /**
     * Delete a word
     * @param key
     */
    public void delete(String key);

}
