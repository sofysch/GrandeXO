/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofia
 */
public class Ruudukko {

    private int riveja;
    private int sarakkeita;
    private Ruutu[][] ruudukko;
    

//    Luodaan ruudukko, joka koostuu Ruutu -luokan olioista.
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

    public void setMerkki(Koordinaatit koordinaatit, Merkki merkki) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        if (merkki != Merkki.TYHJA) {
            this.ruudukko[rivi][sarake].setMerkki(merkki);

        }
    }

    public boolean tyhjenna() {
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                this.ruudukko[rivi][sarake].tyhjenna();
                if (this.ruudukko[rivi][sarake].getTila() != (Merkki.TYHJA)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Merkki ruudunTila(Koordinaatit koordinaatit) {
        int rivi = koordinaatit.getX();
        int sarake = koordinaatit.getY();
        return this.ruudukko[rivi][sarake].getTila();
    }

    public boolean voitto(Merkki merkki, Koordinaatit koordinaatit) {
        int rivi= koordinaatit.getX();
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

    public Ruutu getRuutu(Koordinaatit koordinaatit) {
        int rivi= koordinaatit.getX();
        int sarake = koordinaatit.getY();
        return this.ruudukko[rivi][sarake];
    }

}
