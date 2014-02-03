/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

/**
 *
 * @author jojokine@cs
 */
public class MinimiKeko {

    private int koko;
    private Solmu[] keko;

    public int getKoko() {
        return koko;
    }

    public MinimiKeko() {
        koko = 0;
        keko = new Solmu[1];
    }

    /**
     * Lisätään uusi solmu kekoon alimmaiseksi
     *
     * @param lisattava lisättävä solmu
     */
    public void lisaa(Solmu lisattava) {
        koko++;
        keko[koko - 1] = lisattava;
        ylos(koko - 1);
        tarkistaKoko();
    }

    /**
     * Vaihdetaan solmujen paikkaa keossa niiden painon perusteella niin kauan
     * kunnes pienin on ylhäällä
     *
     * @param indeksi sen solmun indeksi, josta järjestystä aletaan tarkistaa
     */
    private void ylos(int indeksi) {
        int vanhempi;
        Solmu apu;
        if (indeksi != 0) {
            vanhempi = (int) java.lang.Math.floor(indeksi / 2);
            if (keko[vanhempi].getPaino() > keko[indeksi].getPaino()) {
                apu = keko[vanhempi];
                keko[vanhempi] = keko[indeksi];
                keko[indeksi] = apu;
                ylos(vanhempi);
            }
        }
    }

    public Solmu poista() {
        return null;

    }

//parent(i)
//return bi/2c
//left(i)
//return 2i
//right(i)
//return 2i+1
    public void heapify(Solmu[] keko, int i) {
        int vasen = 2 * i;
        int oikea = 2 * 1 + 1;

        {

        }
    }
/**
 * Palauttaa true tai false sen mukaan sisältääkö keko haetun solmun
 * @param etsittava haettava solmu
 * @return 
 */
    public boolean sisaltaa(Solmu etsittava) {
        for (int i = 0; i < keko.length; i++) {
            if (keko[i] == etsittava) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tarkistaa, riittääkö keon koko vielä uuden solmun lisäämiseksi
     */
    private void tarkistaKoko() {
        if (koko == keko.length) {
            kasvataKekoa();
        }
    }

    /**
     * Kekoa kasvatettaessa siitä tehdään kaksi kertaa nykyisen kokoinen
     */
    private void kasvataKekoa() {
        teeUusiKeko(keko.length * 2);
    }

    /**
     * Metodi tekee uuden keon annetun koon mukaan ja kopioi vanhan keon
     * sisällön siihen
     *
     * @param keonKoko uuden keon haluttu koko
     */
    private void teeUusiKeko(int keonKoko) {
        Solmu[] uusi = new Solmu[keonKoko];
        for (int i = 0; i < keko.length; i++) {
            uusi[i] = keko[i];
        }
        this.keko = uusi;
    }
}
