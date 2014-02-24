package dijkstra;

import java.util.Scanner;

/**
 *
 * @author jojokine@cs
 */
public class Ui {

    private static int[][] verkko;
    private static Scanner scanner = new Scanner(System.in);
    private static int solmuja;
    private static int lahto;
    private static int kohde;

    /**
     * Pyytää syötettä annetulla pyynnöllä, tarkistaa että syöte on numeroarvo ja palauttaa sen.
     * Virheellisen syötteen tapauksessa syötettä pyydetään uudestaan.
     * @param pyynto Syötepyyntö, joka tulostetaan käyttäjälle
     * @return 
     */
    private static int lukija(String pyynto) {
        int arvo = 0;
        while (true) {
            try {
                System.out.println(pyynto);
                arvo = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println('"' + scanner.nextLine() + '"' + " ei ole kelvollinen syöte! Syötä numeroarvo!");
            }
        }
        return arvo;
    }

    /**
     * kerää käyttäjältä vierusmatsiisiesityksen verkosta sekä lähtö- ja kohdesolmut, 
     * kutsuu saaduilla tiedoilla reitinlaskijaa.
     */
    public static void ui() {
        solmuja = lukija("Montako solmua?");
        verkko = new int[solmuja][solmuja];
        for (int i = 0;
                i < solmuja;
                i++) {
            for (int j = 0; j < solmuja; j++) {
                if (i != j && i < j) {
                    verkko[i][j] = verkko[j][i] = lukija("Anna solmujen " + i + " ja " + j + " välinen etäisyys (0 = ei yhteyttä)");
                }
            }
        }
        lahto = lukija("Anna lähtösolmun numero (ensimmäinen solmu on solmu 0)");
        kohde = lukija("Anna maalisolmun numero (viimeinen solmu on solmujen lkm -1)");
        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Reitin pituus on: " + dijkstra.ratkaise(verkko, solmuja, lahto, kohde));
    }
}
