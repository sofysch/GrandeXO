/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

/**
 * Ristinolla -pelin graafinen käyttöliittymä.
 *
 * @author Sofia
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class XOFrame implements Runnable {

    private JFrame frame;
    private XOValikko valikko;
    private XOAlusta alusta;

    /**
     * Alustetaan valikkko, ruudukko ja ikkunan koko ja väri.
     *
     */
    public XOFrame() {
        this.alusta = new XOAlusta();
        this.valikko = new XOValikko(this.alusta);
    }

    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setTitle("Ristinolla");
        frame.setPreferredSize(new Dimension(620, 690));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(this.alusta, BorderLayout.CENTER);
        container.add(this.valikko, BorderLayout.SOUTH);
    }

    public int getLeveys() {
        return this.frame.getWidth();
    }

    public int getKorkeus() {
        return this.frame.getHeight();
    }

}
