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
public class RuutuTest {

    Ruutu ruutu;

    public RuutuTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ruutu = new Ruutu(1, 2);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void konstruktoriLuoSijainninOikein() {
        assertEquals("1,2", ruutu.getSijainti());
    }

    @Test
    public void konstruktoriLuoTyhjanRuudun() {
        assertEquals(Merkki.TYHJA, ruutu.getTila());
    }

    @Test
    public void metodiTyhjentaaRuudun() {
        ruutu.setMerkki(Merkki.RISTI);
        ruutu.tyhjenna();
        assertEquals(Merkki.TYHJA, ruutu.getTila());
    }

    @Test
    public void metodiAsettaaRuutuunRistin() {
        ruutu.setMerkki(Merkki.RISTI);
        assertEquals(Merkki.RISTI, ruutu.getTila());
    }
    @Test
    public void metodiAsettaaRuutuunNollan() {
        ruutu.setMerkki(Merkki.NOLLA);
        assertEquals(Merkki.NOLLA, ruutu.getTila());
    }

    @Test
    public void vainTyhjaanRuutuunVoiLaittaaMerkin() {
        ruutu.setMerkki(Merkki.RISTI);
        ruutu.setMerkki(Merkki.NOLLA);
        assertEquals(Merkki.RISTI, ruutu.getTila());
    }
}
