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
        MinimiKeko instance = new MinimiKeko();
        lisaaSolmuja(instance);
        assertEquals(instance.sisaltaa(testisolmu), true);
        assertEquals(instance.sisaltaa(testisolmu1), true);
        assertEquals(instance.sisaltaa(testisolmu2), true);
        assertEquals(instance.sisaltaa(testisolmu3), true);

    }

    private void lisaaSolmuja(MinimiKeko instance) {
        instance.lisaa(testisolmu);
        instance.lisaa(testisolmu1);
        instance.lisaa(testisolmu2);
        instance.lisaa(testisolmu3);
    }

    /**
     * Test of poista method, of class MinimiKeko.
     */
    @Test
    public void testPoista() {
        MinimiKeko instance = new MinimiKeko();
        lisaaSolmuja(instance);
        assertEquals(testisolmu3, instance.poista());
        assertEquals(testisolmu2, instance.poista());
        assertEquals(testisolmu1, instance.poista());
        instance.lisaa(testisolmu1);
        assertEquals(testisolmu1, instance.poista());
        assertEquals(testisolmu, instance.poista());

    }

    /**
     * Test of sisaltaa method, of class MinimiKeko.
     */
    @Test
    public void testSisaltaa() {
        Solmu etsittava = testisolmu;
        MinimiKeko instance = new MinimiKeko();
        instance.lisaa(etsittava);
        assertEquals(instance.sisaltaa(etsittava), true);
    }

}
