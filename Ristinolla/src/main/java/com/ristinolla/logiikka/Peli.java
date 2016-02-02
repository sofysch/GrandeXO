/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

/**
 *
 * @author Sofia
 */
import java.util.Scanner;

public class Peli {

    private Ruudukko ruudukko;
    private Merkki vuorossa;
    private Scanner lukija;

    public Peli() {
        this.ruudukko = new Ruudukko();
        this.vuorossa = Merkki.RISTI;
        lukija = new Scanner(System.in);
    }

    public void init() {
        this.ruudukko.tyhjenna();

    }

    public void pelaa() {
        while (true) {
            if (this.vuorossa == Merkki.RISTI) {
                System.out.println("X tee siirto");
            } else {
                System.out.println("O tee siirto");
            }
            int rivi = Integer.parseInt(lukija.nextLine());
            int sarake = Integer.parseInt(lukija.nextLine());

            if (this.vuorossa == (Merkki.RISTI)) {
                this.ruudukko.setMerkki(rivi, sarake, Merkki.RISTI);
                this.vuorossa = (Merkki.NOLLA);
            } else {
                this.ruudukko.setMerkki(rivi, sarake, Merkki.NOLLA);
                this.vuorossa = Merkki.RISTI;
            }
            if (this.ruudukko.voitto(vuorossa, rivi, sarake)
                    || this.ruudukko.onTaynna()) {
                break;

            }
        }
    }

    public void teeSiirto(int rivi, int sarake) {
        if (this.vuorossa == (Merkki.RISTI)) {
            this.ruudukko.setMerkki(rivi, sarake, Merkki.RISTI);
        } else if (this.vuorossa == (Merkki.NOLLA)) {
            this.ruudukko.setMerkki(rivi, sarake, Merkki.NOLLA);
        }

    }
}
