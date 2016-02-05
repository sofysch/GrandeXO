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
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class XOKayttoliittyma implements Runnable {
    private JFrame frame;
    
    public XOKayttoliittyma(){
        
    }

    @Override
    public void run() {
        frame = new JFrame("RISTINOLLA");
        frame.setPreferredSize(new Dimension(300, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        }
    
    private void luoKomponentit(Container container){
        container.add(new XOPelialusta());
        
    }
    
    
}
