/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.ui;

/**
 * Ristinolla -pelin tekstikäyttöliittymä.
 *
 * @author Sofia
 */
import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import com.ristinolla.logiikka.Ruudukko;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Peli {

    private Ruudukko ruudukko;
    private Merkki vuorossa;
    private Scanner lukija;
    private int voitotRisti;
    private int voitotNolla;

    /**
     * Alustetaan ruudukko, vuorossa oleva merkki ja voittojen määrä.
     */
    public Peli() {
        this.ruudukko = new Ruudukko();
        this.vuorossa = Merkki.RISTI;
        lukija = new Scanner(System.in);
        this.voitotNolla = 0;
        this.voitotRisti = 0;

    }

    /**
     * Tyhjentää ruudukon ja aloittaa uuden pelin.
     */

    public void init() {
        this.ruudukko.tyhjenna();
        pelaa();
        tulostaVoitot();

    }
    /**
     * Pelaa peliä.
     */
    
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
                    lisaaVoitto(this.vuorossa);
                    System.out.println(this.vuorossa + " voitti, onnea!");

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
    /**
     * Asettaa haluttuun ruutuun ristin tai nollan.
     * @param koordinaatit Ruudun koordinaatit
     *
     */

    public void teeSiirto(Koordinaatit koordinaatit) {

        if (this.vuorossa == (Merkki.RISTI)) {
            this.ruudukko.setMerkki(koordinaatit, Merkki.RISTI);

        } else if (this.vuorossa == (Merkki.NOLLA)) {
            this.ruudukko.setMerkki(koordinaatit, Merkki.NOLLA);

        }

    }
    /**
     * Tarkistaa onko peli voitettu.
     * @param merkki Mikä merkki on vuorossa
     * @param koordinaatit Missä ruudussa viimeisin siirto on
     * @return True, jos voittorivi on muodostunut, muutoin false
     */

    public boolean tarkistaVoitto(Merkki merkki, Koordinaatit koordinaatit) {
        return this.ruudukko.voitto(getVuorossa(), koordinaatit);
    }
    /**
     * Tarkistaa annettujen koordinaattien kelpoisuuden.
     * @param koordinaatit Annetut koordinaatit
     * @return true, jos koordinaatit ovat ruudukon sisällä, muutoin false
     */

    public boolean tarkistaKoordinaatit(Koordinaatit koordinaatit) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        return (rivi >= 0) && (rivi < 3) && (sarake >= 0) && (sarake < 3)
                && (ruudukko.getRuutu(koordinaatit).onTyhja());
    }

    public Merkki getVuorossa() {
        return this.vuorossa;
    }
    /**
     * Pitää kirjaa voitoista.
     * @param voittaja Merkki, jolle voitto lisätään
     */

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
    /**
     * Tulostaa merkkien voittojen määrän.
     * @return string
     */

    public String tulostaVoitot() {
        return "Risti on voittanut " + getRistinVoitot() + " peliä. "
                + "Nolla on voittanut " + getNollanVoitot() + " peliä.";
    }

}
