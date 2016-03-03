/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;

/**
 * Luokka tarjoaa metodeja yksittäisen ruudun tietoihin ja sen piirtämiseen ja
 * muokkaamiseen. Oletustila on TYHJA.
 *
 * @author Sofia
 */
public class Ruutu {

    private Merkki tila;
    private Koordinaatit sijainti;

    /**
     * Alustaa ruudun sijainnin ja tilan.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Ruutu(int x, int y) {
        this.sijainti = new Koordinaatit(x, y);
        this.tila = Merkki.TYHJA;

    }

    /**
     * Asettaa ruudun tilaksi TYHJA.
     */
    public void tyhjenna() {
        this.tila = Merkki.TYHJA;
    }

    public int haeX() {
        return this.sijainti.haeX();
    }

    public int haeY() {
        return this.sijainti.haeY();
    }

    /**
     * Tarkistaa, onko ruudun tila TYHJA.
     *
     * @return true, jos tyhjä, muuten false
     */
    public boolean onTyhja() {
        return haeTila() == (Merkki.TYHJA);
    }

    public Merkki haeTila() {
        return this.tila;
    }

    /**
     * Asettaa ruudun tilaksi nollan tai ristin, jos sen tila on TYHJA.
     *
     * @param merkki RISTI tai NOLLA.
     */
    public void asetaMerkki(Merkki merkki) {
        if (onTyhja()) {
            if (merkki == (Merkki.RISTI)) {
                this.tila = Merkki.RISTI;
            } else if (merkki == (Merkki.NOLLA)) {
                this.tila = Merkki.NOLLA;
            }
        } else {
            this.tila = this.haeTila();
        }

    }

}
