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

    public void setMerkki(int rivi, int sarake, Merkki merkki) {
        if (merkki != Merkki.TYHJA){
            this.ruudukko[rivi][sarake].setMerkki(merkki);
        }
    }
    public void tyhjenna(){
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                this.ruudukko[rivi][sarake].tyhjenna();
            }
        }
    }

    public Merkki ruudunTila(int rivi, int sarake) {
        return this.ruudukko[rivi][sarake].getTila();
    }

    public boolean voitto(Merkki merkki, int rivi, int sarake) {
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
    public boolean onTaynna(){
        for (int rivi = 0; rivi < this.riveja; rivi++) {
            for (int sarake = 0; sarake < this.sarakkeita; sarake++) {
                if (this.ruudukko[rivi][sarake].getTila()==(Merkki.TYHJA)){
                    return false;
                }
            }
    }
        return true;
    }
    public int getRivit(){
            return this.riveja;
        }
    public int getSarakkeita(){
        return this.sarakkeita;
    }
    public Ruutu getRuutu(int rivi, int sarake){
        return this.ruudukko[rivi][sarake];
    }
    
}
