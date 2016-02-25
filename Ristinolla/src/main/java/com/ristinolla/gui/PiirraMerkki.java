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
 *
 * @author Sofia
 */
public class PiirraMerkki implements MouseListener {

    private XOAlusta alusta;
    private Ruudukko ruudukko;
    private Merkki vuorossa;

    /**
     * Konstruktori saa paramentreina pelialustan ja ruudukon.
     *
     * @param alusta Alusta, jonka tapahtumia kuunnellaan
     * @param ruudukko Ruudukko, jonka tilaa päivitetään
     */
    public PiirraMerkki(XOAlusta alusta, Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.alusta = alusta;
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
        if (this.ruudukko.onTyhja()) {
            alusta.setTila(PelinTila.PELAA);
            this.vuorossa = Merkki.RISTI;
        }

        int x = me.getX();
        int y = me.getY();

        int rivi = y / XOAlusta.RUUDUN_SIVU;
        int sarake = x / XOAlusta.RUUDUN_SIVU;
        Koordinaatit k = new Koordinaatit(sarake, rivi);

        if (alusta.getTila() == PelinTila.PELAA) {

            if (this.ruudukko.getRuutu(k).onTyhja()) {
                this.ruudukko.setMerkki(k, this.vuorossa);

                paivitaTila(this.vuorossa, k);

                this.vuorossa = (this.vuorossa == Merkki.RISTI) ? Merkki.NOLLA : Merkki.RISTI;
                this.alusta.paivitaViesti(alusta.getTila(), this.vuorossa);
            }
        }

        this.alusta.repaint();
    }

    /**
     * Muuttaa pelin tilan, jos edellinen siirto oli voittosiirto, tai jos peli
     * alusta on täynnä.
     *
     * @param vuorossa RISTI tai NOLLA
     * @param k koordinaatit, johon edellinen merkki asetettiin
     */
    public void paivitaTila(Merkki vuorossa, Koordinaatit k) {
        vuorossa = this.vuorossa;
        if (this.ruudukko.voitto(vuorossa, k)) {
            if (vuorossa == Merkki.NOLLA) {
                alusta.setTila(PelinTila.O_VOITTI);
            } else if (vuorossa == Merkki.RISTI) {
                alusta.setTila(PelinTila.X_VOITTI);
            }
        } else if (this.ruudukko.onTaynna()) {
            alusta.setTila(PelinTila.TASAPELI);
        } else {
            alusta.setTila(PelinTila.PELAA);
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
