package dijkstra;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jojokine@cs
 */
public class SolmuTest {

    Solmu solmu;
    Solmu solmusuuri;

    @Before
    public void setUp() throws Exception {

        solmu = new Solmu(5, 5);
        solmusuuri = new Solmu(50, 50);
    }

    @Test
    public void testaaluonti() {

        assertEquals(solmu.getPaino(), 5);
        assertEquals(solmu.getTunnus(), 5);

    }

    @Test
    public void testCompareTo() {
        assertEquals(solmu.compareTo(solmusuuri), -1);
        assertEquals(solmusuuri.compareTo(solmu), 1);
        assertEquals(solmu.compareTo(solmu), 0);
    }
}
