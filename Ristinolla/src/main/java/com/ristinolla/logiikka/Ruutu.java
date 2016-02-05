/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Sofia
 */
public class Ruutu {

    private Merkki tila;
    private Koordinaatit sijainti;

    public Ruutu(int x, int y) {
        this.sijainti = new Koordinaatit(x, y);
        this.tila = Merkki.TYHJA;
    }

    public void tyhjenna() {
        this.tila = Merkki.TYHJA;
    }

    public String getSijainti() {
        return this.sijainti.getX() + ", " + this.sijainti.getY();
    }

    public boolean onTyhja() {
        if (getTila() == (Merkki.TYHJA)) {
            return true;
        }
        return false;
    }

    public Merkki getTila() {
        return this.tila;
    }

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

    public void piirra(Graphics g) {

    }

}
