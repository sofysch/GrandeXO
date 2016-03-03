/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.domain;

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
public class KoordinaatitTest {
    Koordinaatit koordinaatit;
    
    public KoordinaatitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        koordinaatit = new Koordinaatit(1,2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void koordinaatitLuodaan(){
        assertTrue(koordinaatit != null);
    }
    @Test
    public void oikeaXKoordinaatti(){
        assertEquals(1, koordinaatit.haeX());
    }
    @Test
    public void oikeaYKoordinaatti(){
        assertEquals(2, koordinaatit.haeY());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
