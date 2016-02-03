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

    public Peli() {
        this.ruudukko = new Ruudukko();
        this.vuorossa = Merkki.RISTI;
        lukija = new Scanner(System.in);
    }

    public void init() {
        this.ruudukko.tyhjenna();
        pelaa();
    }

    public void pelaa() {
        while (true) {
            if (this.vuorossa == Merkki.RISTI) {
                System.out.println("X tee siirto, anna koordinaatit: ");
            } else {
                System.out.println("O tee siirto, anna koordinaatit: ");
            }
            int rivi = Integer.parseInt(lukija.nextLine());
            int sarake = Integer.parseInt(lukija.nextLine());
            Koordinaatit koordinaatit = new Koordinaatit(rivi, sarake);

            if (tarkistaKoordinaatit(koordinaatit)) {
                teeSiirto(koordinaatit);
                if (tarkistaVoitto(this.vuorossa,koordinaatit)) {
                    System.out.println(this.vuorossa + " voitti, onnea!");
                    break;
                } else if (this.ruudukko.onTaynna()) {
                    System.out.println("Tasapeli");
                    break;
                }
                if (this.vuorossa == Merkki.RISTI) {
                    this.vuorossa = (Merkki.NOLLA);
                } else {
                    this.vuorossa = Merkki.RISTI;
                }
            } else {
                System.out.println("Koordinaatit eivät kelpaa.");
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
        int rivi= koordinaatit.getX();
        int sarake = koordinaatit.getY();
        return (rivi >= 0) && (rivi < 3) && (sarake >= 0) && (sarake < 3);
    }
    public Merkki getVuorossa(){
        return this.vuorossa;
    }

}
