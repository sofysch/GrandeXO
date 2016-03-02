/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

import com.ristinolla.logiikka.Ruudukko;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Luo valikon, joka tarjoaa mahdollisuuden uuden pelin aloittamiseen ja
 * pelistä poistumiseen.
 *
 * @author Sofia
 */
public class XOValikko extends JPanel {

    
    private XOAlusta alusta;

    /**
     * Alustetaan valikko.
     *
     * @param alusta pelialusta
     */
    public XOValikko( XOAlusta alusta) {
        super(new GridLayout(1, 3));
       
        this.alusta = alusta;

        luoKomponentit();
    }

    private void luoKomponentit() {
        JButton uusiPeli = new JButton("Uusi peli");
        JButton poistu = new JButton("Poistu");
        JButton kumoa = new JButton("Kumoa");

        UudenPelinAloittaja aloittaja = new UudenPelinAloittaja(this.alusta);
        uusiPeli.addMouseListener(aloittaja);
        
        PelinSulkija sulkija = new PelinSulkija();
        poistu.addMouseListener(sulkija);

        add(uusiPeli);
        add(poistu);
        add(kumoa);

    }

}
