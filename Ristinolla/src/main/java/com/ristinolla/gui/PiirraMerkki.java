/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import com.ristinolla.domain.PelinTila;
import com.ristinolla.logiikka.Ruudukko;
import com.ristinolla.logiikka.Ruutu;
import java.awt.Component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Luokka käsittelee hiiren klikkauksen.
 * @author Sofia
 */
public class PiirraMerkki implements MouseListener {

    private Ruutu ruutu;
    private XOAlusta alusta;
    private Ruudukko ruudukko;
    private Merkki vuorossa;
    private PelinTila tila;
    private Component component;

    /**
     * Konstruktori saa paramentreina pelialustan ja ruudukon.
     * @param alusta Alusta, jonka tapahtumia kuunnellaan
     * @param ruudukko Ruudukko, jonka tilaa päivitetään
     */
    public PiirraMerkki(XOAlusta alusta, Ruudukko ruudukko) {
//        this.alusta = alusta;
        this.ruudukko = ruudukko;
//        this.tila = tila;
        this.component = alusta;
        this.vuorossa = alusta.getVuorossa();

    }

    /**
     * Kun hiirtä klikataan, metodi asettaa valitun ruudun tilan ristiksi tai
     * nollaksi ja päivittää pelin tilan, eli tarkistaa, onko ruudukko täynnä ja
     * kumpi merkki voitti vai päättyikö peli tasapeliin.
     *
     * @param me hiiren toiminta
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        

        int rivi = y / XOAlusta.RUUDUN_SIVU;
        int sarake = x / XOAlusta.RUUDUN_SIVU;
        
        Koordinaatit k = new Koordinaatit(sarake, rivi);
        
        if (this.ruudukko.getRuutu(k).onTyhja()) {
            this.ruudukko.setMerkki(k, this.vuorossa);
            paivita(this.vuorossa, k);

            if (this.vuorossa == Merkki.RISTI) {
                this.vuorossa = Merkki.NOLLA;
            } else {
                this.vuorossa = Merkki.RISTI;
            }
        }
        this.component.repaint();

    }
    /**
     * Muuttaa pelin tilan, jos edellinen siirto oli voittosiirto, tai jos peli
     * alusta on täynnä.
     * @param vuorossa RISTI tai NOLLA
     * @param k koordinaatit, johon edellinen merkki asetettiin
     */

    public void paivita(Merkki vuorossa, Koordinaatit k) {
        if (this.ruudukko.voitto(this.vuorossa, k)) {
            if (this.vuorossa == Merkki.NOLLA) {
                this.tila = PelinTila.O_VOITTI;
            } else if (this.vuorossa == Merkki.RISTI) {
                this.tila = PelinTila.X_VOITTI;
            }
        } else if (this.ruudukko.onTaynna()) {
            this.tila = PelinTila.TASAPELI;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
