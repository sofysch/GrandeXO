/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logic;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;

/**
 * Luokka tarjoaa metodeja yksittäisen ruudun tietoihin ja sen piirtämiseen ja
 * muokkaamiseen. Ruudun oletustila on TYHJA.
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

    public int getX() {
        return this.sijainti.getX();
    }

    public int getY() {
        return this.sijainti.getY();
    }

    /**
     * Tarkistaa, onko ruudun tila TYHJA.
     *
     * @return true, jos tila on TYHJA, muuten false
     */
    public boolean onTyhja() {
        return getTila() == (Merkki.TYHJA);
    }

    public Merkki getTila() {
        return this.tila;
    }

    /**
     * Asettaa ruudun tilaksi NOLLA tai RISTI, jos sen tila on TYHJA.
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
            this.tila = this.getTila();
        }

    }

}
