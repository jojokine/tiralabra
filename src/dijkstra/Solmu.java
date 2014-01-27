package dijkstra;

/**
 *
 * @author jojokine@cs
 */
public class Solmu implements Comparable<Solmu> {

    private int tunnus;
    private int paino;
    private int edellinen;

    /**
     *
     * @param tunnus sisältää solmun int-arvoisen tunnuksen verkossa, solmujen
     * indeksointi alkaa nollasta
     * @param paino sisältää pienimmän painon lähtöpisteestä kyseiselle solmulle
     * @param edellinen sisältää solmun josta on tulutu tähän solmuun
     */
    public Solmu(int tunnus, int paino, int edellinen) {
        setTunnus(tunnus);
        setPaino(paino);
        setEdellinen(edellinen);
    }

    public void setTunnus(int tunnus) {
        this.tunnus = tunnus;
    }

    public void setPaino(int paino) {
        this.paino = paino;
    }

    public int getTunnus() {
        return tunnus;
    }

    public int getPaino() {
        return paino;
    }

    public int getEdellinen() {
        return edellinen;
    }

    public void setEdellinen(int edellinen) {
        this.edellinen = edellinen;
    }

    public int compareTo(Solmu o) {
        if (this.paino < o.paino) {
            return -1;
        }
        if (this.paino > o.paino) {
            return 1;
        }

        return 0;

    }

}
