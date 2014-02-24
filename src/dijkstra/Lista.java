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
public class Lista {

    private int koko;
    private Solmu[] lista;

    public Lista() {
        koko = 0;
        lista = new Solmu[1];
    }

    public int length() {
        return lista.length;
    }

    public int size() {
        return koko;
    }

    /**
     * Tarkistetaan onko kyseinen solmu listalla
     *
     * @param haettava listalta etsittävä solmu
     * @return palauttaa true tai false sen mukaan onko solmu listalla tai ei
     */
    public boolean contains(Solmu haettava) {
        for (Solmu lista1 : lista) {
            if (lista1 == haettava) {
                return true;
            }
        }
        return false;
    }

    /**
     * uuden solmun lisääminen listaan
     *
     * @param lisattava lisättävä Solmu
     */
    public void add(Solmu lisattava) {
        lista[koko] = lisattava;
        koko++;
        tarkistaKoko();

    }

    public Solmu get(int indeksi) {
        return lista[indeksi];  
    }

    /**
     * Tarkistaa, riittääkö listan koko vielä uuden solmun lisäämiseksi
     */
    private void tarkistaKoko() {
        if (koko == lista.length) {
            kasvataListaa();
        }
    }

    /**
     * Listaa kasvatettaessa siitä tehdään kaksi kertaa nykyisen kokoinen
     */
    private void kasvataListaa() {
        teeUusiLista(lista.length * 2);
    }

    /**
     * Metodi tekee uuden listan annetun koon mukaan ja kopioi vanhan listan
     * sisällön siihen
     *
     * @param listanKoko uuden listan haluttu koko
     */
    private void teeUusiLista(int listanKoko) {
        Solmu[] uusi = new Solmu[listanKoko];
        for (int i = 0; i < lista.length; i++) {
            uusi[i] = lista[i];
        }
        this.lista = uusi;
    }

}
