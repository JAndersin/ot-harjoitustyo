package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void kortinSaldoLuodessaOikein() {
        assertEquals(10, kortti.saldo());  
    }
    
    @Test
    public void rahanLisaysToimii() {
        kortti.lataaRahaa(10);
        assertEquals(20, kortti.saldo());  
    }
    
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(20);
        assertEquals(10, kortti.saldo());  
    }
    
    @Test
    public void otaRahaaPalauttaaOikeinBoolean() {
        assertEquals(false, kortti.otaRahaa(20));  
        assertEquals(true, kortti.otaRahaa(5));  
    }
    
    @Test
    public void toStringToimiiOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());  
    }
    
}
