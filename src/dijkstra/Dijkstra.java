package dijkstra;

/**
 *
 * @author jojokine@cs
 */
public class Dijkstra {

    private static MinimiKeko keko = new MinimiKeko();
    private static Lista solmut; //= new Lista();
    private String reittirev;
    private String reitti;

    public static void main(String[] args) {
        Ui.ui();  
    }

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
        solmut = new Lista();
        while (keko.getKoko() != 0) {
            // otetaan keosta päälimmäinen solmu ja katsotaan onko se haettava solmu, jos niin palalautetaan se
            Solmu nykyinen = keko.poista();
            reitti(nykyinen);
            if (nykyinen.getTunnus() == kohde) {
                tulostaReitti(lahto, kohde);
                return nykyinen.getPaino();
            }
            for (int i = 0; i < solmuja; i++) { // jokaiselle solmulle
                if (verkko[nykyinen.getTunnus()][i] > 0) {
                    //Lisätään kekoon solmu, jolla tunnus i ja painona nykyisen solmun paino sekä kaaren paino haettaavaan solmuun
                    keko.lisaa(new Solmu(i, nykyinen.getPaino() + verkko[nykyinen.getTunnus()][i], nykyinen.getTunnus()));
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
        reitti = "Lyhin reitti on: ";
        reittirev = Dijkstra.solmut.get(Dijkstra.solmut.size() - 1).getTunnus() + " ";
        int kasiteltava = kohde;
        for (int i = Dijkstra.solmut.size() - 1; i > 0; i--) {
            if (Dijkstra.solmut.get(i).getEdellinen() != lahto && Dijkstra.solmut.get(i).getTunnus() == kasiteltava) {
                if (!reittirev.contains("" + Dijkstra.solmut.get(i).getEdellinen())) {
                    reittirev = reittirev + Dijkstra.solmut.get(i).getEdellinen() + " ";
                }
                kasiteltava = Dijkstra.solmut.get(i).getEdellinen();
            }
        }
        reittirev = reittirev + lahto;
        for (int i = reittirev.length() - 1; i >= 0; i--) {
            reitti = reitti + reittirev.charAt(i);
        }
        System.out.println(reitti);
    }
}
