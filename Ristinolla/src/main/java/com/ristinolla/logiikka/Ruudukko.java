/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import com.ristinolla.gui.XOAlusta;
import java.awt.*;

/**
 * Luokka muodostaa ruuduista ruudukon, jota pääsee eri metodien avulla
 * käsittelemään ja piirtämään.
 *
 * @author Sofia
 */
public class Ruudukko {

    private int riveja;
    private int sarakkeita;
    private Ruutu[][] ruudukko;
    public int leveys;
    public int korkeus;

    /**
     * Alustetaan 3x3 -kokoinen ruudukko, joka koostuu Ruutu-olioista.
     */
    public Ruudukko() {
        this.riveja = 3;
        this.sarakkeita = 3;
//        this.korkeus = XOAlusta.RUUDUN_SIVU;
//        this.leveys = XOAlusta.RUUDUN_SIVU;

        this.ruudukko = new Ruutu[this.riveja][this.sarakkeita];
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                this.ruudukko[rivi][sarake] = new Ruutu(rivi, sarake);
            }
        }

    }

    /**
     * Metodi tarjoaa mahdollisuuden asettaa tietylle ruudulle tilan, jos se on
     * tyhjä. Sille voi siis asettaa tilaksi ristin tai nollan.
     *
     * @param koordinaatit Ruudun sijainti ruudukossa
     * @param merkki Mikä merkki ruutuun asetetaan
     */
    public void setMerkki(Koordinaatit koordinaatit, Merkki merkki) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        if (merkki != Merkki.TYHJA) {
            this.ruudukko[rivi][sarake].setMerkki(merkki);

        }
    }

    /**
     * Metodilla voi tyhjentää koko ruudukon. Kaikkien ruutujen tilaksi tulee
     * TYHJA.
     */
    public void tyhjenna() {
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                this.ruudukko[rivi][sarake].tyhjenna();
            }
        }
    }
    
    public boolean onTyhja(){
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                 if(!this.ruudukko[rivi][sarake].onTyhja()){
                     return false;
                 }
            }
        }
        return true;
    }

    /**
     * Metodilla saa tietoonsa yksittäisen ruudun tilan, eli onko siinä risti,
     * nolla, vai onko se tyhjä.
     *
     * @param koordinaatit Halutun ruudun koordinaatit
     *
     * @return ruudun tila, TYHJA, RISTI tai NOLLA.
     */
    public Merkki ruudunTila(Koordinaatit koordinaatit) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        return this.ruudukko[rivi][sarake].getTila();
    }

    /**
     * Tarkistaa onko annetun ruudun kohdalle muodostunut voittorivi.
     *
     * @param merkki RISTI tai NOLLA
     * @param koordinaatit Tarkistettavan ruudun koordinaatit
     * @return true, jos voittorivi on muodostunut, false, jos ei.
     */
    public boolean voitto(Merkki merkki, Koordinaatit koordinaatit) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        if (merkki != Merkki.TYHJA) {
            if (this.ruudukko[rivi][0].getTila() == merkki
                    && this.ruudukko[rivi][1].getTila() == merkki
                    && this.ruudukko[rivi][2].getTila() == merkki // tarkistaa sarakkeen
                    || this.ruudukko[0][sarake].getTila() == merkki
                    && this.ruudukko[1][sarake].getTila() == merkki
                    && this.ruudukko[2][sarake].getTila() == merkki // tarkistaa rivin
                    || this.ruudukko[0][0].getTila() == merkki
                    && this.ruudukko[1][1].getTila() == merkki // tarkistaa vinorivin
                    && this.ruudukko[2][2].getTila() == merkki
                    || this.ruudukko[2][0].getTila() == merkki
                    && this.ruudukko[1][1].getTila() == merkki
                    && this.ruudukko[0][2].getTila() == merkki) {    // tarkistaa toisen vinorivin
                return true;
            }
        }
        return false;
    }

    /**
     * Palauttaa tiedon siitä, onko ruudukko täynnä, siis onko kaikkien ruutujen
     * tila TYHJA.
     *
     * @return true, jos minkään ruudun tila ei ole tyhjä, muutoin false.
     */
    public boolean onTaynna() {
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                if (this.ruudukko[rivi][sarake].getTila() == (Merkki.TYHJA)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getRivit() {
        return this.riveja;
    }

    public int getSarakkeita() {
        return this.sarakkeita;
    }

    /**
     * Palauttaa yksittäisen ruudukon ruudun.
     *
     * @param koordinaatit Halutun ruudun koordinaatit
     * @return ruutu
     */
    public Ruutu getRuutu(Koordinaatit koordinaatit) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        return this.ruudukko[rivi][sarake];
    }

//    /**
//     * Piirtää ruudukon.
//     *
//     * @param g Graphics
//     */
//    public void piirra(Graphics g) {
//        g.setColor(Color.BLACK);
//
//        g.drawLine(5, this.korkeus, XOAlusta.LEVEYS - 5, this.korkeus);
//        g.drawLine(5, 2 * this.korkeus, XOAlusta.LEVEYS - 5, 2 * this.korkeus); //rivit
//
//        g.drawLine(this.leveys, 5, this.leveys, XOAlusta.KORKEUS - 5);
//        g.drawLine(this.leveys * 2, 5, this.leveys * 2, XOAlusta.KORKEUS - 5);
//
//    }

//    /**
//     * Piirtää jokaisen ruudukon ruudun.
//     *
//     * @param g Graphics
//     */
//    public void piirraRuudut(Graphics g) {
//        for (int rivi = 0; rivi < this.riveja; rivi++) {
//            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
//                this.ruudukko[rivi][sarake].piirra(g);
//            }
//        }
//    }
}
