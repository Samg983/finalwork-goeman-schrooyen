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
public class Verbruik {
    private int verbruikId;
    private double brandstofNiveau, gemiddeldVerbruik;

    public int getVerbruikId() {
        return verbruikId;
    }

    public void setVerbruikId(int verbruikId) {
        this.verbruikId = verbruikId;
    }

    public double getBrandstofNiveau() {
        return brandstofNiveau;
    }

    public void setBrandstofNiveau(double brandstofNiveau) {
        this.brandstofNiveau = brandstofNiveau;
    }

    public double getGemiddeldVerbruik() {
        return gemiddeldVerbruik;
    }

    public void setGemiddeldVerbruik(double gemiddeldVerbruik) {
        this.gemiddeldVerbruik = gemiddeldVerbruik;
    }

    public Verbruik(int verbruikId, double brandstofNiveau, double gemiddeldVerbruik) {
        this.verbruikId = verbruikId;
        this.brandstofNiveau = brandstofNiveau;
        this.gemiddeldVerbruik = gemiddeldVerbruik;
    }
    
    public Verbruik(){
        
    }
}
