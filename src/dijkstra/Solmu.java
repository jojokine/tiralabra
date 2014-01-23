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
 * @param tunnus sisältää solmun int-arvoisen tunnuksen verkossa, solmujen indeksointi alkaa nollasta
 * @param paino sisältää pienimmän painon lähtöpisteestä kyseiselle solmulle
 */
    
    public Solmu(int tunnus, int paino) {
        setTunnus(tunnus);
        setPaino(paino);
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
