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
public class Instelling {
    private int instellingId;
    private boolean isGebruikerInstelling, isAan;
    private String naam, categorie;

    public int getInstellingId() {
        return instellingId;
    }

    public void setInstellingId(int instellingId) {
        this.instellingId = instellingId;
    }

    public boolean getIsGebruikerInstelling() {
        return isGebruikerInstelling;
    }

    public void setIsGebruikerInstelling(boolean isGebruikerInstelling) {
        this.isGebruikerInstelling = isGebruikerInstelling;
    }

    public boolean getIsAan() {
        return isAan;
    }

    public void setIsAan(boolean isAan) {
        this.isAan = isAan;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    

    public Instelling(int instellingId, boolean isGebruikerInstelling, boolean isAan, String naam, String categorie) {
        this.instellingId = instellingId;
        this.isGebruikerInstelling = isGebruikerInstelling;
        this.isAan = isAan;
        this.naam = naam;
        this.categorie = categorie;
    }
    
    
    public Instelling(){
        
    }
}
