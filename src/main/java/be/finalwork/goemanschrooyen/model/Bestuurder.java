/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

/**
 *
 * @author root
 */
public class Bestuurder {
    private int bestuurderId;
    private String naam;

    public int getBestuurderId() {
        return bestuurderId;
    }

    public void setBestuurderId(int bestuurderId) {
        this.bestuurderId = bestuurderId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Bestuurder(int bestuurderId, String naam) {
        this.bestuurderId = bestuurderId;
        this.naam = naam;
    }
    
    public Bestuurder(){
        
    }
}
