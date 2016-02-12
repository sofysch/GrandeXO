/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 * Luokka tarjoaa metodeja yksittäisen ruudun tietoihin ja sen piirtämiseen ja
 * muokkaamiseen. Oletustila on TYHJA.
 *
 * @author Sofia
 */
public class Ruutu {

    private Merkki tila;
    private Koordinaatit sijainti;
    public static final int KOKO = 100; //Sivun pituus
    private BufferedImage nolla;

    public Ruutu(int x, int y) {
        this.sijainti = new Koordinaatit(x, y);
        this.tila = Merkki.TYHJA;

    }

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
     * Tarkistaa, onko ruudun tila tyhjä.
     * @return 
     */

    public boolean onTyhja() {
        return getTila() == (Merkki.TYHJA);
    }

    public Merkki getTila() {
        return this.tila;
    }
    /**
     * Asettaa ruutuun nollan tai ristin, jos se on tyhjä.
     * @param merkki RISTI tai NOLLA.
     */

    public void setMerkki(Merkki merkki) {
        if (onTyhja()) {
            if (merkki == (Merkki.RISTI)) {
                this.tila = Merkki.RISTI;
            } else if (merkki == (Merkki.NOLLA)) {
                this.tila = Merkki.NOLLA;
            }
        } else {
            System.out.println("Ruudussa on jo " + getTila());
        }
    }
    /**
     * Piirtää ristin tai nollan.
     * @param g
     * @param merkki RISTI tai NOLLA
     */

    public void piirra(Graphics g, Merkki merkki) {

        if (merkki == Merkki.NOLLA) {

        } else if (merkki == Merkki.RISTI) {

        }

    }

}
