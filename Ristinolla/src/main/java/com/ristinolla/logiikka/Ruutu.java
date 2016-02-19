/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import com.ristinolla.gui.XOAlusta;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * Luokka tarjoaa metodeja yksittÃƒÂ¤isen ruudun tietoihin ja sen
 * piirtÃƒÂ¤miseen ja muokkaamiseen. Oletustila on TYHJA.
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
     * Tarkistaa, onko ruudun tila tyhjÃƒÂ¤.
     *
     * @return true, jos tyhjä, muuten false
     */
    public boolean onTyhja() {
        return getTila() == (Merkki.TYHJA);
    }

    public Merkki getTila() {
        return this.tila;
    }

    /**
     * Asettaa ruudun tilaksi nollan tai ristin, jos sen tila on TYHJA.
     *
     * @param merkki RISTI tai NOLLA.
     */
    public void setMerkki(Merkki merkki) {
        if (onTyhja()) {
            if (merkki == (Merkki.RISTI)) {
                this.tila = Merkki.RISTI;
            } else if (merkki == (Merkki.NOLLA)) {
                this.tila = Merkki.NOLLA;
            }
        }else{
            this.tila = this.getTila();
        }
        
    }

    /**
     * Asettaa ruutuun ristin tai nollan kuvan.
     * @param g Graphics
     */
    public void piirra(Graphics g) {

        BufferedImage nolla = null;
        BufferedImage risti = null;

        try {
            nolla = ImageIO.read(new File("NOLLA.png"));
            risti = ImageIO.read(new File("RISTI.png"));
        } catch (IOException ex) {
            System.exit(1);
        }

        if (this.tila == Merkki.NOLLA) {
            g.drawImage(nolla, this.getX() * XOAlusta.RUUDUN_SIVU + 10, this.getY() * XOAlusta.RUUDUN_SIVU + 10, null);

        } else if (this.tila == Merkki.RISTI){
            g.drawImage(risti, this.getX() * XOAlusta.RUUDUN_SIVU + 10, this.getY() * XOAlusta.RUUDUN_SIVU + 10, null);

        }

    }

}
