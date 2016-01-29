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
public class Peli {

    private Ruudukko ruudukko;
    private Merkki vuorossa;

    public Peli() {
        this.ruudukko = new Ruudukko();
        this.vuorossa = Merkki.RISTI;
    }

    public void teeSiirto(int rivi, int sarake) {
        if (vuorossa.equals(Merkki.RISTI)) {
            this.ruudukko.setMerkki(rivi, sarake, Merkki.RISTI);
        } else if (vuorossa.equals(Merkki.NOLLA)) {
            this.ruudukko.setMerkki(rivi, sarake, Merkki.NOLLA);
        }

    }
}
