/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
import com.ristinolla.domain.PelinTila;
import com.ristinolla.logic.Ruudukko;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Luo pelialustan, eli piirtää ruudukon ja ruudut.
 *
 * @author Sofia
 */
public class XOAlusta extends JPanel {

    public static final int LEVEYS = 600;
    public static final int KORKEUS = 600;
    public static final int RUUDUN_SIVU = LEVEYS / 3;
    public int ruudukonLeveys;
    public int ruudukonKorkeus;
    private Ruudukko ruudukko;
    private JLabel viesti;
    private Merkki vuorossa;
    private PelinTila tila;
    private MerkinPiirtaja piirtaja;
    private int ristinVoitot;
    private int nollanVoitot;

    /**
     * Alustetaan tyhjä ruudukko ja lisätään alustalle mouseListener, alustetaan
     * vuorossa oleva merkki ja pelin tila sekä alustan koko ja taustaväri ja
     * lisäksi näkyvä viesti pelaajalle.
     *
     */
    public XOAlusta() {
        setSize(LEVEYS, KORKEUS);
        super.setBackground(Color.LIGHT_GRAY);
        this.ruudukko = new Ruudukko();
        this.ruudukonKorkeus = XOAlusta.RUUDUN_SIVU;
        this.ruudukonLeveys = XOAlusta.RUUDUN_SIVU;
        this.tila = PelinTila.PELAA;
        this.ruudukko.tyhjenna();
        this.vuorossa = Merkki.RISTI;
        this.nollanVoitot = 0;
        this.ristinVoitot = 0;
        this.piirtaja = new MerkinPiirtaja(this, this.ruudukko);
        addMouseListener(this.piirtaja);
        this.viesti = new JLabel("Risti aloittaa!");
        alustaViesti(this.viesti);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraRuudukko(g);
        piirraRuudut(g);
    }

    public Merkki getVuorossa() {
        return this.vuorossa;
    }

    public PelinTila getPelinTila() {
        return this.tila;
    }

    public void setPelinTila(PelinTila tila) {
        this.tila = tila;
    }

    /**
     * Alustaa uuden pelin tyhjentämällä ruudukon ja asettamalla viestin
     * pelaajalle.
     */
    public void alustaPeli() {
        this.ruudukko.tyhjenna();
        Merkki vuoro = this.piirtaja.juuriVuorossa();
        this.viesti.setForeground(Color.WHITE);
        this.viesti.setText(vuoro + " aloittaa!");
    }

    private void alustaViesti(JLabel viesti) {
        viesti.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        viesti.setBorder(BorderFactory.createEmptyBorder(2, 5, 4, 5));
        viesti.setOpaque(true);
        viesti.setBackground(Color.LIGHT_GRAY);
        viesti.setForeground(Color.WHITE);
        setLayout(new BorderLayout());
        add(viesti, BorderLayout.PAGE_END);
        setPreferredSize(new Dimension(LEVEYS, KORKEUS + 30));
    }

    /**
     * Päivittää pelaajalle näkyvän viestin pelin tilasta tai kumpi merkki tekee
     * seuraavan siirron ja lisää voittojen määrää tarvittaessa.
     *
     * @param tila pelin tila
     * @param merkki vuorossa oleva merkki, RISTI tai NOLLA
     */
    public void paivitaViesti(PelinTila tila, Merkki merkki) {
        switch (tila) {
            case PELAA:
                this.viesti.setForeground(Color.RED);
                if (merkki == Merkki.RISTI) {
                    this.viesti.setText("Risti vuorossa!");
                } else if (merkki == Merkki.NOLLA) {
                    this.viesti.setText("Nolla vuorossa!");
                }
                break;
            case TASAPELI:
                this.viesti.setForeground(Color.WHITE);
                viesti.setText("Tasapeli! " + haeVoitot());
                break;
            case O_VOITTI:
                this.viesti.setForeground(Color.yellow);
                this.nollanVoitot++;
                viesti.setText("Nolla voitti! Onnea! " + haeVoitot());
                break;
            case X_VOITTI:
                this.viesti.setForeground(Color.green);
                this.ristinVoitot++;
                viesti.setText("Risti voitti! Onnea! " + haeVoitot());
                break;
            default:
                viesti.setText(getVuorossa() + " aloittaa!");
                break;
        }
    }

    /**
     * Palauttaa ristin ja nollan voittojen määrän tekstinä.
     *
     * @return voittojen määrä
     */
    public String haeVoitot() {
        return "Tilanne: Risti " + this.ristinVoitot + " - Nolla " + this.nollanVoitot;
    }

    /**
     * Piirtää ruudukon.
     *
     * @param g graphics
     */
    public void piirraRuudukko(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(5, this.ruudukonKorkeus, XOAlusta.LEVEYS - 5, this.ruudukonKorkeus);
        g.drawLine(5, 2 * this.ruudukonKorkeus, XOAlusta.LEVEYS - 5, 2 * this.ruudukonKorkeus);
        g.drawLine(this.ruudukonLeveys, 5, this.ruudukonLeveys, XOAlusta.KORKEUS - 5);
        g.drawLine(this.ruudukonLeveys * 2, 5, this.ruudukonLeveys * 2, XOAlusta.KORKEUS - 5);
    }

    /**
     * Piirtää kaikki ruudukon ruudut.
     *
     * @param g Graphics
     */
    public void piirraRuudut(Graphics g) {
        BufferedImage nolla = null;
        BufferedImage risti = null;
        try {
            nolla = ImageIO.read(new File("NOLLA.png"));
            risti = ImageIO.read(new File("RISTI.png"));
        } catch (IOException ex) {
            System.out.println("Ristin ja nollan kuvia ei löydy");
            System.exit(1);
        }
        for (int rivi = 0; rivi < this.ruudukko.getRivit(); rivi++) {
            for (int sarake = 0; sarake < this.ruudukko.getSarakkeet(); sarake++) {
                Koordinaatit k = new Koordinaatit(rivi, sarake);
                if (this.ruudukko.haeRuutu(k).getTila() == Merkki.NOLLA) {
                    g.drawImage(nolla, k.getX() * XOAlusta.RUUDUN_SIVU + 10, k.getY() * XOAlusta.RUUDUN_SIVU + 10, null);
                } else if (this.ruudukko.haeRuutu(k).getTila() == Merkki.RISTI) {
                    g.drawImage(risti, k.getX() * XOAlusta.RUUDUN_SIVU + 10, k.getY() * XOAlusta.RUUDUN_SIVU + 10, null);
                }
            }
        }
    }
}
