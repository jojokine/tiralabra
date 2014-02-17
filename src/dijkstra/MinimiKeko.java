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

    /**
     * Poistetaan keosta pienin, siis ylimpänä oleva solmu ja palautetaan se
     *
     * @return
     */
    public Solmu poista() {
        Solmu poistettava;
        poistettava = keko[0];
        keko[0] = keko[koko - 1];
        koko--;
        if (koko > 0) {
            alas(0);
        }
        return poistettava;
    }

    /**
     * Siirretään indeksin määrittämää solmua keossa alaspäin kunnes se on
     * kekoehdon mukaan oikeassa kohdassa
     *
     * @param indeksi siirron aloitussolmun indeksi
     */
    public void alas(int indeksi) {
        int vasenIndeksi, oikeaIndeksi, pieninIndeksi;
        Solmu apu;
        vasenIndeksi = 2 * indeksi;
        oikeaIndeksi = 2 * indeksi + 1;
        if (oikeaIndeksi >= koko) {
            if (vasenIndeksi >= koko) {
                return;
            } else {
                pieninIndeksi = vasenIndeksi;
            }
        } else {
            if (keko[vasenIndeksi].getPaino() <= keko[oikeaIndeksi].getPaino()) {
                pieninIndeksi = vasenIndeksi;
            } else {
                pieninIndeksi = oikeaIndeksi;
            }
        }
        if (keko[indeksi].getPaino() > keko[pieninIndeksi].getPaino()) {
            apu = keko[pieninIndeksi];
            keko[pieninIndeksi] = keko[indeksi];
            keko[indeksi] = apu;
            alas(pieninIndeksi);
        }

    }

    /**
     * Palauttaa true tai false sen mukaan sisältääkö keko haetun solmun
     *
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
