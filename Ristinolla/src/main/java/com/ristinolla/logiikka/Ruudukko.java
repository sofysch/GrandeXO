/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;

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
        int rivi = koordinaatit.haeX();
        int sarake = koordinaatit.haeY();
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
     * @return true, jos on
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
     * Metodilla saa tietoonsa yksittäisen ruudun tilan, eli onko siinä risti,
     * nolla, vai onko se tyhjä.
     *
     * @param koordinaatit Halutun ruudun koordinaatit
     *
     * @return ruudun tila, TYHJA, RISTI tai NOLLA.
     */
    public Merkki ruudunTila(Koordinaatit koordinaatit) {
        int rivi = koordinaatit.haeX();
        int sarake = koordinaatit.haeY();
        return this.ruudukko[rivi][sarake].haeTila();
    }

    /**
     * Tarkistaa onko annetun ruudun kohdalle muodostunut voittorivi.
     *
     * @param merkki RISTI tai NOLLA
     * @param koordinaatit Tarkistettavan ruudun koordinaatit
     * @return true, jos voittorivi on muodostunut, false, jos ei.
     */
    public boolean voitto(Merkki merkki, Koordinaatit koordinaatit) {
        int rivi = koordinaatit.haeX();
        int sarake = koordinaatit.haeY();
        if (merkki != Merkki.TYHJA) {
            if (this.ruudukko[rivi][0].haeTila() == merkki
                    && this.ruudukko[rivi][1].haeTila() == merkki
                    && this.ruudukko[rivi][2].haeTila() == merkki // tarkistaa sarakkeen
                    || this.ruudukko[0][sarake].haeTila() == merkki
                    && this.ruudukko[1][sarake].haeTila() == merkki
                    && this.ruudukko[2][sarake].haeTila() == merkki // tarkistaa rivin
                    || this.ruudukko[0][0].haeTila() == merkki
                    && this.ruudukko[1][1].haeTila() == merkki // tarkistaa vinorivin
                    && this.ruudukko[2][2].haeTila() == merkki
                    || this.ruudukko[2][0].haeTila() == merkki
                    && this.ruudukko[1][1].haeTila() == merkki
                    && this.ruudukko[0][2].haeTila() == merkki) {    // tarkistaa toisen vinorivin
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
                if (this.ruudukko[rivi][sarake].haeTila() == (Merkki.TYHJA)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int haeRivit() {
        return this.riveja;
    }

    public int haeSarakkeet() {
        return this.sarakkeita;
    }

    /**
     * Palauttaa yksittäisen ruudukon ruudun.
     *
     * @param koordinaatit Halutun ruudun koordinaatit
     * @return ruutu
     */
    public Ruutu haeRuutu(Koordinaatit koordinaatit) {

        int rivi = koordinaatit.haeX();
        int sarake = koordinaatit.haeY();
        return this.ruudukko[rivi][sarake];

    }
}
