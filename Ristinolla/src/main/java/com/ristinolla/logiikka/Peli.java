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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Peli {

    private Ruudukko ruudukko;
    private Merkki vuorossa;
    private Scanner lukija;
    private int voitotRisti;
    private int voitotNolla;

    public Peli() {
        this.ruudukko = new Ruudukko();
        this.vuorossa = Merkki.RISTI;
        lukija = new Scanner(System.in);
        this.voitotNolla = 0;
        this.voitotRisti = 0;

    }

    public void init() {
        this.ruudukko.tyhjenna();
        pelaa();

    }

    public void pelaa() {

        while (true) {
            if (this.vuorossa == Merkki.RISTI) {
                System.out.println("X vuorossa ");
            } else {
                System.out.println("O vuorossa ");
            }
            int rivi = Integer.parseInt(lukija.nextLine());
            int sarake = Integer.parseInt(lukija.nextLine());
            Koordinaatit koordinaatit = new Koordinaatit(rivi, sarake);

            if (tarkistaKoordinaatit(koordinaatit)) {
                teeSiirto(koordinaatit);
                if (tarkistaVoitto(this.vuorossa, koordinaatit)) {
                    System.out.println(this.vuorossa + " voitti, onnea!");
                    lisaaVoitto(this.vuorossa);
                    tulostaVoitot();
                    break;
                } else if (this.ruudukko.onTaynna()) {
                    System.out.println("Tasapeli");
                    tulostaVoitot();
                    break;
                }
                if (this.vuorossa == Merkki.RISTI) {
                    this.vuorossa = (Merkki.NOLLA);
                } else {
                    this.vuorossa = Merkki.RISTI;
                }
            } else {
                System.out.println("Tarkista koordinaatit.");
            }
        }

    }

    public void teeSiirto(Koordinaatit koordinaatit) {

        if (this.vuorossa == (Merkki.RISTI)) {
            this.ruudukko.setMerkki(koordinaatit, Merkki.RISTI);

        } else if (this.vuorossa == (Merkki.NOLLA)) {
            this.ruudukko.setMerkki(koordinaatit, Merkki.NOLLA);

        }

    }

    public boolean tarkistaVoitto(Merkki merkki, Koordinaatit koordinaatit) {
        return this.ruudukko.voitto(getVuorossa(), koordinaatit);
    }

    public boolean tarkistaKoordinaatit(Koordinaatit koordinaatit) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        if ((rivi >= 0) && (rivi < 3) && (sarake >= 0) && (sarake < 3)
                && (ruudukko.getRuutu(koordinaatit).onTyhja())) {
            return true;
        }
        return false;
    }

    public Merkki getVuorossa() {
        return this.vuorossa;
    }

    public void lisaaVoitto(Merkki voittaja) {
        if (voittaja == Merkki.RISTI) {
            this.voitotRisti++;
        } else {
            this.voitotNolla++;
        }
    }

    public int getRistinVoitot() {
        return this.voitotRisti;
    }

    public int getNollanVoitot() {
        return this.voitotNolla;
    }

    public String tulostaVoitot() {
        return "Risti on voittanut " + getRistinVoitot() + " peliä. "
                + "Nolla on voittanut " + getNollanVoitot() + " peliä.";
    }

}
