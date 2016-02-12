/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.logiikka;

import com.ristinolla.domain.Koordinaatit;
import com.ristinolla.domain.Merkki;
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
public class PeliTest {

    Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void koordinaattienTestausToimii() {
        Koordinaatit k = new Koordinaatit(3, -1);
        assertEquals(false, peli.tarkistaKoordinaatit(k));

    }
    @Test
    public void luotuPeliOlemassa(){
        assertTrue(peli != null);
    }
    @Test
    public void vuorossaAlussaRisti(){
        assertEquals(Merkki.RISTI, peli.getVuorossa());
    }
    @Test
    public void tarkistaaVoitonOikein(){
        Koordinaatit eka= new Koordinaatit(0,0);
        Koordinaatit toka= new Koordinaatit(1,1);
        Koordinaatit kolmas= new Koordinaatit(2,2);
        peli.teeSiirto(eka);
        peli.teeSiirto(toka);
        peli.teeSiirto(kolmas);
        assertEquals(true, peli.tarkistaVoitto(Merkki.RISTI, kolmas));
    }
    @Test
    public void lisaaJalauttaaVoittojenMaaranOkein(){
        peli.lisaaVoitto(Merkki.RISTI);
        peli.lisaaVoitto(Merkki.RISTI);
        peli.lisaaVoitto(Merkki.NOLLA);
        assertEquals(2, peli.getRistinVoitot());
        assertEquals(1, peli.getNollanVoitot());
    }
    public void tulostaaTuloksetOikein(){
        peli.lisaaVoitto(Merkki.RISTI);
        assertEquals("Risti on voittanut 1 peliä. "
                + "Nolla on voittanut 0 peliä.",peli.tulostaVoitot());
    }
    
       
//        
//    }
    
    
}
