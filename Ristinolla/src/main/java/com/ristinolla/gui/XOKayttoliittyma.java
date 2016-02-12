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

import com.ristinolla.logiikka.Ruudukko;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class XOKayttoliittyma implements Runnable {

    private JFrame frame;
    private XOValikko valikko;
    //private JButton[][] napit;
    private Ruudukko ruudukko;

    public XOKayttoliittyma(Ruudukko ruudukko) {
        //this.napit = new JButton[3][3];
        this.valikko = new XOValikko();
        this.ruudukko = ruudukko;

    }

    @Override
    public void run() {
        frame = new JFrame("Ristinolla");
        frame.setPreferredSize(new Dimension(350, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        XOAlusta alusta = new XOAlusta(this.ruudukko);
        container.add(alusta);
        container.add(this.valikko, BorderLayout.SOUTH);

//        GridLayout layout = new GridLayout(3,3);
//        container.setLayout(layout);
//        container.add(new JButton("1"));
//        container.add(new JButton("2"));
//        container.add(new JButton("3"));
//        container.add(new JButton("4"));
//        container.add(new JButton("5"));
//        container.add(new JButton("6"));
//        container.add(new JButton("7"));
//        container.add(new JButton("8"));
//        container.add(new JButton("9"));
    }

    private int getLeveys() {
        return this.frame.getWidth();
    }

    private int getKorkeus() {
        return this.frame.getHeight();
    }
}
