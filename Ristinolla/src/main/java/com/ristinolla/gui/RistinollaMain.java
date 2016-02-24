/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.gui;

/**
 * Ristinolla-pelin main-luokka.
 *
 * @author Sofia
 */
import com.ristinolla.logiikka.Ruudukko;
import javax.swing.SwingUtilities;

public class RistinollaMain {

    /**
     * Main.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XOFrame peli = new XOFrame(new Ruudukko());
        SwingUtilities.invokeLater(peli);

        // TODO code application logic here
    }
}
