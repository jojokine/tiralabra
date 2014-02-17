/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author jojokine@cs
 */
public class Ui {

    private static int[][] verkko;
    private static Scanner lukija = new Scanner(System.in);
    private static int solmuja;
    private static int lahto;
    private static int kohde;

    public static void main(String[] args) {
        System.out.println("Montako solmua?");
        solmuja = lukija.nextInt();
        verkko = new int[solmuja][solmuja];
        for (int i = 0; i < solmuja; i++) {
            for (int j = 0; j < solmuja; j++) {
                if (i != j && i < j) {
                    System.out.println("Anna solmujen " + i + " ja " + j + " välinen etäisyys (0 = ei yhteyttä)");
                    verkko[i][j] = verkko[j][i] = lukija.nextInt();
                }
            }
        }
        System.out.println("Anna lähtösolmun numero (ensimmäinen solmu on solmu 0)");
        lahto = lukija.nextInt();
        System.out.println("Anna maalisolmun numero (viimeinen solmu on solmujen lkm -1)");
        kohde = lukija.nextInt();

        Dijkstra dijkstra = new Dijkstra();
        System.out.println("Reitin pituus on: " + dijkstra.ratkaise(verkko, solmuja, lahto, kohde));
    }

}
