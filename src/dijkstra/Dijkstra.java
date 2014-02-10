package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author jojokine@cs
 */
public class Dijkstra {

    private static MinimiKeko keko = new MinimiKeko();
    // private static PriorityQueue<Solmu> pq = new PriorityQueue<Solmu>();
    private static ArrayList<Solmu> solmut = new ArrayList<Solmu>();

    /**
     *
     * @param verkko syötteenä annettava verkko
     * @param solmuja solmujen yhteislukumäärä verkossa
     * @param lahto lähtösolmun tunnus
     * @param kohde kohdesolmun tunnus
     * @return palauttaa arvonaan lyhimmän reitin painon lähtöpisteestä somulle
     */
    public int ratkaise(int[][] verkko, int solmuja, int lahto, int kohde) {
        keko.lisaa(new Solmu(lahto, 0, 0));
        // pq.add(new Solmu(lahto, 0, 0));
        // while (!pq.isEmpty()) {
        while (keko.getKoko() != 0) {
            // otetaan pq:sta päälimmäinen solmu ja katsotaan onko se haettava solmu, jos niin palalautetaan se
            Solmu nykyinen = keko.poista();
            // Solmu nykyinen = pq.poll();
            reitti(nykyinen);
            if (nykyinen.getTunnus() == kohde) {
                tulostaReitti(lahto, kohde);
                return nykyinen.getPaino();

            }
            for (int i = 0; i < solmuja; i++) { // jokaiselle solmulle
                if (verkko[nykyinen.getTunnus()][i] > 0) {
                    //Lisätään pq:hun solmu, jolla tunnus i ja painona nykyisen solmun paino sekä kaaren paino haettaavaan solmuun
                    keko.lisaa(new Solmu(i, nykyinen.getPaino() + verkko[nykyinen.getTunnus()][i], nykyinen.getTunnus()));
                    // pq.add(new Solmu(i, nykyinen.getPaino() + verkko[nykyinen.getTunnus()][i], nykyinen.getTunnus()));
                }
            }
        }
        return -1;
    }

    private void reitti(Solmu nykyinen) {
        if (!solmut.contains(nykyinen)) {
            solmut.add(nykyinen);
        }
    }

    public void tulostaReitti(int lahto, int kohde) {
        //String reitti;
        //reitti = "Lyhin reitti on: " + solmut.get(solmut.size() - 1).getTunnus() + " ";
        System.out.print("Lyhin reitti on: " + solmut.get(solmut.size() - 1).getTunnus() + " ");
        int kasiteltava = kohde;
        for (int i = solmut.size() - 1; i > 0; i--) {
            if (solmut.get(i).getEdellinen() != lahto && solmut.get(i).getTunnus() == kasiteltava) {
                //reitti = reitti + solmut.get(i).getEdellinen() + " ";
                System.out.print(solmut.get(i).getEdellinen() + " ");
                kasiteltava = solmut.get(i).getEdellinen();
                
            }
        }
        System.out.println(lahto);
        //reitti = reitti + lahto;
        //return reitti;

    }
}
