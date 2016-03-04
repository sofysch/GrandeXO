/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import com.ristinolla.domain.PelinTila;
import com.ristinolla.logic.Ruudukko;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Luokka käsittelee hiiren klikkauksen.
 *
 * @author Sofia
 */
public class MerkinPiirtaja implements MouseListener {

    private XOAlusta alusta;
    private Ruudukko ruudukko;
    private Merkki vuorossa;

    /**
     * Konstruktori saa paramentreina pelialustan ja ruudukon.
     *
     * @param alusta Alusta, jonka tapahtumia kuunnellaan.
     * @param ruudukko Ruudukko, jonka tilaa päivitetään.
     */
    public MerkinPiirtaja(XOAlusta alusta, Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.alusta = alusta;
        this.vuorossa = alusta.getVuorossa();
    }

    /**
     * Kun hiirtä klikataan, metodi asettaa valitun ruudun tilan ristiksi tai
     * nollaksi ja päivittää pelin tilan, eli tarkistaa, onko ruudukko täynnä ja
     * kumpi merkki voitti, vai päättyikö peli tasapeliin.
     *
     * @param me hiiren toiminta
     */
    @Override
    public void mouseClicked(MouseEvent me) {

        tarkistaOnkoUusiPeli();
        Koordinaatit koordinaatit = haeKoordinaatit(me);

        if (this.alusta.getPelinTila() == PelinTila.PELAA) {

            if (this.ruudukko.haeRuutu(koordinaatit).onTyhja()) {
                this.ruudukko.setMerkki(koordinaatit, this.vuorossa);

                paivitaPelinTila(this.vuorossa, koordinaatit);

                this.vuorossa = (this.vuorossa == Merkki.RISTI) ? Merkki.NOLLA : Merkki.RISTI;
                this.alusta.paivitaViesti(this.alusta.getPelinTila(), this.vuorossa);
            }
        }
        this.alusta.repaint();
    }

    /**
     * Muuttaa pelin tilan, jos edellinen siirto oli voittosiirto tai jos
     * pelialusta on täynnä.
     *
     * @param vuorossa RISTI tai NOLLA
     * @param k koordinaatit, johon edellinen merkki asetettiin
     */
    public void paivitaPelinTila(Merkki vuorossa, Koordinaatit k) {
        if (this.ruudukko.voitto(vuorossa, k)) {
            if (vuorossa == Merkki.NOLLA) {
                this.alusta.setPelinTila(PelinTila.O_VOITTI);
            } else if (vuorossa == Merkki.RISTI) {
                this.alusta.setPelinTila(PelinTila.X_VOITTI);
            }
        } else if (this.ruudukko.onTaynna()) {
            this.alusta.setPelinTila(PelinTila.TASAPELI);
        } else {
            this.alusta.setPelinTila(PelinTila.PELAA);
        }

    }

    private void tarkistaOnkoUusiPeli() {
        if (this.ruudukko.onTyhja()) {
            this.alusta.setPelinTila(PelinTila.PELAA);
        }
    }

    private Koordinaatit haeKoordinaatit(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();

        int rivi = y / XOAlusta.RUUDUN_SIVU;
        int sarake = x / XOAlusta.RUUDUN_SIVU;
        Koordinaatit k = new Koordinaatit(sarake, rivi);
        return k;
    }

    /**
     * Palauttaa juuri vuorossa olevan merkin.
     * @return RISTI tai NOLLA
     */
    public Merkki juuriVuorossa() {
        return this.vuorossa;
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
