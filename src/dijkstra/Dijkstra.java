package dijkstra;

import java.util.PriorityQueue;

/**
 *
 * @author jojokine@cs
 */
public class Dijkstra {

    public static PriorityQueue<Solmu> pq = new PriorityQueue<Solmu>();
    private static int[][] verkko;

    public Dijkstra() {
        verkko = new int[6][6];
        verkko[1][2] = verkko[2][1] = verkko[2][3] = verkko[3][2] = verkko[3][4] = verkko[4][3] = verkko[4][5] = verkko[5][4] = 1;
        verkko[1][3] = verkko[3][1] = 3;
        verkko[0][2] = verkko[2][0] = 4;
        verkko[2][4] = verkko[4][2] = 5;
        verkko[3][5] = verkko[5][3] = 8;

    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        System.out.println(dijkstra.ratkaise(6, 0, 4));
        // TODO code application logic here
    }
    

    /**
     * 
     * @param solmut solmujen yhteislukumäärä verkossa
     * @param lahto lähtösolmun tunnus
     * @param kohde kohdesolmun tunnus
     * @return palauttaa arvonaan lyhimmän reitin painon lähtöpisteestä somulle
     */
    public int ratkaise(int solmut, int lahto, int kohde) {
        pq.add(new Solmu(lahto, 0));
        while (!pq.isEmpty()) {
            Solmu kukkuu = pq.poll();
            if (kukkuu.getTunnus() == kohde) {
                return kukkuu.getPaino();
            }
            for (int i = 0; i < solmut; i++) {
                if (verkko[kukkuu.getTunnus()][i] > 0) {
                    pq.add(new Solmu(i, kukkuu.getPaino() + verkko[kukkuu.getTunnus()][i]));
                }
            }

        }

        return -1;
    }
    
}
