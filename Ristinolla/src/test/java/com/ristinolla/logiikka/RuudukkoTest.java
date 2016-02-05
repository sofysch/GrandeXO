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
        Koordinaatit k = new Koordinaatit(1, 2);
        ruudukko.setMerkki(k, Merkki.RISTI);
        assertEquals(Merkki.RISTI, ruudukko.ruudunTila(k));
    }

    @Test
    public void eiVoiAsettaaTyhjaaMerkkia() {
        Koordinaatit k = new Koordinaatit(1, 0);
        ruudukko.setMerkki(k, Merkki.RISTI);
        ruudukko.setMerkki(k, Merkki.TYHJA);
        assertEquals(Merkki.RISTI, ruudukko.ruudunTila(k));
    }

    @Test
    public void voittosarakeRistiTunnistetaan() {
        ruudukko.setMerkki(new Koordinaatit(0, 0), Merkki.RISTI);
        ruudukko.setMerkki(new Koordinaatit(1, 0), Merkki.RISTI);
        Koordinaatit k = new Koordinaatit(2, 0);
        ruudukko.setMerkki(k, Merkki.RISTI);
        assertEquals(true, ruudukko.voitto(Merkki.RISTI, k));
    }

    @Test
    public void eiVoittoaJosRivillaEriMerkkeja() {
        ruudukko.setMerkki(new Koordinaatit(0, 0), Merkki.RISTI);
        ruudukko.setMerkki(new Koordinaatit(0, 1), Merkki.NOLLA);

        Koordinaatit k = new Koordinaatit(0, 2);
        ruudukko.setMerkki(k, Merkki.RISTI);
        assertEquals(false, ruudukko.voitto(Merkki.RISTI, k));
        assertEquals(false, ruudukko.voitto(Merkki.NOLLA, k));
    }

    @Test
    public void eiVoittoaJosRuudutTyhjia() {
        assertEquals(false, ruudukko.voitto(Merkki.TYHJA, new Koordinaatit(1, 1)));
    }

    @Test
    public void eiVoittoaJosVinorivillaEriMerkkeja() {
        ruudukko.setMerkki(new Koordinaatit(1, 1), Merkki.RISTI);
        ruudukko.setMerkki(new Koordinaatit(0, 0), Merkki.RISTI);
        Koordinaatit k = new Koordinaatit(2, 2);
        ruudukko.setMerkki(k, Merkki.NOLLA);
        assertEquals(false, ruudukko.voitto(Merkki.RISTI, k));
        assertEquals(false, ruudukko.voitto(Merkki.NOLLA, k));
    }

    @Test
    public void eiVoittoaJosTOisellaVinorivillaEriMerkkeja() {
        ruudukko.setMerkki(new Koordinaatit(0, 2), Merkki.NOLLA);
        ruudukko.setMerkki(new Koordinaatit(2, 0), Merkki.NOLLA);
        Koordinaatit k = new Koordinaatit(1, 1);
        ruudukko.setMerkki(k, Merkki.RISTI);
        assertEquals(false, ruudukko.voitto(Merkki.NOLLA, k));
        assertEquals(false, ruudukko.voitto(Merkki.RISTI, k));
    }

    @Test
    public void tunnistaaTaydenRuudukon() {
        for (int rivi = 0; rivi < ruudukko.getRivit(); rivi++) {
            for (int sarake = 0; sarake < ruudukko.getSarakkeita(); sarake++) {
                Koordinaatit k = new Koordinaatit(rivi, sarake);
                ruudukko.setMerkki(k, Merkki.RISTI);
            }
        }
        assertEquals(true, ruudukko.onTaynna());
    }

    @Test
    public void ruudukkoEiTaynnaJosJonkinRuudunTilaOnTyhja() {
        for (int rivi = 0; rivi < ruudukko.getRivit(); rivi++) {
            for (int sarake = 0; sarake < ruudukko.getSarakkeita(); sarake++) {
                Koordinaatit k = new Koordinaatit(rivi, sarake);
                ruudukko.setMerkki(k, Merkki.RISTI);
            }
            ruudukko.getRuutu(new Koordinaatit(1, 2)).tyhjenna();
        }
        assertEquals(false, ruudukko.onTaynna());
    }

    @Test
    public void tyhjentaaRuudukon() {
        ruudukko.setMerkki(new Koordinaatit(1, 2), Merkki.RISTI);
        ruudukko.setMerkki(new Koordinaatit(0, 2), Merkki.RISTI);
        boolean tyhja = ruudukko.tyhjenna();
        assertEquals(true, tyhja);
    }

}
