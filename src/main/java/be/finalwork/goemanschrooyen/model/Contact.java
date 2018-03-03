/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.finalwork.goemanschrooyen.model;

/**
 *
 * @author SamGoeman
 */
public class Contact {
 private int contactId;
 private String naam, telnr;
 private Boolean isFavo;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelnr() {
        return telnr;
    }

    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }

    public Boolean getIsFavo() {
        return isFavo;
    }

    public void setIsFavo(Boolean isFavo) {
        this.isFavo = isFavo;
    }

    public Contact(int contactId, String naam, String telnr, Boolean isFavo) {
        this.contactId = contactId;
        this.naam = naam;
        this.telnr = telnr;
        this.isFavo = isFavo;
    }
 
 
    public Contact(){
        
    }
}
