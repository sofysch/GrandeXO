/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Sulkee ikkunan ja lopettaa pelin.
 *
 * @author Sofia
 */
public class PelinSulkija implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {
        System.exit(0);
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
