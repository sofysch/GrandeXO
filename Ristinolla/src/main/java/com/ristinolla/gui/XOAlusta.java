/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import com.ristinolla.domain.PelinTila;
import com.ristinolla.logiikka.Ruudukko;
import com.ristinolla.logiikka.Ruutu;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import javax.swing.JPanel;

/**
 * Luo pelialustan, eli ruudukon, ja ruudut.
 *
 * @author Sofia
 */
public class XOAlusta extends JPanel {

    public static final int LEVEYS = 600;
    public static final int KORKEUS = 600;
    public static final int RUUDUN_SIVU = LEVEYS / 3;

    private Ruudukko ruudukko;
    private Ruutu ruutu;
    private Merkki vuorossa;
    private PelinTila tila;

    /**
     * Alustetaan tyhjä ruudukko ja lisätään alustalle mouseListener, alustetaan
     * vuorossa oleva merkki ja pelin tila sekä alustan koko ja taustaväri.
     * @param ruudukko ruudukko, joka piirretään
     */
    public XOAlusta(Ruudukko ruudukko) {
        setSize(LEVEYS, KORKEUS);
        super.setBackground(Color.LIGHT_GRAY);
        this.ruudukko = ruudukko;
        this.vuorossa = Merkki.RISTI;
        this.tila = PelinTila.PELAA;
        this.ruudukko.tyhjenna();
        addMouseListener(new PiirraMerkki(this, this.ruudukko));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.ruudukko.piirra(g);
        this.ruudukko.piirraRuudut(g);
    }

    /**
     * Palauttaa vuorossa olevan merkin.
     * @return RISTI tai NOLLA
     */
    public Merkki getVuorossa() {
        return this.vuorossa;
    }

    /**
     * Tarkistetaan, onko peli voitettu.
     * @param merkki RISTI tai NOLLA
     * @param koordinaatit ruudukon koordinaatit
     * @return true, jos voitto, muutoin false
     */
    public boolean tarkistaVoitto(Merkki merkki, Koordinaatit koordinaatit) {
        return this.ruudukko.voitto(getVuorossa(), koordinaatit);
    }
}
