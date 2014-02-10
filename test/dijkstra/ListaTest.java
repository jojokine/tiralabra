/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jojokine@cs
 */
public class ListaTest {

    private Solmu testisolmu;
    private Solmu testisolmu1;
    private Solmu testisolmu2;
    private Solmu testisolmu3;

    public ListaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testisolmu = new Solmu(5, 4, 5);
        testisolmu1 = new Solmu(5, 3, 5);
        testisolmu2 = new Solmu(5, 2, 5);
        testisolmu3 = new Solmu(5, 1, 5);
    }

    @After
    public void tearDown() {
    }

    /**
     * Testataan että aloituskoko on nolla.
     */
    @Test
    public void testSizeZero() {
        Lista instance = new Lista();
        assertEquals(0, instance.size());
        assertEquals(1, instance.length());

    }

    /**
     * Testataan että koko muuttuu oikein lisäyksissä
     */
    @Test
    public void testSizeAfterAdds() {
        Lista instance = new Lista();

        instance.add(testisolmu);
        assertEquals(1, instance.size());
        assertEquals(2, instance.length());

        instance.add(testisolmu);
        assertEquals(2, instance.size());
        assertEquals(4, instance.length());

        instance.add(testisolmu);
        assertEquals(3, instance.size());
        assertEquals(4, instance.length());
    }

    /**
     * Test of contains method, of class Lista.
     */
    @Test
    public void testContains() {
        Lista instance = new Lista();
        instance.add(testisolmu);
        assertEquals(true, instance.contains(testisolmu));
    }

    /**
     * Test of add method, of class Lista.
     */
    @Test
    public void testAdd() {
        Lista instance = new Lista();
        instance.add(testisolmu);
        assertEquals(1, instance.size());
        assertEquals(true, instance.contains(testisolmu));
    }

    /**
     * Test of get method, of class Lista.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int indeksi = 0;
        Lista instance = new Lista();
        instance.get(indeksi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
