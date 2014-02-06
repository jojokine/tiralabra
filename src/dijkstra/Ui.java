/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.Scanner;

/**
 *
 * @author jojokine@cs
 */
public class Ui {

    private static int[][] testiVerkko;
    private static int[][] verkko;
    private static Scanner lukija = new Scanner(System.in);
    private static int solmuja;
    private static int lahto;
    private static int kohde;

    public static void main(String[] args) {
//        System.out.println("Montako solmua?");
//        solmuja = lukija.nextInt();
//        verkko = new int[solmuja][solmuja];
//        for (int i = 0; i < solmuja; i++) {
//            for (int j = 0; j < solmuja; j++) {
//                if (i != j && i < j) {
//                    System.out.println("Anna solmujen " + i + " ja " + j + " välinen etäisyys (0 = ei yhteyttä)");
//                    verkko[i][j] = verkko[j][i] = lukija.nextInt();
//                }
//            }
//        }
//        System.out.println("Anna lähtösolmun numero (ensimmäinen solmu on solmu 0)");
//        lahto = lukija.nextInt();
//        System.out.println("Anna maalisolmun numero (viimeinen solmu on solmujen lkm -1)");
//        kohde = lukija.nextInt();
//
//        Dijkstra dijkstra = new Dijkstra();
//        System.out.println("Reitin pituus on: " + dijkstra.ratkaise(verkko, solmuja, lahto, kohde));

        testiVerkko = new int[6][6];
        testiVerkko[1][2] = testiVerkko[2][1] = testiVerkko[2][3] = testiVerkko[3][2] = testiVerkko[3][4] = testiVerkko[4][3] = testiVerkko[4][5] = testiVerkko[5][4] = 1;
        testiVerkko[1][3] = testiVerkko[3][1] = 3;
        testiVerkko[0][2] = testiVerkko[2][0] = 4;
        testiVerkko[2][4] = testiVerkko[4][2] = 5;
        testiVerkko[3][5] = testiVerkko[5][3] = 8;

        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Reitin pituus on: " + dijkstra.ratkaise(testiVerkko, 6, 0, 3));
    }
}
