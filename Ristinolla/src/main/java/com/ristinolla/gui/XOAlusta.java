/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.logiikka.Ruudukko;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Luo pelialustan, eli ruudukon.
 *
 * @author Sofia
 */
public class XOAlusta extends JPanel {

    private Ruudukko ruudukko;

    public XOAlusta(Ruudukko ruudukko) {
        super.setBackground(Color.BLACK);
        this.ruudukko = ruudukko;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ruudukko.piirra(g);
    }
}
