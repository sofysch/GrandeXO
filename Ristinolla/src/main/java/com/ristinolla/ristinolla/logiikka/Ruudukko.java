/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.ristinolla.logiikka;

/**
 *
 * @author Sofia
 */
public class Ruudukko {
    private int riveja;
    private int sarakkeita;
    private Ruutu[][] ruudukko;
    private Ruutu ruutu;
    
    public Ruudukko(int riveja, int sarakkeita){
        this.riveja = riveja;
        this.sarakkeita = sarakkeita;
        this.ruudukko = new Ruutu[this.riveja][this.sarakkeita];
        
    }
   
            
           
}
