/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.ui;

/**
 *
 * @author Sofia
 */
import com.ristinolla.logiikka.Peli;
import javax.swing.SwingUtilities;
public class RistinollaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XOKayttoliittyma kayttoliittyma = new XOKayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
        // TODO code application logic here
    }
}
    

