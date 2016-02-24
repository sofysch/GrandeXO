/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ristinolla.domain;

/**
 * Luo x- ja y- koordinaatit.
 *
 * @author Sofia
 */
public class Koordinaatit {

    private int x;
    private int y;

    /**
     * Konstruktorille annetaan x - ja y-koordinaatit kokonaislukuina.
     *
     * @param x x-koordinaatti
     * @param y y-koordinaatti
     */
    public Koordinaatit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
