/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Alustaa ja piirtää uuden pelin.
 *
 * @author Sofia
 */
public class UudenPelinAloittaja implements MouseListener {

    private XOAlusta alusta;

    /**
     * Pelialusta, jolle ruudukko piirtyy.
     *
     * @param alusta alusta, joka piirretään tyhjentämisen jälkeen uudestaan
     */
    public UudenPelinAloittaja(XOAlusta alusta) {
        this.alusta = alusta;

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        this.alusta.alustaPeli();
        this.alusta.repaint();

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
