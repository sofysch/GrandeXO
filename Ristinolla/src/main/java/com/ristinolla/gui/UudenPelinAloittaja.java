/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.domain.Merkki;
import com.ristinolla.domain.PelinTila;
import com.ristinolla.logiikka.Ruudukko;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Aloittaa uuden pelin klikatessa. Työstetään.
 *
 * @author Sofia
 */
public class UudenPelinAloittaja implements MouseListener {

    private Ruudukko ruudukko;
    private XOAlusta alusta;
    private PelinTila tila;
    

    /**
     * Työn alla.
     *
     * @param ruudukko tyhjennettävä ruudukko
     * @param alusta alusta, joka piirretään tyhjentämisen jälkeen uudestaan
     */
    public UudenPelinAloittaja(Ruudukko ruudukko, XOAlusta alusta, PelinTila tila) {
        this.ruudukko = ruudukko;
        this.alusta = alusta;
        this.tila = tila;
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.ruudukko.tyhjenna();
        if (this.ruudukko.onTyhja()) {
            
            this.alusta.paivitaViesti(PelinTila.PELAA, Merkki.RISTI);
            this.alusta.alustaPeli();
            this.alusta.repaint();
           
            
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
