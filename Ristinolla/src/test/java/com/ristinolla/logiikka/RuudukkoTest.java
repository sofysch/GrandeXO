/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sofia
 */
public class RuudukkoTest {

    Ruudukko ruudukko;

    public RuudukkoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruudukko = new Ruudukko();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void asettaaMerkinOikein() {
        ruudukko.setMerkki(1, 2, Merkki.RISTI);
        assertEquals(Merkki.RISTI, ruudukko.ruudunTila(1, 2));
    }
    @Test
    public void eiVoiAsettaaTyhjaaMerkkia(){
        ruudukko.setMerkki(1, 0, Merkki.RISTI);
        ruudukko.setMerkki(1, 0, Merkki.TYHJA);
        assertEquals(Merkki.RISTI, ruudukko.ruudunTila(1,0));
    }

    @Test
    public void voittosarakeRistiTunnistetaan() {
        ruudukko.setMerkki(0, 0, Merkki.RISTI);
        ruudukko.setMerkki(1, 0, Merkki.RISTI);
        ruudukko.setMerkki(2, 0, Merkki.RISTI);
        assertEquals(true, ruudukko.voitto(Merkki.RISTI, 0, 0));
    }

    @Test
    public void eiVoittoaJosRivillaEriMerkkeja() {
        ruudukko.setMerkki(0, 0, Merkki.RISTI);
        ruudukko.setMerkki(0, 1, Merkki.NOLLA);
        ruudukko.setMerkki(0, 2, Merkki.RISTI);
        assertEquals(false, ruudukko.voitto(Merkki.RISTI, 0, 2));
        assertEquals(false, ruudukko.voitto(Merkki.NOLLA, 0, 2));
    }

    @Test
    public void eiVoittoaJosRuudutTyhjia() {
        assertEquals(false, ruudukko.voitto(Merkki.TYHJA, 1, 1));
    }

    @Test
    public void eiVoittoaJosVinorivillaEriMerkkeja() {
        ruudukko.setMerkki(1, 1, Merkki.RISTI);
        ruudukko.setMerkki(0, 0, Merkki.RISTI);
        ruudukko.setMerkki(2, 2, Merkki.NOLLA);
        assertEquals(false, ruudukko.voitto(Merkki.RISTI, 2, 2));
        assertEquals(false, ruudukko.voitto(Merkki.NOLLA, 2, 2));
    }
    @Test
    public void eiVoittoaJosTOisellaVinorivillaEriMerkkeja(){
        ruudukko.setMerkki(0, 2, Merkki.NOLLA);
        ruudukko.setMerkki(2, 0, Merkki.NOLLA);
        ruudukko.setMerkki(1, 1, Merkki.RISTI);
        assertEquals(false, ruudukko.voitto(Merkki.NOLLA, 1, 1));
        assertEquals(false, ruudukko.voitto(Merkki.RISTI, 1, 1));
    }

    @Test
    public void tunnistaaTaydenRuudukon() {
        for (int rivi = 0; rivi < ruudukko.getRivit(); rivi++) {
            for (int sarake = 0; sarake < ruudukko.getSarakkeita(); sarake++) {
                ruudukko.setMerkki(rivi, sarake, Merkki.RISTI);
            }
        }
        assertEquals(true, ruudukko.onTaynna());
    }

    @Test
    public void ruudukkoEiTaynnaJosJonkinRuudunTilaOnTyhja() {
        for (int rivi = 0; rivi < ruudukko.getRivit(); rivi++) {
            for (int sarake = 0; sarake < ruudukko.getSarakkeita(); sarake++) {
                ruudukko.setMerkki(rivi, sarake, Merkki.RISTI);
            }
            ruudukko.getRuutu(1, 2).tyhjenna();
        }
        assertEquals(false, ruudukko.onTaynna());
    }
}
