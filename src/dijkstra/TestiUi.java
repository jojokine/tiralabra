/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.util.Scanner;

/**
 *
 * @author osku
 */
public class TestiUi {

    private static int[][] testiVerkko;
    private static int[][] verkko;
    private static Scanner lukija = new Scanner(System.in);
    private static int solmuja;
    private static int lahto;
    private static int kohde;
    // private static Graphics kuva = new Graphics();

    public static void main(String[] args) {
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
