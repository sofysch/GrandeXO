/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logic;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;

/**
 * Luokka muodostaa ruuduista ruudukon, jota pääsee eri metodien avulla
 * käsittelemään.
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

        this.ruudukko = new Ruutu[this.riveja][this.sarakkeita];
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                this.ruudukko[rivi][sarake] = new Ruutu(rivi, sarake);
            }
        }

    }

    /**
     * Metodi tarjoaa mahdollisuuden asettaa tietylle ruudulle tilan RISTI 
     * tai NOLLA, jos sen tila on TYHJA. 
     * 
     * @param koordinaatit Ruudun sijainti ruudukossa
     * @param merkki Mikä merkki ruutuun asetetaan
     */
    public void setMerkki(Koordinaatit koordinaatit, Merkki merkki) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        if (merkki != Merkki.TYHJA) {
            this.ruudukko[rivi][sarake].asetaMerkki(merkki);

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

    /**
     * Metodilla saa tiedon onko kaikkien ruutujen tila TYHJA.
     *
     * @return true, jos on, muutoin false.
     */
    public boolean onTyhja() {
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                if (!this.ruudukko[rivi][sarake].onTyhja()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metodilla saa tietoonsa yksittäisen ruudun tilan, siis RISTI, NOLLA tai
     * TYHJA.
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
            if (tarkistaSarake(rivi, merkki)
                    || tarkistaRivi(sarake, merkki)
                    || tarkistaEkaVinorivi(merkki)
                    || tarkistaTokaVinorivi(merkki)) {
                return true;
            }
        }
        return false;
    }

    private boolean tarkistaTokaVinorivi(Merkki merkki) {
        return this.ruudukko[2][0].getTila() == merkki
                && this.ruudukko[1][1].getTila() == merkki
                && this.ruudukko[0][2].getTila() == merkki;
    }

    private boolean tarkistaEkaVinorivi(Merkki merkki) {
        return this.ruudukko[0][0].getTila() == merkki
                && this.ruudukko[1][1].getTila() == merkki
                && this.ruudukko[2][2].getTila() == merkki;
    }

    private boolean tarkistaRivi(int sarake, Merkki merkki) {
        return this.ruudukko[0][sarake].getTila() == merkki
                && this.ruudukko[1][sarake].getTila() == merkki
                && this.ruudukko[2][sarake].getTila() == merkki;
    }

    private boolean tarkistaSarake(int rivi, Merkki merkki) {
        return this.ruudukko[rivi][0].getTila() == merkki
                && this.ruudukko[rivi][1].getTila() == merkki
                && this.ruudukko[rivi][2].getTila() == merkki;
    }

    /**
     * Palauttaa tiedon siitä, onko ruudukko täynnä, eli onko kaikkien ruutujen
     * tila RISTI tai NOLLA.
     *
     * @return true, jos minkään ruudun tila ei ole TYHJA, muutoin false.
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

    public int getSarakkeet() {
        return this.sarakkeita;
    }

    /**
     * Palauttaa yksittäisen ruudukon ruudun.
     *
     * @param koordinaatit Halutun ruudun koordinaatit
     * @return Ruutu
     */
    public Ruutu haeRuutu(Koordinaatit koordinaatit) {

        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        return this.ruudukko[rivi][sarake];

    }
}
