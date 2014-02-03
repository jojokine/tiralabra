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
 * @author jojokine
 */
public class MinimiKekoTest {
    
    private Solmu testisolmu;
    private Solmu testisolmu1;
    private Solmu testisolmu2;
    private Solmu testisolmu3;
    private Solmu testisolmu4;
    
    public MinimiKekoTest() {
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
     * Test of lisaa method, of class MinimiKeko.
     */
    @Test
    public void testLisaa() {
        System.out.println("lisaa");
        MinimiKeko instance = new MinimiKeko();
        instance.lisaa(testisolmu);
//        instance.lisaa(testisolmu1);
//        instance.lisaa(testisolmu2);
//        instance.lisaa(testisolmu3);
        assertEquals(instance.sisaltaa(testisolmu), true);
//        assertEquals(instance.sisaltaa(testisolmu1), true);
//        assertEquals(instance.sisaltaa(testisolmu2), true);
//        assertEquals(instance.sisaltaa(testisolmu3), true);

    }

    /**
     * Test of poista method, of class MinimiKeko.
     */
    @Test
    public void testPoista() {
        System.out.println("poista");
        MinimiKeko instance = new MinimiKeko();
        Solmu expResult = null;
        Solmu result = instance.poista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of heapify method, of class MinimiKeko.
     */
    @Test
    public void testHeapify() {
        System.out.println("heapify");
        Solmu[] keko = null;
        int i = 0;
        MinimiKeko instance = new MinimiKeko();
        instance.heapify(keko, i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sisaltaa method, of class MinimiKeko.
     */
    @Test
    public void testSisaltaa() {
        System.out.println("sisaltaa");
        Solmu etsittava = testisolmu;
        MinimiKeko instance = new MinimiKeko();
        instance.lisaa(etsittava);
        assertEquals(instance.sisaltaa(etsittava), true);
    }
    
}
