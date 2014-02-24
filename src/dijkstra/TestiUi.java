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
    private static int[][] testiVerkko2;


    public static void main(String[] args) {
        testi2();
  
    }
       public static void testi2() { 
        testiVerkko2 = new int[6][6];
        testiVerkko2[1][2] = testiVerkko2[2][1] = testiVerkko2[2][3] = testiVerkko2[3][2] = testiVerkko2[3][4] = testiVerkko2[4][3] = testiVerkko2[4][5] = testiVerkko2[5][4] = 1;
        testiVerkko2[1][3] = testiVerkko2[3][1] = 3;
        testiVerkko2[0][2] = testiVerkko2[2][0] = 4;
        testiVerkko2[2][4] = testiVerkko2[4][2] = 5;
        testiVerkko2[3][5] = testiVerkko2[5][3] = 8;

        Dijkstra dijkstra2 = new Dijkstra();

        System.out.println("Reitin pituus on: " + dijkstra2.ratkaise(testiVerkko2, 6, 0, 4));

    }
    public static void testi1() {
        testiVerkko = new int[5][5];
        testiVerkko[0][1] = testiVerkko[1][0] = 5;
        testiVerkko[1][2] = testiVerkko[2][1] = 1;
        testiVerkko[2][3] = testiVerkko[3][2] = 2;
        testiVerkko[3][0] = testiVerkko[0][3] = 1;
        testiVerkko[1][4] = testiVerkko[4][1] = 2;

        Dijkstra dijkstra = new Dijkstra();

        System.out.println("Reitin pituus on: " + dijkstra.ratkaise(testiVerkko, 5, 0, 4));

    }

}
