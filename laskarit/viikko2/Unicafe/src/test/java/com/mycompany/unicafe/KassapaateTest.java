package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void kassapaatteellaOikeatArvot() {
        assertEquals(100000, kassa.kassassaRahaa()); 
        assertEquals(0, kassa.maukkaitaLounaitaMyyty()); 
        assertEquals(0, kassa.edullisiaLounaitaMyyty()); 
    }
    
    @Test
    public void edullinenOstoToimiiJosRahaa() {
        
        int vaihtoraha = kassa.syoEdullisesti(250);
        assertEquals(100000+240, kassa.kassassaRahaa());
        assertEquals(10, vaihtoraha);        
        assertEquals(1, kassa.edullisiaLounaitaMyyty()); 
        
    }
    
    @Test
    public void edullinenOstoToimiiJosEiRahaa() {
                
        int vaihtoraha = kassa.syoEdullisesti(230);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(230, vaihtoraha);        
        assertEquals(0, kassa.edullisiaLounaitaMyyty());  
        
    }
    
    @Test
    public void maukasOstoToimiiJosRahaa() {
        
        int vaihtoraha = kassa.syoMaukkaasti(410);
        assertEquals(100000+400, kassa.kassassaRahaa());
        assertEquals(10, vaihtoraha);        
        assertEquals(1, kassa.maukkaitaLounaitaMyyty()); 
        
    }
    
    @Test
    public void maukasOstoToimiiJosEiRahaa() {
                
        int vaihtoraha = kassa.syoMaukkaasti(390);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(390, vaihtoraha);        
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());  
        
    }
    
    @Test
    public void edullinenKorttiostoToimiiJosRahaa() {
        
        kortti = new Maksukortti(400);
        boolean ostos = kassa.syoEdullisesti(kortti);
        assertEquals(400-240, kortti.saldo());     
        assertEquals(true, ostos);   
        assertEquals(1, kassa.edullisiaLounaitaMyyty()); 
        
    }
    
    @Test
    public void edullinenKorttiostoToimiiJosEiRahaa() {
        
        kortti = new Maksukortti(200);
        boolean ostos = kassa.syoEdullisesti(kortti);
        assertEquals(200, kortti.saldo());     
        assertEquals(false, ostos);   
        assertEquals(0, kassa.edullisiaLounaitaMyyty()); 
        
    }
    
    @Test
    public void maukasKorttiostoToimiiJosRahaa() {
        
        kortti = new Maksukortti(400);
        boolean ostos = kassa.syoMaukkaasti(kortti);
        assertEquals(400-400, kortti.saldo());     
        assertEquals(true, ostos);   
        assertEquals(1, kassa.maukkaitaLounaitaMyyty()); 
        
    }
    
    @Test
    public void maukasKorttiostoToimiiJosEiRahaa() {
        
        kortti = new Maksukortti(200);
        boolean ostos = kassa.syoMaukkaasti(kortti);
        assertEquals(200, kortti.saldo());     
        assertEquals(false, ostos);   
        assertEquals(0, kassa.maukkaitaLounaitaMyyty()); 
        
    }
    
    @Test
    public void kortinLatausToimiiJosSummaYliNollan() {
        
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti,400);
        assertEquals(100000+400, kassa.kassassaRahaa()); 
        assertEquals(400, kortti.saldo()); 
        
    }
    
    @Test
    public void kortinLatausToimiiJosSummaAliNollan() {
        
        kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti,-100);
        assertEquals(100000, kassa.kassassaRahaa()); 
        assertEquals(0, kortti.saldo()); 
        
    }
    
}
