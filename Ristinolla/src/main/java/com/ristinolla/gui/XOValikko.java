/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.logiikka.Ruudukko;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luo valikon, joka tarjoaa mahdollisuuden uuden pelin
 * aloittamiseen, poistumiseen ja ruudukon tyhjentämiseen.
 *
 * @author Sofia
 */
public class XOValikko extends JPanel {
    private Ruudukko ruudukko;

    /**
     * Alustetaan valikko.
     * @param ruudukko ruudukko, jota muokataan
     */
    public XOValikko(Ruudukko ruudukko) {
        super(new GridLayout(1, 2));
        luoKomponentit();
        this.ruudukko = ruudukko;
    }

    private void luoKomponentit() {
        JButton uusiPeli = new JButton("Uusi peli");
        
        JButton poistu = new JButton("Poistu");

        UudenPelinAloittaja aloittaja = new UudenPelinAloittaja(this.ruudukko);
        uusiPeli.addMouseListener(aloittaja);

        add(uusiPeli);
        add(poistu);

    }

}
