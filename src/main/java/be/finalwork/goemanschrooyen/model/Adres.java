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
public class Adres {
    private int adresId;
    private String bestemming;
    private boolean isFavoriet;

    public int getAdresId() {
        return adresId;
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }

    public String getBestemming() {
        return bestemming;
    }

    public void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public boolean getIsFavoriet() {
        return isFavoriet;
    }

    public void setIsFavoriet(boolean isFavoriet) {
        this.isFavoriet = isFavoriet;
    }

    public Adres(int adresId, String bestemming, boolean isFavoriet) {
        this.adresId = adresId;
        this.bestemming = bestemming;
        this.isFavoriet = isFavoriet;
    }
    
    public Adres(){
        
    }
}
