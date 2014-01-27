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
public class DijkstraTest {

    public DijkstraTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Testataan ratkaise-metodia nollasyötteellä.
     */
    @Test
    public void testRatkaiseNollilla() {
        int[][] verkko = null;
        int solmut = 0;
        int lahto = 0;
        int kohde = 0;
        Dijkstra instance = new Dijkstra();
        int expResult = 0;
        int result = instance.ratkaise(verkko, solmut, lahto, kohde);
        assertEquals(expResult, result);
    }

    /**
     * Testataan ratkaise-metodia anatamalla sille mahdoton syöte, pitäisi
     * palauttaa -1
     */
    @Test
    public void testEiRatkaisua() {
        int[][] verkko = null;
        int solmut = 0;
        int lahto = 0;
        int kohde = 4;
        Dijkstra instance = new Dijkstra();
        int expResult = -1;
        int result = instance.ratkaise(verkko, solmut, lahto, kohde);
        assertEquals(expResult, result);
    }

    /**
     * Testataan tilannetta jossa kaikkien kaarien paino on yksi
     */
    @Test
    public void testPainoAinaYksi() {
        int[][] verkko = new int[5][5];
        verkko[0][1] = verkko[1][0] = verkko[1][2] = verkko[2][1] = verkko[2][3] = verkko[3][2] = verkko[3][4] = verkko[4][3] = 1;
        int solmut = 5;
        int lahto = 0;
        int kohde = 4;
        Dijkstra instance = new Dijkstra();
        int expResult = 4;
        int result = instance.ratkaise(verkko, solmut, lahto, kohde);
        assertEquals(expResult, result);
    }

    /**
     * Testataan tilannetta jossa lähtösolmu on kohdesolmu
     */
    @Test
    public void testEiLiikuta() {
        int[][] verkko = new int[5][5];
        verkko[0][1] = verkko[1][0] = verkko[1][2] = verkko[2][1] = verkko[2][3] = verkko[3][2] = verkko[3][4] = verkko[4][3] = 1;
        int solmut = 5;
        int lahto = 0;
        int kohde = 0;
        Dijkstra instance = new Dijkstra();
        int expResult = 0;
        int result = instance.ratkaise(verkko, solmut, lahto, kohde);
        assertEquals(expResult, result);
    }

    @Test
    public void testTaulukolla() {
        int[][] testiVerkko = new int[6][6];
        testiVerkko[1][2] = testiVerkko[2][1] = testiVerkko[2][3] = testiVerkko[3][2] = testiVerkko[3][4] = testiVerkko[4][3] = testiVerkko[4][5] = testiVerkko[5][4] = 1;
        testiVerkko[1][3] = testiVerkko[3][1] = 3;
        testiVerkko[0][2] = testiVerkko[2][0] = 4;
        testiVerkko[2][4] = testiVerkko[4][2] = 5;
        testiVerkko[3][5] = testiVerkko[5][3] = 8;
        int solmut = 6;
        int lahto = 0;
        int kohde = 4;
        Dijkstra instance = new Dijkstra();
        int expResult = 6;
        int result = instance.ratkaise(testiVerkko, solmut, lahto, kohde);
        assertEquals(expResult, result);
    }

}
