/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.domain.PelinTila;
import com.ristinolla.logiikka.Ruudukko;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luo valikon, joka tarjoaa mahdollisuuden uuden pelin aloittamiseen ja
 * poistumiseen.
 *
 * @author Sofia
 */
public class XOValikko extends JPanel {

    private Ruudukko ruudukko;
    private XOAlusta alusta;

    /**
     * Alustetaan valikko.
     *
     * @param ruudukko ruudukko, jota muokataan
     * @param alusta pelialusta
     */
    public XOValikko(Ruudukko ruudukko, XOAlusta alusta) {
        super(new GridLayout(1, 2));
        this.ruudukko = ruudukko;
        this.alusta = alusta;

        luoKomponentit();
    }

    private void luoKomponentit() {
        JButton uusiPeli = new JButton("Uusi peli");

        JButton poistu = new JButton("Poistu");

        UudenPelinAloittaja aloittaja = new UudenPelinAloittaja(this.alusta);
        uusiPeli.addMouseListener(aloittaja);

        add(uusiPeli);
        add(poistu);

    }

}
