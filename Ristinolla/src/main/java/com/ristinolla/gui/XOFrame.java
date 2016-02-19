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
import com.ristinolla.domain.Merkki;
import com.ristinolla.domain.PelinTila;
import com.ristinolla.logiikka.Ruudukko;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class XOFrame implements Runnable {

    private JFrame frame;
    private XOValikko valikko;
    private Merkki vuorossa;
    private Ruudukko ruudukko;
    private JLabel viesti;

    /**
     * Alustetaan valikkko, ruudukko, viesti ja sen fontti, lisäksi ikkunan 
     * koko ja väri.
     * @param ruudukko ruudukko
     */
    public XOFrame(Ruudukko ruudukko) {
        this.ruudukko = ruudukko;
        this.valikko = new XOValikko(ruudukko);
        this.viesti = new JLabel("non ci posso credere");
        this.viesti.setFont(new Font(Font.DIALOG_INPUT, Font.ROMAN_BASELINE, 14));
        this.viesti.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        this.viesti.setOpaque(true);
        this.viesti.setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(620, 690));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        XOAlusta alusta = new XOAlusta(this.ruudukko);
        container.add(alusta, BorderLayout.CENTER);
        container.add(this.valikko, BorderLayout.SOUTH);
        container.add(this.viesti, BorderLayout.PAGE_START);

    }

    private int getLeveys() {
        return this.frame.getWidth();
    }

    private int getKorkeus() {
        return this.frame.getHeight();
    }

}
