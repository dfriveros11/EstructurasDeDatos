package edu.uniandes.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListPilaTestCase {

    @Test
    public void testConsultarBase() {
        IListPila<String> pila = new ListPila<String>();
        pila.add("a");
        assertEquals("a", pila.consultarBase());
        pila.add("b");
        assertEquals("a", pila.consultarBase());
        pila.add("c");
        assertEquals("a", pila.consultarBase());
    }

    @Test
    public void testConsultarTope() {
        IListPila<String> pila = new ListPila<String>();

        pila.add("a");
        assertEquals("a", pila.consultarTope());
        pila.add("b");
        assertEquals("b", pila.consultarTope());
        pila.add("c");
        assertEquals("c", pila.consultarTope());
    }

    @Test
    public void testRemove() {
        IListPila<String> pila = new ListPila<String>();

        pila.add("a");
        pila.add("b");
        pila.add("c");

        assertEquals("c", pila.remove());
        assertEquals("b", pila.remove());
        assertEquals("a", pila.remove());
        assertNull(pila.remove());
    }

}
