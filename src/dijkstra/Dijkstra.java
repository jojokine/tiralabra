package dijkstra;

import java.util.PriorityQueue;

/**
 *
 * @author jojokine@cs
 */
public class Dijkstra {

    public static PriorityQueue<Solmu> pq = new PriorityQueue<Solmu>();
    private static int[][] testiVerkko;

    /**
     * verkko testaamiseen
     */
    public Dijkstra() {
        testiVerkko = new int[6][6];
        testiVerkko[1][2] = testiVerkko[2][1] = testiVerkko[2][3] = testiVerkko[3][2] = testiVerkko[3][4] = testiVerkko[4][3] = testiVerkko[4][5] = testiVerkko[5][4] = 1;
        testiVerkko[1][3] = testiVerkko[3][1] = 3;
        testiVerkko[0][2] = testiVerkko[2][0] = 4;
        testiVerkko[2][4] = testiVerkko[4][2] = 5;
        testiVerkko[3][5] = testiVerkko[5][3] = 8;
    }

    /**
     * main testausta varten
     * @param args 
     */
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.ratkaise(testiVerkko, 6, 0, 4));
    }

    /**
     *
     * @param verkko syötteenä annettava verkko
     * @param solmut solmujen yhteislukumäärä verkossa
     * @param lahto lähtösolmun tunnus
     * @param kohde kohdesolmun tunnus
     * @return palauttaa arvonaan lyhimmän reitin painon lähtöpisteestä somulle
     */
    public int ratkaise(int[][] verkko, int solmut, int lahto, int kohde) {
        pq.add(new Solmu(lahto, 0, 0));
        while (!pq.isEmpty()) {
            //otetaan pq:sta päälimmäinen solmu ja katsotaan onko se haettava solmu, jos niin palalautetaan se
            Solmu nykyinen = pq.poll();
            if (nykyinen.getTunnus() == kohde) {
                System.out.println(nykyinen.getTunnus());
                System.out.println(nykyinen.getEdellinen());
                return nykyinen.getPaino();
                
            }
            for (int i = 0; i < solmut; i++) { // jokaiselle solmulle
                if (verkko[nykyinen.getTunnus()][i] > 0) {
                    //Lisätään pq:hun solmu, jolla tunnus i ja painona nykyisen solmun paino sekä kaaren paino haettaavaan solmuun
                    pq.add(new Solmu(i, nykyinen.getPaino() + verkko[nykyinen.getTunnus()][i], nykyinen.getTunnus()));
                }
            }
        }
        return -1;
    }
}
